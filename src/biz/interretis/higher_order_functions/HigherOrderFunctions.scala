package biz.interretis.higher_order_functions

import scala.annotation.tailrec

object HigherOrderFunctions extends App {

  def sum(f: Int => Int)(a: Int, b: Int): Int = {

    @tailrec
    def sum(a: Int, acc: Int): Int =
      if (a > b)
        acc
      else
        sum(a + 1, f(a) + acc)

    sum(a, 0)
  }

  def sumF(f: Int => Int): (Int, Int) => Int = {

    def sumF(a: Int, b: Int): Int =
      if (a > b)
        0
      else
        f(a) + sumF(a + 1, b)

    sumF
  }

  def sumF2(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      f(a) + sumF2(f)(a + 1, b)
  }
}