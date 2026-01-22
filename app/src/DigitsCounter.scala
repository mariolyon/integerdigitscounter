package digileo.demo

import java.lang.Number

object DigitsCounter {
  def countDigits(number: Number): Int =
    number.toString.split("[-.]").filter(_.size > 0).head.size
}
