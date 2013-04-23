package webcrank.build

import sbt._
import Keys._

object Resolvers {
  type Sett = Project.Setting[_]

  def settings = Seq[Sett](
    resolvers ++= Seq(
      "oss snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
      "oss releases" at "http://oss.sonatype.org/content/repositories/releases"
    )
  )
}
