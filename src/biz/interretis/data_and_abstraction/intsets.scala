package biz.interretis.data_and_abstraction

abstract class IntSet {

  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def makeString: String = null
}

class Empty extends IntSet {

  def incl(elem: Int): IntSet =
    new NonEmpty(elem, new Empty, new Empty)

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
    else if (elem < root)
      left contains elem
    else
      right contains elem

  override def toString = {
    val builder = new StringBuilder
    if (!left.isInstanceOf[Empty])
      builder append left.toString append ", "
    builder append root
    if (!right.isInstanceOf[Empty])
      builder append right.toString append ", "
    builder toString
  }

  override def makeString = {
    val builder = new StringBuilder
    builder append '{' append toString append '}'
    builder toString
  }
}