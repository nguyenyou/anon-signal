package www

import com.raquo.laminar.api.L.*

case class App() {
  def apply(): HtmlElement = {
    div(
      cls("flex gap-4"),
      Tag(
        label = "Red",
        color = "red"
      )(),
      Tag(
        label = "Green",
        color = "green"
      )(),
      Tag(
        label = "Blue",
        color = "blue"
      )()
    )
  }
}
