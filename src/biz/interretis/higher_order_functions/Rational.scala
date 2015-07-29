package biz.interretis.higher_order_functions

import scala.annotation.tailrec

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

class Rational(x: Int, y: Int) {

  def numer = x
  def denom = y

  import biz.interretis.functions_and_evaluations.VariousMathFunctions.gcd
  import java.lang.Math.abs

  def add(that: Rational) = {
    val nominator = numer * that.denom + denom * that.numer
    val denominator = denom * that.denom
    val common = abs(gcd(nominator, denominator))
    new Rational(nominator / common, denominator / common)
  }

  def mul(that: Rational) = {
    val nominator = numer * that.numer
    val denominator = denom * that.denom
    val common = abs(gcd(nominator, denominator))
    new Rational(nominator / common, denominator / common)
  }

  def neg =
    new Rational(-numer, denom)

  def sub(that: Rational) =
    add(that.neg)

  override def toString = numer + "/" + denom
}

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
}