package biz.interretis.higher_order_functions

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HigherOrderFunctionsSuite extends FunSuite {

  import HigherOrderFunctions._
  import biz.interretis.functions_and_evaluations.VariousMathFunctions.tailFactorial

  test("sum of 1..10") {
    assert(sum(x => x)(1, 10) === 55)
  }

  test("sum of squares of 1..10") {
    assert(sum(x => x * x)(1, 10) === 385)
  }

  test("sum of factorials of 1..10") {
    assert(sum(x => tailFactorial(x))(1, 10) === 4037913)
  }

  def sumInts = sumF(x => x)
  def sumSquares = sumF(x => x * x)
  def sumFactorials = sumF(tailFactorial)

  test("curried sum of 1..10") {
    assert(sumInts(1, 10) === 55)
  }

  test("curried sum of squares of 1..10") {
    assert(sumSquares(1, 10) === 385)
  }

  test("curried sum of factorials of 1..10") {
    assert(sumFactorials(1, 10) === 4037913)
  }

  val cube = (x: Int) => x * x * x

  test("direct invocation of curried function") {
    assert(sumF(cube)(1, 10) === 3025)
  }

  test("factorial as product") {
    assert(factorial(5) === 120)
  }

  test("factorial with map-reduce") {
    assert(mapReduce(id, (a: Int, b: Int) => a * b, 1)(1, 5) === 120)
  }

  test("product as map-reduce") {
    assert(productAsMapReduce(id)(1, 5) === 120)
  }
}