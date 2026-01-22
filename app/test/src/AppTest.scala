package digileo.demo

import munit.FunSuite
import digileo.demo.javaNumberFromString

class AppTest extends FunSuite {
  test("given numeric strings, then return Some java.lang.Number") {
    for (s <- Seq("123.456", "19", "0", "-1")) {
      val actual = javaNumberFromString(s)
      actual.isDefined
      assert(actual.get.isInstanceOf[java.lang.Number])
    }
  }

  test("given non numeric strings, return None") {
    for (s <- Seq("123.456.111", "abc")) {
        assert(javaNumberFromString(s).isEmpty)
    }
  }
}
