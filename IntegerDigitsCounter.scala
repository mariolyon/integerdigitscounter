package digileo.demo

import java.lang.NumberFormatException

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
            |Example Usage: scala-cli . -- -1234.12
    """.stripMargin)

protected def javaNumberFromString(string: String): Option[java.lang.Number] =
  try {
    Some(new java.math.BigDecimal(string))
  } catch {
    case _: NumberFormatException => None
  }

protected def countDigits(number: Number): Int =
  number.toString.split("[-.]").filter(_.size > 0).head.size
