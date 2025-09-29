package www

import com.raquo.laminar.api.L.*
import TagImplicits.given

case class App() {
  private val textVar = Var("")
  private val textSignal = textVar.signal
  private val characterCountSignal = textSignal.map(_.length)

  private val tagColorSignal: Signal[Tag.Color] = 
    characterCountSignal.map(num => if (num % 2 == 0) Tag.Color.Red else Tag.Color.Green).distinct

  def apply(): HtmlElement = {
    div(
      cls("space-y-4"),
      div(
        cls("space-y-2"),
        div(
          "CurrentValue: ",
          text <-- textSignal
        ),
        div(
          "Count characters: ",
          text <-- characterCountSignal
        ),
        input(
          cls("border border-gray-200"),
          value <-- textSignal,
          onInput.mapToValue --> textVar
        )
      ),
      Tag(
        label = "Signal Red",
        color = tagColorSignal
      )(),
      div(
        cls("flex gap-4"),
        TagSimple(
          label = "Simple Blue",
          color = TagSimple.Color.Blue
        )(),
        TagSimple(
          label = "Simple Red",
          color = TagSimple.Color.Red
        )(),
        TagSimple(
          label = "Simple Green",
          color = TagSimple.Color.Green
        )()
      ),
      div(
        cls("flex gap-4"),
        TagSimple(
          label = "Simple Blue",
          color = _.Blue
        )(),
        TagSimple(
          label = "Simple Red",
          color = _.Red
        )(),
        TagSimple(
          label = "Simple Green",
          color = _.Green
        )()
      )
    )
  }
}