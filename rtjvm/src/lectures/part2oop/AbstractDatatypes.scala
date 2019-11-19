package lectures.part2oop

object AbstractDatatypes extends App {

  // abstract --  where things are not fully implemented

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"

    def eat: Unit = println("crunch") // override is not needed btw
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val prefMeal: String = "roadkill"
  }
  trait coldBlooded
  class Croc extends Animal with Carnivore with coldBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nom")
    def eat(animal: Animal): Unit = println(s"croc eating a ${animal.creatureType}")
  }

  // traits vs abstract classes
  // 1 - traits do not have constructor params
  // 2 -- multiple traits may be inherited
  // 3 --- traits = behavior, abstract class = type of thing



}

