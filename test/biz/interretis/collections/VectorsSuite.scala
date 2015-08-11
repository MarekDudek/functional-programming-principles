package biz.interretis.collections

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VectorsSuite extends FunSuite {

  val nums = Vector(1, 2, 3, -88)

  test("prepending to vector") {
    val newNums = 99 +: nums
    assert(newNums === Vector(99, 1, 2, 3, -88))
  }

  test("appending to vector") {
    val newNums = nums :+ 99
    assert(newNums === Vector(1, 2, 3, -88, 99))
  }

  val string = "Hello World"

  test("flat map on string") {
    val flatMapped = string flatMap (c => List('.', c))
    assert(flatMapped === ".H.e.l.l.o. .W.o.r.l.d")
  }

  test("all combinations") {
    val m = 3
    val n = 2
    val combinations = (1 to m) flatMap (x => (1 to n) map (y => (x, y)))
    assert(combinations === Vector((1, 1), (1, 2), (2, 1), (2, 2), (3, 1), (3, 2)))
  }

  import biz.interretis.collections.vectors._

  test("primes") {
    assert(isPrime(2))
    assert(isPrime(3))
    assert(isPrime(5))
    assert(isPrime(7))
    assert(isPrime(11))
    assert(isPrime(13))
  }

  test("not primes") {
    assert(!isPrime(4))
    assert(!isPrime(6))
    assert(!isPrime(8))
    assert(!isPrime(9))
    assert(!isPrime(10))
  }
}