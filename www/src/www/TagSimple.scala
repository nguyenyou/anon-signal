package www

import com.raquo.laminar.api.L.*

case class TagSimple(label: String, color: TagSimple.ColorMod) {
  private val colorObj = color(TagSimple.Color)
  private val colorCls = colorObj match {
    case TagSimple.Color.Red => "bg-red-500"
    case TagSimple.Color.Green => "bg-green-500"
    case TagSimple.Color.Blue => "bg-blue-500"
  }
  
  def apply(): HtmlElement = {
    div(
      label,
      cls(colorCls, "px-4 py-2 rounded-md text-white"),
    )
  }
}

object TagSimple {
  enum Color {
    case Red, Green, Blue
  }
  type ColorMod = Color.type => Color

  def colorProp(color: Color): TagSimple.ColorMod = {
    color match {
      case Color.Red => _.Red
      case Color.Green => _.Green
      case Color.Blue => _.Blue
    }
  }
}