package com.challenges

/**
 * This is the main App that will run the coding challenges.
 */
object ScalaChallenges extends App {
  val creditCardNumbers = List("123456789012345", "asdfasfdasfdsafd")
  
  for(i <- creditCardNumbers){
    if(LuhnChecker.isValid(i)){
      
    }
  }
  
}