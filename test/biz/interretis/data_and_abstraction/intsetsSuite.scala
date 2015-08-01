package biz.interretis.data_and_abstraction

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class intsetsSuite extends FunSuite {

  val empty = Empty
  val singletonSet = empty.incl(5)
  val set = singletonSet.incl(3)

  test("empty does not contain anything") {
    assert(!(empty contains 5))
  }

  test("non empty set contains some elements") {
    assert(set contains 3)
    assert(!(set contains 4))
  }

  test("sets have string representation") {
    assert(empty.makeString == "{}")
    assert(singletonSet.makeString == "{5}")
    assert(set.makeString == "{3, 5}")
  }
}