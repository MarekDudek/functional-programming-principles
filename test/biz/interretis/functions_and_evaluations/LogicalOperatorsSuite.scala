package biz.interretis.functions_and_evaluations

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LogicalOperatorsSuite extends FunSuite {

  import LogicalOperators._

  test("T and T is T") {
    assert(and(true, true) === true)
  }

  test("T and F is F") {
    assert(and(true, false) == false)
  }

  test("T or F is T") {
    assert(or(true, false) == true)
  }

  test("F or F is F") {
    assert(or(false, false) == false)
  }
}