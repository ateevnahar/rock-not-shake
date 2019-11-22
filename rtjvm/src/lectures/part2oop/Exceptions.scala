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
    // this code will be executed no matter what
    // this is also optional
    // it is only used for side effects, does not effect return type
    println("finally")
  }

  class MyException extends Exception
  val exception = new MyException

  // throw exception

  /**
   * crash with
   *  out of memory
   *  stack overflow
   * define pocket calculator
   *  + - / * & custom exceptions
    */

  // val array = Array.ofDim(Int.MaxValue) // crash with out of memory

  // def infinite: Int = 1 + infinite // crashing jvm with stack overflow
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathException extends RuntimeException

  object Calc {
    def add(x: Int, y: Int) = {
      val res = x + y
      if (x > 0 && y > 0 && res < 0) throw new OverflowException
      else if  (x < 0 && y < 0 && res > 0) throw new UnderflowException
      else res
    }

    def sub(x: Int, y: Int) = {
      val res = x - y
      if (x > 0 && y < 0 && res < 0) throw new OverflowException
      else if  (x < 0 && y > 0 && res > 0) throw new UnderflowException
      else res
    }

    def mult(x: Int, y: Int) = {
      val res = x * y
      if (x > 0 && y > 0 && res < 0) throw new OverflowException
      else if  (x < 0 && y < 0 && res < 0) throw new OverflowException
      else if  (x > 0 && y < 0 && res > 0) throw new UnderflowException
      else if  (x < 0 && y > 0 && res > 0) throw new UnderflowException
      else res
    }

    def div(x: Int, y: Int) = {
      if (y == 0) throw new MathException
      x / y
    }

  }

}
