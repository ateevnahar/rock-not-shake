package exercises

import lectures.part2oop.Generics.MyList

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A] (element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
  def map[B] (transformer: MyTransformer[A,B]): MyList[B]
  def flatmap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++ [B >: A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""
  def map[B] (transformer: MyTransformer[Nothing ,B]): MyList[B] = Empty
  def flatmap[B] (transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def ++ [B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def map[B] (transformer: MyTransformer[A,B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  def flatmap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatmap(transformer)

  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  // this is a little clever
  def ++ [B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
  val listOfInts: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfInss: MyList[Int] = new Cons(8, new Cons(4, new Cons(5, Empty)))
  val cloneInss: MyList[Int] = new Cons(8, new Cons(4, new Cons(5, Empty)))

  val listOfString: MyList[String] = new Cons("11", new Cons("22", new Cons("33", Empty)))

  println(listOfInts.toString)
  println(listOfString.toString)

  println(listOfInts.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfInts.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println(listOfInts ++ listOfInss)

  println(listOfInts.flatmap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons (elem, new Cons(elem + 1, Empty))
  }).toString)

  println(cloneInss == listOfInss)

}
