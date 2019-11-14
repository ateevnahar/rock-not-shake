package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favMovie: String) {

    def likes(movie: String): Boolean = movie == favMovie
    def neflixNchill(person: Person):String = s"${this.name} is hanging with ${person.name}"
    def +(person: Person):String = s"${this.name} is hanging with ${person.name}"

    def unary_! : String = s"$name yeeet what!!!"

    def isAlive: Boolean = true

    def apply(): String = s"my name is $name"
  }

  val mama = new Person("joe", "spirited away")
  println(mama.likes("spirited away"))
  println(mama likes "spirited away") // "infix notation" can only be done with methods with one parameter
  // ^^ example of syntactic sugar

  // ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2)) // these are the same

  // akka operators have ! ? operators

  // prefix notation
  val x = -1 // = 1.unary_-
  val y = 1.unary_- // is the same as x

  // unary only work for a few operators -> + - ~ !
  println(!mama)
  // &&
  println(mama.unary_!) // same

  // postfix notation
  println(mama.isAlive)
  println( mama isAlive) //postfix notation -- can only be done when methods do not have args


  //apply
  println(mama.apply())
  println(mama()) // these are the same again!!!! apply mate

}
