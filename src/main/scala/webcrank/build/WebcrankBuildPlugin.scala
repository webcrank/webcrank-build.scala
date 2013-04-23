package webcrank.build

import sbt._

object WebcrankBuildPlugin extends Plugin {
  type Sett = Project.Setting[_]

  object webcrank {
    val scalac = ScalacOptions.settings
    val sonatype = OssSonatype.settings _
    val resolvers = Resolvers.settings
    val standard = StandardProject.settings _
    val metadata = MetadataGenerator.settings _

    val developer = Developer.apply _
    val license = License.apply _
    val licenses = License
  }
}
