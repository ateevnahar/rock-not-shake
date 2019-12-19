package lectures.part2oop

// can import with ._ for everything in the package/class or just by {... , ... } for when you only need
// a few specific things, ... => ... to do name aliasing -- useful in case of importing more than one
// class with the same name
// or you could use fully qualified names

class PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("ateev", "nahar", 1121)

  // importing package or fully qualified name is required for things not in the package

  // packages are in hierarchy
  // matching the folder structure

  sayHello
  println(meaningOfLife)

  // default imports
    // java.lang - String, Object, Exception
    // scala - Int, Nothing, Function
    // scala.Predef - printLn, ???

}
