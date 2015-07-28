package biz.interretis.higher_order_functions

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HigherOrderFunctionsSuite extends FunSuite {

  import HigherOrderFunctions._
  import biz.interretis.functions_and_evaluations.VariousMathFunctions.{ tailFactorial => factorial }

  test("sum of 1..10") {
    assert(sum(x => x, 1, 10) == 55)
  }

  test("sum of squares of 1..10") {
    assert(sum(x => x * x, 1, 10) == 385)
  }

  test("sum of factorials of 1..10") {
    assert(sum(x => factorial(x), 1, 10) == 4037913)
  }
}