package biz.interretis.functions_and_evaluations

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalactic.TolerantNumerics
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SquareRootNewtonMethodSuite extends FunSuite {

  import SquareRootNewtonMethod.sqrt

  val epsilon = 0.001
  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(epsilon)

  test("sqrt 4 is 2") {
    assert(sqrt(4.0) === 2.0)
  }
}