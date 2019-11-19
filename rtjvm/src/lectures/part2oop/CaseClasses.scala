package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // class parameters are all promoted to fields
  val jim = new Person("jim", 9)
  println(jim.name)
  // sensible toString -> println instance => println instance.toString //syntactic sugar
  println(jim)

  // equals and hashcode implemented out of the box
  val jim2 = new Person("Jim", 9)
  println(jim == jim2) //default equals is false

  // they have handy copy method
  val jim3 = jim.copy(age = 99)
  println(jim3)
  // they have companion objects

  val thePerson = Person
  val mary = Person("Mary", 23)
  // they are serializable
    // akka

  // they have extractor patterns => they can be used in pattern matching

  // there are case objects (same functionality) but they do not have companion objects as they are their own objects...
  case object UK {
    def name: String = "Great Britain"
  }



}
