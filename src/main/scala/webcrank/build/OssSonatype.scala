package webcrank.build

import sbt._
import Keys._
import com.typesafe.sbt.pgp.PgpKeys._


object OssSonatype {
  type Sett = Project.Setting[_]

  def settings(site: String, git: String, license: License, devs: Seq[Developer]) = Seq[Sett](
      publishTo <<= version.apply(v => {
        val nexus = "https://oss.sonatype.org/"
        val isSnapshot = v.trim.endsWith("SNAPSHOT")
        val repo =
          if (isSnapshot)
            "snapshots" at nexus + "content/repositories/snapshots"
          else
            "releases"  at nexus + "service/local/staging/deploy/maven2"
        Some(repo)
      })
    , publishMavenStyle := true
    , publishArtifact in Test := false
    , pomIncludeRepository := { _ => false }
    , homepage := Some(url(site))
    , useGpg := true
    , licenses := Seq(license.name -> url(license.url))
    , pomExtra := (
      <scm>
        <url>{ git }</url>
        <connection>scm:{ git }</connection>
      </scm>
      <developers>
        { devs.map(developer(_)) }
      </developers>
    )
  )

  // FIX failing at xml, not sure how to make the conditional work without the dupe
  def developer(dev: Developer) =
    dev.url match {
      case None =>
        <developer>
          <id>dev.id</id>
          <name>dev.name</name>
        </developer>
      case Some(url) =>
        <developer>
          <id>dev.id</id>
          <name>dev.name</name>
          <url>url</url>
        </developer>
    }
}
