package webcrank.build

import sbt._
import Keys._

object WebcrankSettings {
  type Sett = Project.Setting[_]

  def settings = Seq[Sett](
    organization := "io.webcrank"
  )
}
