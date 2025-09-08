package recfun
import common._

import java.util.stream.IntStream
import scala.util.Random



object Main {
  def main(args: Array[String]): Unit =  {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
	  println()
	  println("===============================")
    println()
	  
	  print("(if (zero? x) max (/ 1 x)) is balanced ? " + balance("(if (zero? x) max (/ 1 x)) is balanced ? ".toList).toString())
	  
	  println()
	  println()
	  println("===============================")
	  println()
	  
	  val coins = Stream.from(0,97).take(50).toList.map(_ %101).filter(_!=0)
	  println("how many : " + countChange(200,coins))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if(c <= 0 || r<=c) return 1 else return pascal(c - 1 ,r - 1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char], count : Int = 0): Boolean =
    if (count < 0)
      return false 
    else
      chars match {
        case c :: tail =>
          c match {
            case '(' => return balance(tail, count + 1)
            case ')' => return balance(tail, count - 1)
            case _: Char => return balance(tail, count)
          }
        case Nil => return count == 0
      }

          
      
        
       
    

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
	  if (money < 0) return 0
	  else if(money ==0) return 1
	  else return coins match {
		  case Nil => return 0
		  case ::(hd, tl) => return countChange(money-hd, tl) + countChange(money, tl)
	  }
  }
}
