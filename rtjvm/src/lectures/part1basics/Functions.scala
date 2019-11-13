package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def afunc(a: String, b: Int): String = {
    a + " " + b
  }

  println(afunc("hello", 3))

  def noparm (): Int = 42

  println(noparm())
  println(noparm)

  def repFunc(x: String, n: Int): String = {
    if( n== 1 )
      x
    else
      x + " " + repFunc(x, n-1)
  }

  println(repFunc("hello", 3))

  // use recursion no loops ^^^

  // for functions recursive functions require output type -- normal functions do not
  // best practice to have them regardless

  def sideEffect(ting: String): Unit = println(ting)

  def bigBoi(n: Int): Int = {
    def smolBoi( a: Int, b: Int) = a + b

    smolBoi(n, n -1)
  }

  /*
      examples: to do
      greeting func
      fact func -- recursive
      fib -- recursive
      primeFinder
   */

  def greta(name: String, age: Int): Unit = {
    println(s"Hi, my name is $name, and I am $age years old")
  }

  greta("ateev", 21)

  def fac(n: Int): Int = {
    if(n <= 0)
      1
    else
      n * fac(n -1)
  }

  println(fac(5))

  def fib(n: Int): Int = {
    if(n <= 2)
      1
    else
      fib(n-1) + fib(n-2)
  }

  println(fib(8))

  def primer(n: Int): Boolean = {
    @tailrec
    def primo(t: Int): Boolean = {
      if (t<=1) true
      else n % t !=0 && primo(t-1)
    }
    primo(n/2)
  }

  println(primer(36))
  println(primer(37))
}
