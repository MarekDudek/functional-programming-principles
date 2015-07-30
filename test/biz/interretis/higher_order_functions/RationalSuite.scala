package biz.interretis.higher_order_functions

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalSuite extends FunSuite {

  val rational = new Rational(1, 2)
  val that = new Rational(2, 3)

  test("instances aren't equal") {
    assert(rational != new Rational(1, 2))
  }

  test("elements are accessible") {
    assert(rational.numer === 1)
    assert(rational.denom === 2)
  }

  test("addition") {
    val sum = rational add that
    assert(sum.toString === "7/6")
  }

  test("subtraction") {
    val difference = rational sub that
    assert(difference.toString === "-1/6")
  }

  test("negation") {
    val negative = rational.neg
    assert(negative.toString === "-1/2")
  }

  test("multiplication") {
    val product = rational mul that
    assert(product.toString === "1/3")
  }

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  test("expression") {
    val result = x add y mul z
    assert(result.toString === "11/7")
  }

  test("2/3 < 5/7") {
    val result = that less y
    assert(result === true)
  }

  test("max 2/3 5/7") {
    val maximum = that.max(y)
    assert(maximum === y)
  }

  intercept[IllegalArgumentException] {
    new Rational(1, 0)
  }

  test("second constructor") {
    val five = new Rational(5);
    assert(five.denom === 1)
  }
}