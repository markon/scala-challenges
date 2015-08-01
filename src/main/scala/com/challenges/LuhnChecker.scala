package com.challenges

/** LuhnChecker is an object with methods that apply the Luhn algorithm to determine 
 *  whether a given string is a valid credit card number or not.
 * 
 * This object is not used in the code base, but it gives a better understanding of how the Luhn algorithm works.
 * 
 */
object LuhnChecker {
  
  /**
   * Verify that a credit card number is valid by applying the Luhn algorithm.
   * 
   * Return true if the credit card number is valid, false otherwise.
   */
  def isValid(number: String): Boolean = { 
    require((number.length >= 14) && (number.length <= 16), "CC number must be between 14/16 digits.")
    
    def sumDigits(x: Integer): Int = {
      x.toString.map(_.asDigit).sum
    }
    
    number.reverse.map(_.asDigit).grouped(2).foldLeft(0)(
        (start, group) => start + group.reduce(
          (a: Int, b: Int) => a + sumDigits(b*2)
      )
    ) % 10 == 0
  }
}