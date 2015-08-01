package biz.interretis.higher_order_functions

object ExceptionHandling extends App {

  val x: Null = null
  val y: String = x

  // val z: Int = null

  val z: AnyVal =
    if (true) 1 else false

  val z1: Any = z

  def error(message: String): Nothing =
    throw new Error(message)

  def e: Nothing = error("no error, it's function definition")
  val e1: Nothing = error("error, it's value instantiation")
}