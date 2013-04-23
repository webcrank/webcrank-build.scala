package webcrank.build

import sbt._
import Keys._
import com.typesafe.sbt.pgp.PgpKeys._

object OssSonatype {
  type Sett = Project.Setting[_]

  case class Developer(id: String, name: String, url: Option[String])
  case class License(name: String, url: String)
  object BSD3
       extends License("BSD-3-Clause", "http://www.opensource.org/licenses/BSD-3-Clause")


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
    , pomExtra := (
      <scm>
        <url>{ git }</url>
        <connection>scm:{ git }</connection>
      </scm>
      <developers>
        {
          devs.map(dev =>
            <developer>
              <id>dev.id</id>
              <name>dev.name</name>
              { dev.url.map(u => <url>{ u }</url>) }
            </developer>
          )
        }
      </developers>
    )
  )

}
