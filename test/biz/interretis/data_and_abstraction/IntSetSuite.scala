package biz.interretis.data_and_abstraction

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class intsetsSuite extends FunSuite {

  val empty = new Empty
  val singletonSet = empty.incl(5)
  val set = singletonSet.incl(3)

  val one = new Empty incl 1 incl 3 incl 5 incl 7 incl 9
  val two = new Empty incl 2 incl 4 incl 6 incl 8 incl 10

  val sum = new Empty incl 1 incl 2 incl 3 incl 4 incl 5 incl 6 incl 7 incl 8 incl 9 incl 10

  test("empty does not contain anything") {
    assert(!(empty contains 5))
  }

  test("non empty set contains some elements") {
    assert(set contains 3)
    assert(!(set contains 4))
  }

  test("sets have string representation") {

    assert(empty.makeString === "{}")

    assert(singletonSet.makeString === "{5}")
    assert(set.makeString === "{3, 5}")

    assert(one.makeString === "{1, 3, 5, 7, 9}")
    assert(two.makeString === "{2, 4, 6, 8, 10}")
    assert(sum.makeString === "{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}")
  }

  test("union of sets") {
    assert((one union two).makeString === sum.makeString)
  }

  test("filter") {
    val even = sum.filter(x => x % 2 == 0)
    assert(even.makeString == two.makeString)
  }

  test("assert all positive") {
    assert(IntSet.assertAllPos(empty) === empty);
    assert(IntSet.assertAllPos(set) === set);
  }  
}