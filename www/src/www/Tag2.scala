package www

import com.raquo.laminar.api.L.*

case class Tag2(label: String, color: Signal[Tag2.ColorMod]) {
  val colorCls = color.map(_(Tag2.Color)).map(c =>
    c match {
      case Tag2.Color.Red   => "bg-red-500"
      case Tag2.Color.Green => "bg-green-500"
      case Tag2.Color.Blue  => "bg-blue-500"
    }
  )
  def apply(): HtmlElement = {
    div(
      label,
      cls("px-4 py-2 rounded-md text-white"),
      cls <-- colorCls
    )
  }
}

object Tag2 {
  enum Color {
    case Red, Green, Blue
  }
  type ColorMod = Color.type => Color
}
