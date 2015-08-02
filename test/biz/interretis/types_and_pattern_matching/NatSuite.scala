package biz.interretis.types_and_pattern_matching

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatSuite extends FunSuite {

  val one = new Succ(Zero)
  val two = new Succ(one)

  test("predecessor") {
    assert(one.predecessor === Zero)
    assert(two.predecessor === one)
  }

  test("successor") {
    assert(Zero.successor.successor.predecessor.predecessor === Zero)
    assert(one.successor.predecessor === one)
    assert(one.successor.successor.predecessor.predecessor === one)
  }

  test("addition") {
    assert(Zero + one === one)
    assert(Zero + two === two)
  }

  test("subtraction") {
    assert(Zero - Zero === Zero)
    assert(one - Zero === one)
    assert(two - Zero === two)
  }

  intercept[NoSuchElementException] {
    Zero - one
  }
}