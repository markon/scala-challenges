import org.scalatest.junit.JUnitSuite
import org.junit.Assert._
import org.junit.Test
import com.challenges.LuhnFilter

class LuhnFilterTest extends JUnitSuite {

  @Test def verifySingleCreditCardNumber(){
    assert(LuhnFilter("5610591081018250") === "XXXXXXXXXXXXXXXX")
    assert(LuhnFilter("123456789012345") === "123456789012345")
    assert(LuhnFilter("5910810182500033") === "XXXXXXXXXXXXXXXX")
  }
  
  @Test def verifyOverlappingCreditCardNumbers(){
    assert(
        LuhnFilter("c12-34de63 454-1234-0000-12345-4444-3333-2222 111100") === 
        "c12-34de63 4XX-XXXX-XXXX-XXXXX-XXXX-XXXX-XXXX XXXXXX"
    )
    
    assert( LuhnFilter("xx5610-5910-8101-8250-0033md") === "xxXXXX-XXXX-XXXX-XXXX-XXXXmd")
  }
  
  @Test def verifyCreditCardNumberWithFlankingCharacters(){
    assert(LuhnFilter("123561059108101825054") === "12XXXXXXXXXXXXXXXXXX4")
    assert(LuhnFilter("asdf56105 9108 101 8250dsafd") === "asdfXXXXX XXXX XXX XXXXdsafd")
  }
  
}