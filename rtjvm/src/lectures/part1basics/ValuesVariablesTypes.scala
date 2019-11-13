package lectures.part1basics

case object ValuesVariablesTypes extends App {

  // vals ARE IMMUTATABLE
    // omplier infer types -- so they are optional
    //
  val x = 42
  println(x)

  val a: String = "strung"
  val bool: Boolean = false
  val char: Char = 'a'
  val short: Short = 4444
  val long: Long = 8888888888L // need to add the L
  val cloud: Float = 3.3F      // same ting
  val twice: Double = 3.3

  var y = 7
  y = 8     // side effects


}
