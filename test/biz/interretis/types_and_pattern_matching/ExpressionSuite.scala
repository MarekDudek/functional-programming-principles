package biz.interretis.types_and_pattern_matching

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExpressionSuite extends FunSuite {

  val two = new Number(2)
  val three = new Number(3)
  val five = new Sum(two, three)
  val nine = new Sum(five, new Number(4))
  val twelve = new Product(three, new Product(two, two))

  val sumWithProduct = Sum(Number(2), Product(Number(3), Number(4)))
  val productWithSum = Product(Number(2), Sum(Number(3), Number(4)))
  val productWithSum2 = Product(Sum(Number(3), Number(4)), Number(2))

  test("2 + 3 = 5") {
    assert(five.eval === 5)
  }

  test("2 + 3 + 4 = 9") {
    assert(nine.eval === 9)
  }

  test("3 * (2*2) = 12") {
    assert(twelve.eval === 12)
  }

  test("showing number") {
    assert(two.show === "2")
  }

  test("showing sum") {
    assert(Sum(Number(2), Number(3)).show === "2 + 3")
    assert(Sum(Number(2), Sum(Number(3), Number(4))).show == "2 + 3 + 4")
  }

  test("showing product") {
    assert(Product(Number(2), Number(3)).show === "2 * 3")
    assert(Product(Number(2), Product(Number(3), Number(4))).show == "2 * 3 * 4")
  }

  test("showing sum and product") {
    assert(sumWithProduct.show === "2 + 3 * 4")
    assert(productWithSum.show === "2 * (3 + 4)")
    assert(productWithSum2.show === "(3 + 4) * 2")
  }
}