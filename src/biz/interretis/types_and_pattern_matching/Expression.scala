package biz.interretis.types_and_pattern_matching

trait Expression {

  def eval: Int = this match {
    case Number(n)             => n
    case Sum(Number(0), e)     => e.eval
    case Sum(e1, e2)           => e1.eval + e2.eval
    case Product(Number(1), e) => e.eval
    case Product(e1, e2)       => e1.eval * e2.eval
  }

  def show: String = this match {
    case Number(n)                               => n.toString
    case Sum(e1, e2)                             => e1.show + " + " + e2.show
    case Product(n @ Number(_), sum @ Sum(_, _)) => n.show + " * (" + sum.show + ")"
    case Product(sum @ Sum(_, _), n @ Number(_)) => "(" + sum.show + ") * " + n.show
    case Product(e1, e2)                         => e1.show + " * " + e2.show
  }
}

case class Number(number: Int) extends Expression {

}

case class Sum(leftOp: Expression, rightOp: Expression) extends Expression {

}

case class Product(leftOp: Expression, rightOp: Expression) extends Expression {

}

