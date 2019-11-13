package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact = trFact(10,2)

  def savePhoto(format: String = ".png", width: Int = 1920, height: Int = 1080): Unit = println("save photo")

  savePhoto(".jpg", 800, 800)
  savePhoto()
  savePhoto(format = "jpg")

  savePhoto(height = 1000, format ="mp5", width = 1000)

    // if paramters are named order does not matter
  // if utilzing defaults can pass in one if named so the compiler understands
  // can pass in none cause of default or all
  // defaults are great for things functions called a lot with the same param
}
