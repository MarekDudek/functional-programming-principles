package biz.interretis.data_and_abstraction

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.language.postfixOps

@RunWith(classOf[JUnitRunner])
class ListSuite extends FunSuite {

  val empty = new Nil[Int]
  val singletonList = new Cons(1, empty)
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  test("list can be checked for empty") {
    assert(empty isEmpty)
    assert(!(singletonList isEmpty))
    assert(!(list isEmpty))
    assert(!(list.tail isEmpty))
  }

  intercept[RuntimeException] {
    empty.head
  }

  test("list has head") {
    assert(list.head === 1)
  }

  intercept[RuntimeException] {
    empty.tail
  }

  test("list has tail") {
    assert(!list.tail.isEmpty)
  }
}