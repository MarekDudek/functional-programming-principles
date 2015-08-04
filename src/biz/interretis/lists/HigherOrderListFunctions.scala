package biz.interretis.lists

object HigherOrderListFunctions {

  def pack(strings: List[String]): List[List[String]] = strings match {
    case Nil => Nil
    case whole @ head :: _ => {
      val (repeating, rest) = whole span { s => (s == head) }
      repeating :: pack(rest)
    }  
  }
  
  def encode(strings: List[String]): List[(String, Int)] = 
    pack(strings) map { list => (list(0), list.length) }
}