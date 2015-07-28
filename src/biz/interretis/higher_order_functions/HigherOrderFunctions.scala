package biz.interretis.higher_order_functions

import scala.annotation.tailrec

object HigherOrderFunctions extends App {

  def sum(f: Int => Int, a: Int, b: Int): Int = {

    @tailrec
    def sum(a: Int, acc: Int): Int =
      if (a > b)
        acc
      else
        sum(a + 1, f(a) + acc)

    sum(a, 0)
  }

  val result = sum(a => a, 1, 10)
  println("sum of 1 .. 10 : " + result)
}