package digileo.demo

import java.lang.NumberFormatException

import DigitsCounter._

@main def run(string: String): Unit = {

  val number =
    try {
      javaNumberFromString(string)
    } catch {
      case _: NumberFormatException =>
        Console.err.println("Error: given string is an invalid number")
        sys.exit(-1)
    }

  val result = countDigits(number)
  println(result)
}

def javaNumberFromString(string: String): java.lang.Number =
  new java.math.BigDecimal(string)
