package biz.interretis.higher_order_functions

object HigherOrderFunctions extends App {

  def sum(f: Int => Int)(a: Int, b: Int): Int = {

    def loop(a: Int, acc: Int): Int =
      if (a > b)
        acc
      else
        loop(a + 1, f(a) + acc)

    loop(a, 0)
  }

  val result = sum(a => a)(1, 10)
  println("sum of 1 .. 10 : " + result)
}