package com.challenges

import collection.mutable.ListBuffer



/**
 * The LuhnFilter applies the Luhn algorithm to a string of arbitrary length, in order to find multiple 
 * and overlapping credit card numbers.
 */
object LuhnFilter{
  
  def apply(input: String): String = {
    val seq = input.map(c => LogElement(c))
    val windows = Seq(new Window(16), new Window(15), new Window(14))
    for (logElement <- seq) {
      if (validate(logElement)) windows.foreach(_.prepend(logElement)) 
      else windows.foreach(_.clear)
    }
    seq.map(_.element).mkString
  }
  
  private def validate(e: LogElement): Boolean = {
    e.element == ' ' || e.element == '-' || e.element.isDigit
  }
 
}

/**
 * The Window class describes the main idea of the algorithm used to 
 * check for the validity of overlapping credit card numbers.
 * 
 * The Window class defines a mutable list of specific elements so that we can set these elements to be "marked" or not.
 * Additionally, mutability lets us to avoid the burden of keeping track of indexes and additional data structures
 * to keep the original data untouched.
 * 
 */
class Window(val size: Int) {
    val window : ListBuffer[LogElement] = ListBuffer()
    
    def prepend(log: LogElement) {
      if(!log.c.isDigit) return
      
      if (isFull)
        window.remove(size - 1)

      window.prepend(log)
      if (containsValidCreditCardNumbers) 
        window.foreach(_.mask = true)
    }

    def clear { window.clear() }
    def isFull = window.size == size
 
    /**
     * This method is the key part of the algorithm to find overlapping credit card numbers.
     * We "iterate" over the full window and apply the Luhn algorithm.
     * 
     */
    private def containsValidCreditCardNumbers = {
      val res = window.map(_.origAsInteger).reverse.mkString
      isFull && LuhnChecker.isValid(res)
    }
    
    
  }