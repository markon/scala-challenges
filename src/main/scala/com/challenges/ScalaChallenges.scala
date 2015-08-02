package com.challenges

import collection.immutable.IndexedSeq
import collection.mutable.ListBuffer

object ScalaChallenges {
  
  val creditCardNumbers = List(
      "123456789012345", 
      "asdf56105 9108 101 8250dsafd",
      "123561059108101825054",
      "5610591081018250",
      "56105 9108 101 8250",
      "5910810182500033",
      "56613959932537",
      "c12-34de63 454-1234-0000-12345-4444-3333-2222 111100"
  )
  
  def main(args: Array[String]) {
    creditCardNumbers.par.map(c => println(LuhnFilter(c)))
  }

}