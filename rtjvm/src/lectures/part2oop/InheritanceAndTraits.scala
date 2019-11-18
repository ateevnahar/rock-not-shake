package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat= println("nomnomnom")

  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name: String, age: Int) {
    // if you had this constructor tho you would not need to pass it like that
    // def this(name: String) = this(name, 0) then only name is needed
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // the params are needed for the super class

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic" that above override lets you do it another way
    override def eat: Unit = {
      super.eat
      println("crunch crunch")
    }

  }

  val dog = new Dog("K9")
  println(dog.creatureType)

  //type substitution -- (broad: polymorphism)
  val idkAnimal: Animal = new Dog("K9")
  idkAnimal.eat

  // overRiding vs overLoading

  // super -- utilizing parent class

  // preventing overrides
  // 1. utilizing final on member -- prevents derived classes from overriding
  // 2. utilizing final on class -- the entire class cannot be extended
  // 3. utilizing seal -- can extend in the current file but that is it



}
