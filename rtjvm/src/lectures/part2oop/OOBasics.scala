package lectures.part2oop

object OOBasics extends App {

  val person = new Person ("joe", 44)
  println(person.age)

  // person.name == not valid to print in Scala as class parameters are not class fields



  //book stuff

  val author = new Writer("jk","rowling", 1970)
  val book = new Novel("cos",author,2000)
  println(author.fullName())
  print(book.isWrittenBy(author))
  println(book.authorAge())
  println(book.copy(2001))

}

// adding val makes it a field as well
// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 3 // <- declared stuff is now a field

  println(1 + x) // <-- at every instantiation everything in the body will be evaluated

  // parameter of class vs parameter of method
  def greta(name: String): Unit = println(s"hi my name is $this.name but not always $name")

  // with no parameters the this would have been implied
  //overloading (as has different parameters and same name)
  def greta(): Unit = print(s"$name")

  //multiple constructors
  def this(name: String) = this(name, 0)
  // ^^ this can be done with default parameters
  //auxiliary constructors cannot do too much so...
}



/*
  novel & writer

  writer: first name, last name, year
  - method full name

  novel: name, year of release, author
  - author age
  - is written by (author)
  - copy new year of release => new instance of novel
 */

class Writer(fname: String, lname: String, val yob: Int) {

  def fullName(): String = s"$fname $lname"

}

class Novel(title: String, author: Writer, publishYear: Int) {

  def authorAge(): Int = publishYear - author.yob

  def isWrittenBy(ath: Writer) = ath == this.author

  def copy(newPub: Int): Novel = new Novel(this.title, this.author, newPub)

}


/*
  counter class
  - receives an int
  - meethod for current count
  - increment decrement count => new counter
  - overload inc/dec to receive an amount

 */

class Counter(x: Int) {

  def cur(): Int = x

  def inc(): Counter = {
    println("inc")
    new Counter(this.x + 1)
  }

  def dec(): Counter = {
    println("dec")
    new Counter(this.x - 1)
  }

  def inc(n: Int): Counter = {
    inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    dec.dec(n-1)
  }

}








