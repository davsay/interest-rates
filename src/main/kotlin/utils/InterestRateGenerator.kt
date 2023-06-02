package utils

import extensions.toMoneyFormat
import extensions.toPercentageFormat
import java.lang.Exception
import java.math.BigDecimal
import java.math.RoundingMode

class InterestRateGenerator {

    companion object {
        fun calculateInterest(stringAmount: String): BigDecimal {
            return try {
                val stringAmountCleaned = stringAmount.replace(",", "").replace("$", "")
                val amount = BigDecimal(stringAmountCleaned)
                calculateInterest(amount)
            } catch (e: Exception) {
                println("Invalid Amount, exception=$e")
                BigDecimal.ZERO
            }
        }
        fun calculateInterest(amount: BigDecimal): BigDecimal {
            val interestRate = getInterestRate(amount)
            val interestAmount = amount.times(interestRate).setScale(2, RoundingMode.HALF_EVEN) // Half even is the suggest rounding method for money
            println("A balance of ${amount.toMoneyFormat()}, would pay an interest of ${interestRate.toPercentageFormat()}, resulting in an interest rate of ${interestAmount.toMoneyFormat()}")
            return interestAmount
        }

        private val INTEREST_CUTOFF_1 = BigDecimal(1000)
        private val INTEREST_AMOUNT_1 = BigDecimal("0.01")

        private val INTEREST_CUTOFF_2 = BigDecimal(5000)
        private val INTEREST_AMOUNT_2 = BigDecimal("0.015")

        private val INTEREST_CUTOFF_3 = BigDecimal(10000)
        private val INTEREST_AMOUNT_3 = BigDecimal("0.02")

        private val INTEREST_CUTOFF_4 = BigDecimal(50000)
        private val INTEREST_AMOUNT_4 = BigDecimal("0.025")

        private val INTEREST_AMOUNT_MAX = BigDecimal("0.03")

        private fun getInterestRate(amount: BigDecimal): BigDecimal {
            return if (amount <= BigDecimal.ZERO) {
                println("Amount: $amount is not positive, no interest is possible")
                BigDecimal.ZERO
            } else if (amount < INTEREST_CUTOFF_1) {
                INTEREST_AMOUNT_1
            } else if (amount < INTEREST_CUTOFF_2) {
                INTEREST_AMOUNT_2
            } else if (amount < INTEREST_CUTOFF_3) {
                INTEREST_AMOUNT_3
            } else if (amount < INTEREST_CUTOFF_4) {
                INTEREST_AMOUNT_4
            } else {
                INTEREST_AMOUNT_MAX
            }
        }
    }
}