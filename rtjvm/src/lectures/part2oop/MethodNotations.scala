package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favMovie
    def neflixNchill(person: Person): String = s"${this.name} is hanging with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging with ${person.name}"
    def +(nickname: String): Person = new Person (this.name + nickname, this.favMovie, this.age)
    def unary_! : String = s"$name yeeet what!!!"
    def unary_+ : Person = new Person(this.name, this.favMovie, this.age + 1)
    def learns(thing: String): String = s"${this.name} learns $thing"
    def learnsScala(): String = learns("Scala")
    def isAlive: Boolean = true
    def apply(): String = s"my name is $name"
    def apply(times: Int): String = s"${this.name} watched ${this.favMovie} $times times"
  }

  val joe = new Person("joe", "spirited away")
  println(joe.likes("spirited away"))
  println(joe likes "spirited away") // "infix notation" can only be done with methods with one parameter
  // ^^ example of syntactic sugar

  // ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2)) // these are the same

  // akka operators have ! ? operators

  // prefix notation
  val x = -1 // = 1.unary_-
  val y = 1.unary_- // is the same as x

  // unary only work for a few operators -> + - ~ !
  println(!joe)
  // &&
  println(joe.unary_!) // same

  // postfix notation
  println(joe.isAlive)
  println( joe isAlive) //postfix notation -- can only be done when methods do not have args


  //apply
  println(joe.apply())
  println(joe()) // these are the same again!!!! apply mate


  /*
    exercises
    overload + operator

    add age to person class = default 0
    add unary operator to increment age

    learns method in person which returns names
    learns scala method which just callls ^^ with scala & use postfix

    overload apply method
      mary.apply with number

   */
  println((joe + "the rockstah")())
  println((joe + "the rockstah").apply())

  println((+joe).age)
  println(joe learnsScala)
  println(joe learns "coding")
  println(joe.apply(3))
  println(joe(19))

}
