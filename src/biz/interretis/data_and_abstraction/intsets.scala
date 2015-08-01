package biz.interretis.data_and_abstraction

abstract class IntSet {

  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def makeString: String
}

object Empty extends IntSet {

  def incl(elem: Int): IntSet =
    new NonEmpty(elem, Empty, Empty)

  def contains(elem: Int): Boolean =
    false

  override def makeString = "{}"
}

class NonEmpty(root: Int, left: IntSet, right: IntSet) extends IntSet {

  def incl(elem: Int): IntSet =
    if (root == elem)
      this
    else if (root > elem)
      new NonEmpty(root, left incl elem, right)
    else
      new NonEmpty(root, left, right incl elem)

  def contains(elem: Int): Boolean =
    if (root == elem)
      true
    else if (root > elem)
      left contains elem
    else
      right contains elem

  override def toString = {
    val builder = new StringBuilder
    if (left != Empty)
      builder append left append ", "
    builder append root
    if (right != Empty)
      builder append right append ", "
    builder toString
  }

  override def makeString = {
    val builder = new StringBuilder
    builder append '{' append this append '}'
    builder toString
  }
}