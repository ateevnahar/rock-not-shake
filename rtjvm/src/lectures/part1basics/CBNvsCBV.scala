package lectures.part1basics

object CBNvsCBV  extends App {

  // evaluates and the same val is used throughout (also normally called in this manner)

  def CBV(x: Long): Unit = {
    println("by val " + x)
    println("by val " + x)
  }

  // evaluates each time utilized -- useful for lazy stuff
  // so can get different results
  def CBN(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  CBV(System.nanoTime())
  CBN(System.nanoTime())



}
