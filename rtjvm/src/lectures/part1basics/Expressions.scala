package lectures.part1basics

class Expressions extends App {

  val x = 1 + 2 //expression
  println(x)

  println(2+3+3)

  println(1 == x)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val cond = true
  val condVal = if(cond) 5 else 3 // if expression as gives back a value
  println(condVal)

  //while loop = terrible as everything is evaluated as a expression in scala


}
