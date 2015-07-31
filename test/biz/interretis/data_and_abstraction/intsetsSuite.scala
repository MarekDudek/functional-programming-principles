package biz.interretis.data_and_abstraction

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class intsetsSuite extends FunSuite {

  val empty = new Empty
  val numbers = empty.incl(5).incl(3)

  test("empty does not contain anything") {
    assert(!(empty contains 1))
  }

  test("non empty set contains some elements") {
    assert(numbers contains 3)
    assert(!(numbers contains 4))
  }

  test("sets have string representation") {
    assert(numbers.makeString == "{3, 5}")
    assert(empty.makeString == "{}")
  }
}