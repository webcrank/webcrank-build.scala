package webcrank.build

import sbt._
import Keys._

object MetadataGenerator {
  type Sett = Project.Setting[_]

  def settings(packagename: String) = Seq[Sett](
    metadata(packagename)
  )

  def metadata(packagename: String) =
    sourceGenerators in Compile <+=
      (sourceManaged in Compile, version, name).map((d, v, n) => {
        val file = d / "meta.scala"
        IO.write(file, """package %s
                         |object Meta {
                         |  val name = "%s"
                         |  val version = "%s"
                         |}
                         |""".stripMargin.format(packagename, n, v))
        Seq(file)
      })
}
