package www

import com.raquo.laminar.api.L.*

object TagImplicits {
  /**
   * Implicit conversion from Signal[Tag.Color] to Signal[Tag.ColorMod]
   * This allows you to pass a Signal[Tag.Color] directly to Tag's color property
   * without manually calling .map(Tag.colorProp)
   */
  given colorSignalConversion: Conversion[Signal[Tag.Color], Signal[Tag.ColorMod]] = 
    _.map(Tag.colorProp)
}
