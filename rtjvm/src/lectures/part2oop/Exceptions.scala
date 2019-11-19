package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length) -> null pointer exception

  //val bad = throw new NullPointerException //throws an exception

  // throwable classes extend the throwable class
    // exceptions and error are the major subtypes

  // how to catch exceptions

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("no int")
    else 42
  }

  try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught")
  }
  finally {
    println("finally")
  }
}
