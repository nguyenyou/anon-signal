package www

import com.raquo.laminar.api.L.*

case class Tag1(label: String, color: Tag1.ColorMod) {
  val colorObj = color(Tag1.Color)
  val colorCls = colorObj match {
    case Tag1.Color.Red => "bg-red-500"
    case Tag1.Color.Green => "bg-green-500"
    case Tag1.Color.Blue => "bg-blue-500"
  }
  def apply(): HtmlElement = {
    div(
      label,
      cls(colorCls, "px-4 py-2 rounded-md text-white"),
    )
  }
}

object Tag1 {
  enum Color {
    case Red, Green, Blue
  }
  type ColorMod = Color.type => Color
}