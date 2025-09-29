package www

import com.raquo.laminar.api.L.*

case class App() {
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
        Tag2(
          label = "Red",
          color = Val(_.Red)
        )(),
        Tag2(
          label = "Green",
          color = Val(_.Green)
        )(),
        Tag2(
          label = "Blue",
          color = Val(_.Blue)
        )()
      )
    )
  }
}