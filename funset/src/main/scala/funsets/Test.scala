package funsets

object Test {
  import funsets.FunSets.*
  def unionOfAllFromOneTo100ContainsAllNumberForAllworksAndExistWorks_Test(): Unit = {
    var set : Set = emptySet
    for (i <- 0 to 100)
      set = union(set,singletonSet(i))

    for (i <- 0 to 100)
      if(! set(i)) {
        println("fail because the test doesn't contains " + i)
        return
      }

    if (set(-1)) {
      println("the test fails because the the number -1 shouldn't be in the set")
      return
    }

    if (! forall(set, x => x < 1000)) {
      println("the test fails because the forall loops doesn't works (should return true)")
      printSet(set)
      return
    }

    if (! exists(set, x => x==0)) {
      println("the test fails because exist fails to find the 0")
      return
    }

    if (exists(intersect(set,emptySet),x => true)) {
      println("the intersection of the set with the empty set isn't empty!")
      return
    }
    val unionEmptyAndTestSet = union(set,emptySet)

    if (! ((0 to 100).forall( contains(unionEmptyAndTestSet,_)))) {
      println("the union of the set from 0 to 100 and the empty set doesn't contains at least one number from 0 to 100")
      return
    }

    val timesTwo = map(set,_*2)
    if(exists(timesTwo, x => x%2 != 0)) {
      println("the map function doesn't works, _*2 was odd !")
      printSet(timesTwo)
      return
    }

    println("succeed")
    return
  }
}
