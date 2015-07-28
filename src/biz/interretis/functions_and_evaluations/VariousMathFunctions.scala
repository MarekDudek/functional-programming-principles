package biz.interretis.functions_and_evaluations

import scala.annotation.tailrec

object VariousMathFunctions extends App {

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  def tailFactorial(n: Int): Int = {

    @tailrec
    def tailFactorial(n: Int, acc: Int): Int =
      if (n == 1) acc
      else tailFactorial(n - 1, n * acc)

    tailFactorial(n, 1)
  }

  def cube = (x: Int) => x * x * x
}