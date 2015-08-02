package biz.interretis.data_and_abstraction

import java.util.NoSuchElementException

import scala.annotation.tailrec

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
  def testCovariances(xs: List[NonEmpty], x: Empty): List[IntSet] = xs prepend x
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: List[Nothing] = throw new NoSuchElementException("Nil.tail")
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object List {

  def singleton[T](elem: T) =
    new Cons[T](elem, Nil)

  @tailrec
  def nth[T](n: Int, xs: List[T]): T =
    if (n < 0 || xs.isEmpty)
      throw new IndexOutOfBoundsException
    else if (n == 0)
      xs.head
    else
      nth(n - 1, xs.tail)

  def apply[T](): List[T] = Nil

  def apply[T](x1: T, x2: T): List[T] =
    new Cons(x1, new Cons(x2, Nil))

}