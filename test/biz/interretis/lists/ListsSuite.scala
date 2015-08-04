package biz.interretis.lists

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  test("tuples can be used as patterns") {
    val pair = ('a', 42)
    val (char, number) = pair
    assert(char === 'a')
    assert(number === 42)
  }

  test("merge-sort") {
    val unsorted = List(3, 1, 5, 7, 2, 4, 6)
    val sorted = List(1, 2, 3, 4, 5, 6, 7)
    assert(mergesort.msort(unsorted) === sorted)
  }
}