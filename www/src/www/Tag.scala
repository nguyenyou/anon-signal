package www

import com.raquo.laminar.api.L.*

type Color = "red" | "green" | "blue"

case class Tag(label: String, color: Color) {
  val colorCls = color match {
    case "red" => "bg-red-500"
    case "green" => "bg-green-500"
    case "blue" => "bg-blue-500"
  }
  def apply(): HtmlElement = {
    div(
      label,
      cls(colorCls, "px-4 py-2 rounded-md text-white"),
    )
  }
}
