package biz.interretis.lists

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HigherOrderListFunctionsSuite extends FunSuite {

  val numbers = List(0.25, 2.5, 5.75)
  val numerals = List("one", "two", "three", "four", "five", "six")

  test("map") {
    val doubled = numbers.map(x => 2 * x)
    assert(doubled === List(0.5, 5, 11.5))
  }

  test("filter") {
    val lessThanThree = numbers.filter(x => x < 3)
    assert(lessThanThree === List(0.25, 2.5))
  }

  test("partition") {
    val (negative, positive) = numbers.partition(x => x < 3)
    assert(negative === List(0.25, 2.5))
    assert(positive === List(5.75))
  }

  test("take while") {
    val until = numerals.takeWhile(s => s.length < 5)
    assert(until === List("one", "two"))
  }

  test("drop while") {
    val after = numerals.dropWhile(s => s.length < 5)
    assert(after === List("three", "four", "five", "six"))
  }

  test("span") {
    val (until, after) = numerals span (s => s.length < 4)
    assert(until === List("one", "two"))
    assert(after === List("three", "four", "five", "six"))
  }

  import biz.interretis.lists.HigherOrderListFunctions._

  val unpacked = List("a", "a", "a", "b", "b", "c", "c", "a")

  test("pack") {
    val packed = pack(unpacked)
    assert(packed === List(List("a", "a", "a"), List("b", "b"), List("c", "c"), List("a")))
  }

  test("encode") {
    val encoded = encode(unpacked)
    assert(encoded === List(("a", 3), ("b", 2), ("c", 2), ("a", 1)))
  }
}