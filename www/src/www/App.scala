package www

import com.raquo.laminar.api.L.*

case class App() {
  private val colorVar = Var[Tag.ColorMod](_.Red)
  private val colorSignal = colorVar.signal.distinct

  def apply(): HtmlElement = {
    div(
      cls("space-y-4"),
      div(
        cls("flex gap-4"),
        button("Set Red", cls("cursor-pointer"), onClick --> Observer { _ => colorVar.set(_.Red) }),
        button(
          "Set Green",
          cls("cursor-pointer"),
          onClick --> Observer { _ => colorVar.set(_.Green) }
        ),
        button("Set Blue", cls("cursor-pointer"), onClick --> Observer { _ => colorVar.set(_.Blue) })
      ),
      Tag(
        label = "Red",
        color = colorSignal
      )()
    )
  }
}