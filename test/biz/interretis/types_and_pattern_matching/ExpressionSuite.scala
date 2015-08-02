package biz.interretis.types_and_pattern_matching

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExpressionSuite extends FunSuite {

  import biz.interretis.types_and_pattern_matching.Expression._

  val two = new Number(2)
  val three = new Number(3)
  val five = new Sum(two, three)
  val nine = new Sum(five, new Number(4))

  test("2 + 3 = 5") {
    assert(five.eval === 5)
  }

  test("2 + 3 + 4 = 9") {
    assert(nine.eval === 9)
  }
}