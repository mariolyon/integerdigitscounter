import java.lang.Number

object DigitsCounter {
  def countDigits(number: Number): Int = number.toString.split("\\.").head.size
}
