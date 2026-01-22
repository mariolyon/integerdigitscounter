import digileo.demo.DigitsCounter._

import munit.FunSuite

class DigitsCounterTests extends FunSuite {
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
