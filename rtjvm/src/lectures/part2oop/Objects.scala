package lectures.part2oop

object Objects extends App {

  // Scala does not have class-level functionality ("Static") like java does

  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("bobbie")
  }

  class Person (val name: String) {
    // instance-level functionality

  }
  // companion
  // companions can access each others private members


  println(Person.N_EYES)
  println(Person.canFly)

  // scala objects are singleton instance
  val mary = Person
  val john = Person

  // this is different as this now is two instances
  val p1 = new Person("mary")
  val p2 = new Person("john")

  println(p1==p2) // false since they do NOT point to same instance of the class
  println(mary==john) // = true since they point to same instance of the object

  val bobbie = Person(p1, p2)

  // Scala Applications = scala object with
  // def main(args: Array[String]): Unit -- this is equivalent to the extends App above as it has a main already defined




}
