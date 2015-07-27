package biz.interretis.functions_and_evaluations

object Termination extends App {

  def loop: Int = {
    println(".")
    loop
  }

  def first(x: Int, y: Int) = {
    x
    println("done")
  }

  def second(x: Int, y: => Int) = {
    x
    println("done")
  }

  // first(1, loop)
  // first(loop, 1)
  // second(loop, 1)
  second(1, loop)
}