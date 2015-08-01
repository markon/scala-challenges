import org.scalatest.junit.JUnitSuite
import scala.collection.mutable.ListBuffer
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import com.challenges.LuhnChecker

class LuhnCheckerTest extends JUnitSuite {

  var sb: StringBuilder = _
  var lb: ListBuffer[String] = _

  @Before def initialize() {
    sb = new StringBuilder("ScalaTest is ")
    lb = new ListBuffer[String]
  }

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