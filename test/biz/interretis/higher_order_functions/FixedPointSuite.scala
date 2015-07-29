package biz.interretis.higher_order_functions

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalactic.TolerantNumerics

@RunWith(classOf[JUnitRunner])
class FixedPointSuite extends FunSuite {

  import biz.interretis.higher_order_functions.FixedPoint._

  val epsilon = 0.01
  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(epsilon)

  test("fix point") {
    val result = fixedPoint(x => 1 + x / 2)(0)
    assert(result === 2.0)
  }

  test("sqrt 4 is 2") {
    val sqrt = squareRoot(4.0)
    assert(sqrt === 2.0)
  }

  test("sqrt 1/100 is 1/10") {
    val sqrt = squareRoot(1e-6)
    assert(sqrt === 1e-3)
  }

  test("sqrt of really small number") {
    val sqrt = squareRoot(1e-60)
    assert(sqrt === 1e-30)
  }

  test("sqrt of large number") {
    val sqrt = squareRoot(1e6)
    assert(sqrt === 1e3)
  }
}