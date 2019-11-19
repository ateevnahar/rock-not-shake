package lectures.part2oop

import apple.laf.JRSUIConstants.Animating

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahhahahah")
  }

  println(funnyAnimal.getClass)

  // compiler made an anonymous class
  // behind the scenes with what we did above to make the class
  // for the on the spot implementation
  // gotta still pass in required constructor params for the anonymous class which is being created
  // gotta implement abstract fields/methods as needed as well
}
