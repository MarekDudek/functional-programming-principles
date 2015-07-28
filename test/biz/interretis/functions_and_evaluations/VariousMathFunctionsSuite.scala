package biz.interretis.functions_and_evaluations

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VariousMathFunctionsSuite extends FunSuite {

  import VariousMathFunctions._

  test("gdc of 14 and 21 is 7") {
    assert(gcd(14, 21) === 7)
  }

  test("5! is 120") {
    assert(factorial(5) === 120)
  }

  test("5! is 120 with tail recursion") {
    assert(tailFactorial(5) === 120)
  }

  test("cube") {
    assert(cube(5) === 125)
  }
}