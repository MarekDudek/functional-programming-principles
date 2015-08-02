package biz.interretis.types_and_pattern_matching

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatSuite extends FunSuite {

  val one = new Succ(Zero)
  val two = new Succ(one)
  val three = new Succ(two)
  val four = new Succ(three)
  val five = new Succ(four)

  test("predecessor") {
    assert(one.predecessor === Zero)
    assert(two.predecessor === one)
  }

  test("successor") {
    assert(Zero.successor.predecessor === Zero)
    assert(Zero.successor.successor.predecessor.predecessor === Zero)
    assert(one.successor.predecessor === one)
    assert(one.successor.successor.predecessor.predecessor === one)
  }

  test("addition") {
    assert(Zero + one === one)
    assert(Zero + two === two)
    assert(one + Zero === one)
    assert(two + Zero === two)
    assert(one + two === three)
    assert(two + three === five)
  }

  test("subtraction") {
    assert(Zero - Zero === Zero)
    assert(one - Zero === one)
    assert(two - Zero === two)
    assert(one - one === Zero)
    assert(two - one === one)
    assert(five - two === three)
  }

  intercept[NoSuchElementException] {
    Zero - one
  }
}