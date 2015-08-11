package biz.interretis.collections

object vectors {

  import scala.language.postfixOps

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
    val pairs = xs zip ys
    val products = pairs map { case (x, y) => x * y }
    products sum
  }

  def isPrime(n: Int): Boolean = {
    def divides(div: Int): Boolean = n % div == 0
    val divisors = (2 to n / 2)
    !divisors.exists(divides)
  }
}