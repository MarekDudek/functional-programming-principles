package biz.interretis.lists

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  test("tuples can be used as patterns") {
    val pair = ('a', 42)
    val (char, number) = pair
    assert(char === 'a')
    assert(number === 42)
  }
}