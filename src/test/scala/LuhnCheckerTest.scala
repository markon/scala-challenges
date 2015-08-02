import org.scalatest.junit.JUnitSuite
import org.junit.Assert._
import org.junit.Test
import com.challenges.LuhnChecker

class LuhnCheckerTest extends JUnitSuite {

  @Test def verifyIsValidCreditCard(){
    assert(LuhnChecker.isValid("5610591081018250"))
    assert(LuhnChecker.isValid("56613959932537"))    
  }
  
  @Test def verifyCreditCardTooShortOrLong(){
    intercept[IllegalArgumentException] {
      LuhnChecker.isValid("1111111156613959932537")
      
    }
    intercept[IllegalArgumentException] {
      LuhnChecker.isValid("566139")
    }
  }
}