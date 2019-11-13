package lectures.part1basics

object StringOps extends App {

  val str = "long boi not a short boi"

  // java utilz
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("long"))
  println(str.replace(" ", "-"))
  println(str.toUpperCase())
  println(str.length)

  // scala util
  val num = "42"
  val intt: Int = num.toInt
  println('a' +: num :+ 'z')
  println(num.reverse)
  println(num.take(1))


  // Scala-Specific

  // s-interpolation

  val name = "David"
  val age = 10
  val greeting = s"hi i am $name and my age is $age"
  val otherGreet = s"hi i am $name and my age is ${age + 1}"

  // f-interpolation
    // similar to print f
  val spped = 1.2f
  val myth = f"$name%s can eat $spped%2.2f burgers a minute"

  //%2.2f decimal float 2 characters total 2 decimal precision
  // %s - string type

  // raw interpolator
  println(raw"this is \n new line") // this will be printed non escaped it will be printed literally

  //but if passed as an injected variable string it would be escaped tho



}
