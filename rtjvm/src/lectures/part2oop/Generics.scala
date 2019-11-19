package lectures.part2oop

object Generics extends App {

  // this can be done with traits too
  class MyList[A] {
    // use the type A
    def add[B >: A](elem: A): MyList[B] = ???
    // so goes from cat list to animal if u add a dog
  }

  class MyMap[Key, Value]

  val listOfInts = new MyList[Int]
  val listOfStrs = new MyList[String]

  // generic methods

  object MyList{
    def empty[A]: MyList[A] = ???

  }

  val emptylistofInts = MyList.empty[Int]

  // variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // 1. yes list[cat] extends list[animal] = covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. NO - invariance
  class Invariant[A]
  val invariant: Invariant[Animal] = new Invariant[Animal]

  // 3. Hell no fam - contravariance
  class contra[-A]
  val contraList: contra[Cat] = new contra[Animal]

  // bounded types

  //        this says Cage only accepts params which are subtypes of Animal > <- supertype > <- subtype
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car) not possible at


  // extend mylist to be generic



}
