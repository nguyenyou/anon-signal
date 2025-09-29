package www

import com.raquo.laminar.api.L.*

case class Tag(label: String, color: Signal[Tag.ColorMod]) {
  
  val colorCls: Signal[String] = color.map(_(Tag.Color)).map {
    case Tag.Color.Red => "bg-red-500"
    case Tag.Color.Green => "bg-green-500"
    case Tag.Color.Blue => "bg-blue-500"
  }
  def apply(): HtmlElement = {
    div(
      label,
      cls("px-4 py-2 rounded-md text-white"),
      cls <-- colorCls
    )
  }
}

object Tag {
  enum Color {
    case Red, Green, Blue
  }
  type ColorMod = Color.type => Color
  
  def colorProp(color: Color): Tag.ColorMod = {
    color match {
      case Color.Red => _.Red
      case Color.Green => _.Green
      case Color.Blue => _.Blue
    }
  }
}