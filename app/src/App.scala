package digileo.demo

import java.lang.NumberFormatException

import DigitsCounter._

@main def run(args: String*): Unit = {
  if (args.isEmpty || args.size > 1) {
    printUsage()
  } else {
    val string = args.head
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
}

def printUsage(): Unit =
  println("""
            ||Integer Digits Counter|
            |Example Usage: ./mill app.run -1234.12
            |           Or: ./mill app.run 4355
    """.stripMargin)

def javaNumberFromString(string: String): java.lang.Number =
  new java.math.BigDecimal(string)
