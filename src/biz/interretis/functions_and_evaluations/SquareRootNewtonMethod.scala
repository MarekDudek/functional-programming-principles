package biz.interretis.functions_and_evaluations

object SquareRootNewtonMethod extends App {

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double = {

      def isGoodEnough(guess: Double) =
        Math.abs(guess * guess - x) / x < 0.001

      def improve(guess: Double) =
        (guess + x / guess) / 2

      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }

    sqrtIter(1.0)
  }
}