package biz.interretis.data_and_abstraction

import scala.language.postfixOps

trait IntSet {

  def incl(x: Int): NonEmpty

  def contains(x: Int): Boolean

  def makeString: String

  def union(other: IntSet): IntSet

  def filter(p: Int => Boolean): IntSet
}

class Empty extends IntSet {

  def incl(elem: Int): NonEmpty =
    new NonEmpty(elem, new Empty, new Empty)

  def contains(elem: Int): Boolean =
    false

  def union(other: IntSet) =
    other

  def filter(p: Int => Boolean) = this

  override def makeString = "{}"
}

class NonEmpty(root: Int, left: IntSet, right: IntSet) extends IntSet {

  def incl(elem: Int): NonEmpty =
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

  def union(other: IntSet) =
    left union right union other incl root

  def filter(p: Int => Boolean) =
    if (p(root))
      left.filter(p) union right.filter(p) incl (root)
    else
      left.filter(p) union right.filter(p)

  override def toString = {
    val builder = new StringBuilder
    if (!left.isInstanceOf[Empty])
      builder append left append ", "
    builder append root
    if (!right.isInstanceOf[Empty])
      builder append ", " append right
    builder toString
  }

  override def makeString = {
    val builder = new StringBuilder
    builder append '{' append this append '}'
    builder toString
  }
}

object IntSet {

  def assertAllPos[S <: IntSet](set: S): S =
    if (set.isInstanceOf[Empty]) set
    else {
      val positive = set.filter(x => x > 0)
      if (set.makeString == positive.makeString) set
      else throw new Error("Not positive")
    }

  type A = IntSet => NonEmpty
  type B = NonEmpty => IntSet

  def a(s: IntSet) = new NonEmpty(1, new Empty, new Empty)
  def b(s: NonEmpty) = new Empty

  val aa: A = a
  val bb: B = b

  val cc: B = aa
  //val dd: A = bb
}