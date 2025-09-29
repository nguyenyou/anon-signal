package www

import com.raquo.laminar.api.L.*

case class App() {
  val colorVar = Var[Tag2.ColorMod](_.Red)
  val colorSignal = colorVar.signal.distinct

  def apply(): HtmlElement = {
    div(
      cls("space-y-4"),
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
      ),
      div(
        cls("flex gap-4"),
        Tag1(
          label = "Red",
          color = _.Red
        )(),
        Tag1(
          label = "Green",
          color = _.Green
        )(),
        Tag1(
          label = "Blue",
          color = _.Blue
        )()
      ),
      div(
        cls("flex gap-4"),
        button("Set Red", onClick --> Observer { _ => colorVar.set(_.Red)}),
        button("Set Green", onClick --> Observer { _ => colorVar.set(_.Green)}),
        button("Set Blue", onClick --> Observer { _ => colorVar.set(_.Blue)}),
        Tag2(
          label = "Red",
          color = colorSignal
        )(),
      )
    )
  }
}