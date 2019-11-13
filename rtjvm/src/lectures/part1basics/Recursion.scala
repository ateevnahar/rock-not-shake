package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def fac(n: Int): Int = {
    if (n <= 0)
      1
    else {
      //println("fact of " + n )
      val res = n * fac(n - 1)
      // println("fact of " + n )
      res
    }
  }

  println(fac(5))

  // fac of 5000 = stack overflow

  def factual(n: Int): BigInt = {
    @tailrec
    def fact(x: Int, acc: BigInt): BigInt =
      if (x <= 1) acc
      else fact(x - 1, x * acc)

    fact(n, 1)
  }

  // println(factual(5000))

  // the way this it written it does not need a new stack-frame vs beforehand as it does not need intermediate results
  // aka tail recursion vs regular recursion
  // to use recursive call as the LAST expression

  // when you need loops utilize tail recursion instead.

/*
    examples
    concat
    isprime
    fib
 */

  def catcon(x: String, n: Int, acc: String): String = {
    if(n <= 0)
      acc
    else
      catcon(x, n -1, acc + x)
  }

  def primer(n: Int): Boolean = {
    def primo(t: Int): Boolean = {
      if (t <= 1) true
      else n % t !=0 && primo(t-1)
    }
    primo(n/2)
  }

  def fib(x: Int): Int = {
    def nacci(i: Int, acc_l : Int, acc_n: Int): Int = {
      if (i >= x) acc_l
      else nacci(i+1, acc_l + acc_n, acc_l)
    }

    if (x <= 2) 1
    else (nacci(2, 1, 1))

  }

  println(fib(8))

}



