package biz.interretis.types_and_pattern_matching

abstract class Nat {

  def isZero: Boolean

  def predecessor: Nat

  def successor = new Succ(this)

  def +(that: Nat): Nat =
    if (isZero) that
    else if (that.isZero) this
    else new Succ(predecessor + that)

  def -(that: Nat): Nat =
    if (that.isZero) this
    else predecessor - that.predecessor

  override def equals(other: Any) = {
    val that = other.asInstanceOf[Nat]
    if (isZero) that.isZero
    else predecessor.equals(that.predecessor)
  }
}

object Zero extends Nat {
  def isZero = true
  def predecessor: Nat = throw new NoSuchElementException("0.predecessor")
}

class Succ(val predecessor: Nat) extends Nat {
  def isZero = false
}