package webcrank.build

import sbt._

object WebcrankBuildPlugin extends Plugin {
  type Sett = Project.Setting[_]

  object webcrank {
    val scalac = ScalacOptions.settings
    val sonatype = OssSonatype.settings _
  }
}
