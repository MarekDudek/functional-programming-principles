package biz.interretis.types_and_pattern_matching

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionsAndObjectsSuite extends FunSuite {

  val function = (x: Int) => x * x

  test("function is an object") {
    assert(function.isInstanceOf[AnyRef])
    assert(function.isInstanceOf[Function1[Int, Int]])
  }

  test("function application verbose") {
    assert(function(7) === function.apply(7))
  }
}