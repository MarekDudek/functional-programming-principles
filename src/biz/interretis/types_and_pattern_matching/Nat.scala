package biz.interretis.types_and_pattern_matching

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat =
    if (that.isZero) this
    else predecessor - that.predecessor
}

object Zero extends Nat {
  def isZero = true
  def predecessor: Nat = throw new NoSuchElementException("0.predecessor")
  def +(that: Nat) = that
  override def equals(o: Any) = {
    val other = o.asInstanceOf[Nat]
    if (other.isZero) true else false
  }
}

class Succ(val predecessor: Nat) extends Nat {
  def isZero = false
  def +(that: Nat) = new Succ(predecessor + that)

  override def equals(o: Any) = {
    val other = o.asInstanceOf[Nat]
    if (other.isZero) false
    else predecessor.equals(other.predecessor)
  }
}