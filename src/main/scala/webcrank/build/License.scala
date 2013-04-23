package webcrank.build

case class License(name: String, url: String)

object License {
  object BSD3 extends License(
    "BSD-3-Clause",
    "http://www.opensource.org/licenses/BSD-3-Clause"
  )
}
