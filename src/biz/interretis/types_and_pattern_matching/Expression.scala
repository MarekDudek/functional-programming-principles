package biz.interretis.types_and_pattern_matching

trait Expression {

  def eval: Int
}

class Number(val number: Int) extends Expression {

  def eval = number
}

class Sum(val leftOp: Expression, val rightOp: Expression) extends Expression {

  def eval = leftOp.eval + rightOp.eval
}

object Expression {

  def eval(expression: Expression): Int = {
    if (expression.isInstanceOf[Number])
      expression.asInstanceOf[Number].number
    else if (expression.isInstanceOf[Sum])
      eval(expression.asInstanceOf[Sum].leftOp) +
        eval(expression.asInstanceOf[Sum].rightOp)
    else
      throw new Error("unknown expression: " + expression)
  }
}