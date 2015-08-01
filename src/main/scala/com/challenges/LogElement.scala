package com.challenges

/**
 * LogElement represents an element that needs to be logged: either an X or a character.
 */
case class LogElement(c: Char, var mask: Boolean = false) {
  def element = if (mask) 'X' else c
  def elementAsInteger = c.getNumericValue
}
  
