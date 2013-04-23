package webcrank.build

import sbt._
import Keys._

object ScalacOptions {
  type Sett = Project.Setting[_]

  val scala29 = Seq(
    "-Ydependent-method-types"
  )

  val scala210 = Seq(
    "-Yinline-warnings",
    "-Yno-adapted-args",
    "-feature",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:postfixOps"
  )

  val all = Seq(
    "-deprecation",
    "-unchecked",
    "-optimise",
    "-Ywarn-all",
    "-Xfatal-warnings"
  )

  def settings = Seq[Sett](
    scalacOptions <++= scalaVersion.map(v =>
      all ++ (if (v.startsWith("2.10")) scala210 else scala29))
  )
}
