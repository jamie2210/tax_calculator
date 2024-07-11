import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class TaxCalculatorSpec extends AnyWordSpec {

  val taxCalculator: TaxCalculator = new TaxCalculator

  // Tests for income below basic rate
  "taxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is below the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(5000)

        assert(result == 0)
      }
    }
  }
  // Tests for income of basic rate
  "taxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is at basic rate tax limit" in {
        val result: Double = taxCalculator.calculateTax(13000)

        assert(result == 600)
      }
    }
  }
  // Tests for income of higher rate
  "taxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is at higher rate tax limit" in {
        val result: Double = taxCalculator.calculateTax(60000)

        assert(result == 12000)
      }
    }
  }
  // Test of income at highest rate
  "TaxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is at highest rate tax limit" in {
        val result: Double = taxCalculator.calculateTax(130000)

        assert(result == 32258)
      }
    }
  }
  // Test if tax payer is of higher rate income or not
  "taxCalculator.isHigherRateTaxpayer" should {
    "return true" when {
      "tax payer has higher rate income" in {
        val result: Boolean = (taxCalculator.isHigherRateTaxpayer(51000))
        assert(result)
      }
    }
  }
  // Test to return income limit of personal allowance tax band
  "taxCalculator.formattedCurrentTaxAllowance" should {
    "return the basic rate tax bracket" when {
      "tax payer is below 10,000" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(9000)
        result == "10,000"
      }
    }
  }
  // Test to return income limit of basic rate tax band
  "taxCalculator.formattedCurrentTaxAllowance" should {
    "return the basic rate tax bracket" when {
      "tax payer is below 50,000 but above 10,000" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(35000)
        result == "50,000"
      }
    }
  }
  // Test to return income limit of higher rate tax band
  "taxCalculator.formattedCurrentTaxAllowance" should {
    "return the basic rate tax bracket" when {
      "tax payer is below 125,000 but above 50,000" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(75000)
        result == "125,000"
      }
    }
  }
  // Test to return income limit of higher rate tax band
  "taxCalculator.formattedCurrentTaxAllowance" should {
    "return the basic rate tax bracket" when {
      "tax payer is 125,000 or above" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(180000)
        result == "No Limit"
      }
    }
  }
}


