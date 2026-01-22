import DigitsCounter.countDigits
import munit.FunSuite

class DigitsCounterTests extends FunSuite {
  test("given a double number, it should return the number of integer digits") {
    assertEquals(countDigits(java.lang.Double("123.456")), 3)
  }

  test("given a integer number, it should return the number of digits") {
    assertEquals(countDigits(java.lang.Integer(1234)), 4)
  }

  test("given 0, it should return 1") {
    assertEquals(countDigits(0), 1)
  }
}
