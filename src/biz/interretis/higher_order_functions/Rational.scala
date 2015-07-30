package biz.interretis.higher_order_functions

import scala.annotation.tailrec

class Rational(x: Int, y: Int) {

  require(y != 0, "denominator must be nonzero")

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0)
      a
    else
      gcd(b, a % b)

  import scala.math.abs

  def this(x: Int) = this(x, 1)

  def numer = x / abs(gcd(x, y))
  def denom = y / abs(gcd(x, y))

  def add(that: Rational) = {
    val nominator = numer * that.denom + denom * that.numer
    val denominator = denom * that.denom
    new Rational(nominator, denominator)
  }

  def mul(that: Rational) = {
    val nominator = numer * that.numer
    val denominator = denom * that.denom
    new Rational(nominator, denominator)
  }

  def neg =
    new Rational(-numer, denom)

  def sub(that: Rational) =
    add(that.neg)

  def less(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this less that)
      that
    else
      this

  override def toString =
    numer + "/" + denom
}

