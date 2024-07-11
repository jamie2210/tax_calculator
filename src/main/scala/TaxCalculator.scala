import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages

class TaxCalculator {

  // Tax bands (simplified to make testing a bit easier)
  private val personalAllowance: Int = 10000
  private val basicRateLimit: Int = 50000
  private val higherRateLimit: Int = 125000

  // Tax rates
  private val personalAllowanceRate: Double = 0
  private val basicRate: Double = 0.2
  private val higherRate: Double = 0.4
  private val additionalRate: Double = 0.45

  // A method to calculate the total amount of tax to be paid, returned as a double
  def calculateTax(income: Double): Double = {
    if (income <= 10000) {
      0.00
    } else if (income <= basicRateLimit) {
      ((income - personalAllowance)) * basicRate
    } else if (income <= higherRateLimit) {
      (income - basicRateLimit) * higherRate +
        (basicRateLimit - personalAllowance) * basicRate
      } else {
      (income - higherRateLimit) * additionalRate +
        (higherRateLimit - basicRateLimit) * higherRate +
        (basicRateLimit - personalAllowance) * basicRate
      }
  }

  // A method which can tell you if someone is a higher rate taxpayer
  def isHigherRateTaxPayer(income: Double): Boolean = {
    income > basicRateLimit
  }

  // A method that will return a string with the income limit of their current tax band.
  // The return will also be formatted, E.g: "£12,500" or "No limit"
  def formattedCurrentTaxAllowance(income: Double): String = {
    if (income <= personalAllowance) {
      personalAllowance.toString
    } else if (income <= basicRateLimit) {
      basicRateLimit.toString
    } else if (income <= higherRateLimit) {
      higherRateLimit.toString
    } else {
      "No Limit"
    }
  }

}
