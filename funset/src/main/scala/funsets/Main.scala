package funsets

import FunSets._
import funsets.Test._

object Main extends App {
  println(contains(singletonSet(1), 1))
  Test.unionOfAllFromOneTo100ContainsAllNumberForAllworksAndExistWorks_Test()

}
