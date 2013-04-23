package webcrank.build

import sbtrelease.ReleasePlugin

object StandardProject {
  def settings(packagename: String, site: String, git: String, license: License, devs: Seq[Developer]) =
    WebcrankSettings.settings ++
    MetadataGenerator.settings(packagename) ++
    Resolvers.settings ++
    ScalacOptions.settings ++
    OssSonatype.settings(site, git, license, devs) ++
    ReleasePlugin.releaseSettings
}
