package biz.interretis.higher_order_functions

object FixedPoint {

  import java.lang.Math.abs

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = {
    abs((x - y) / x) / x < tolerance
  }

  def averageDamp(f: Double => Double)(x: Double) =
    (x + f(x)) / 2

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {

    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next))
        next
      else
        iterate(next)
    }

    iterate(firstGuess)
  }

  def squareRoot(x: Double): Double = {
    fixedPoint(averageDamp(y => x / y))(1)
  }
}