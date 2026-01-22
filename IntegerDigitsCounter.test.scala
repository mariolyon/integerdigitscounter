// IntegerDigitsCounter.test.scala
//> using test.dep "org.scalameta::munit::1.0.0"

package digileo.demo

import digileo.demo._
import munit.FunSuite

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


class CountDigitsTests extends FunSuite {
  test("given a double number, it should return the number of integer digits") {
    assertEquals(countDigits(java.lang.Double("123.456")), 3)
  }

  test("given a negative double number, it should return the number of integer digits") {
    assertEquals(countDigits(java.lang.Double("-123.456")), 3)
  }

  test("given an integer number, it should return the number of digits") {
    assertEquals(countDigits(java.lang.Integer(1234)), 4)
  }
  test("given a negative integer number, it should return the number of digits") {
    assertEquals(countDigits(java.lang.Integer(-1234)), 4)
  }

  test("given 0, it should return 1") {
    assertEquals(countDigits(0), 1)
  }

  test("given -0, it should return 1") {
    assertEquals(countDigits(0), 1)
  }

  test("given a number longer than then maximum or minimum of a long, it should return the correct number of digits") {
    for (n <- Seq(Long.MinValue, Long.MaxValue)) {
      val baseNumber = new java.math.BigDecimal(n)
      val digitsCountOfBaseNumber = countDigits(baseNumber)
      assertEquals(countDigits(baseNumber.multiply(new java.math.BigDecimal(10))), digitsCountOfBaseNumber + 1)
    }
  }

  test("given a number longer than then maximum or minimum of a double, it should return the correct number of digits") {
    for (n <- Seq(Double.MinValue, Double.MaxValue)) {
      val baseNumber = new java.math.BigDecimal(n)
      val digitsCountOfBaseNumber = countDigits(baseNumber)
      assertEquals(countDigits(baseNumber.multiply(new java.math.BigDecimal(10))), digitsCountOfBaseNumber + 1)
    }
  }
}
