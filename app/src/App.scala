package digileo.demo

import java.lang.NumberFormatException

import DigitsCounter._

@main def run(args: String*): Unit =
  if (args.isEmpty || args.size > 1) {
    printUsage()
  } else {
    val string = args.head
    javaNumberFromString(string) match {
      case Some(number) =>
        val result = countDigits(number)
        println(result)
      case _ =>
        Console.err.println("Error: given string is an invalid number")
        sys.exit(-1)
    }
  }

private def printUsage(): Unit =
  println("""
            ||Integer Digits Counter|
            |Example Usage: ./mill app.run -1234.12
            |           Or: ./mill app.run 4355
    """.stripMargin)

protected def javaNumberFromString(string: String): Option[java.lang.Number] =
  try {
    Some(new java.math.BigDecimal(string))
  } catch {
    case _: NumberFormatException => None
  }
