package digileo.demo

import munit.FunSuite
import digileo.demo.javaNumberFromString

class AppTest extends FunSuite {
  test("given numeric strings, then return java.lang.Number instances") {
    for (s <- Seq("123.456", "19", "0", "-1")) {
      assert(javaNumberFromString(s).isInstanceOf[java.lang.Number])
    }
  }

  test("given non numeric strings, then throw NumberFormatException") {
    for (s <- Seq("123.456.111", "abc")) {
      intercept[NumberFormatException] {
        javaNumberFromString(s)
      }
    }
  }
}
