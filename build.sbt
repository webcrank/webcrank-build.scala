organization := "io.webcrank"

name := "webcrank-build"

sbtPlugin := true

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.2")

releaseSettings

useGpg := true

resolvers ++= Seq(
  "oss snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "oss releases" at "http://oss.sonatype.org/content/repositories/releases"
)

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("BSD-3-Clause" -> url("http://www.opensource.org/licenses/BSD-3-Clause"))

homepage := Some(url("http://webcrank.io"))

pomExtra := (
      <scm>
        <url>git@github.com:webcrank/webcrank-build.scala.git</url>
        <connection>scm:git:git@github.com:webcrank/webcrank/webcrank-build.scala.git</connection>
      </scm>
      <developers>
        <developer>
          <id>mth</id>
          <name>Mark Hibberd</name>
          <url>http://mth.io</url>
        </developer>
      </developers>
)

publishTo <<= version.apply(v => {
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
})
