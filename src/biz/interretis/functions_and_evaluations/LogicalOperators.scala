package biz.interretis.functions_and_evaluations

object LogicalOperators extends App {

  def and(x: Boolean, y: Boolean) =
    if (x) y else false

  def or(x: Boolean, y: Boolean) =
    if (x) true else y
}