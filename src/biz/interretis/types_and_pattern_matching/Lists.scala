package biz.interretis.types_and_pattern_matching

import org.scalatest.fixture.FunSpec
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

object Lists extends App {

  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty = List()

  fruit match {
    case Nil     => println("empty")
    case x :: xs => println("x: " + x + ", xs: " + xs)
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case y :: ys =>
      if (x < y) x :: xs
      else y :: insert(x, ys)
  }

  def isort(xs: List[Int]): List[Int] = xs match {
    case Nil     => Nil
    case y :: ys => insert(y, isort(ys))
  }

}

@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  val unsorted = List(3, 5, 1, 2, 4)
  val sorted = List(1, 2, 3, 4, 5)

  test("insertion sort") {
    assert(Lists.isort(unsorted) === sorted)
  }
}