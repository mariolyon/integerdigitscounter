import DigitsCounter._

@main def run(string: String): Unit = {
  val number: java.lang.Number = BigDecimal(string)
  println(countDigits(number))
}
