import org.junit.jupiter.api.Test
import utils.InterestRateGenerator
import java.math.BigDecimal
import kotlin.test.assertEquals

class InterestRateGeneratorTest {
    @Test
    fun calculateInterest_zeroAmount_noInterestCalculated() {
        assertEquals(BigDecimal("0.00"), InterestRateGenerator.calculateInterest(BigDecimal.ZERO))
    }

    @Test
    fun calculateInterest_negativeAmount_noInterestCalculated() {
        assertEquals(BigDecimal("0.00"), InterestRateGenerator.calculateInterest(BigDecimal(-5)))
    }

    @Test
    fun calculateInterest_withinInterestCutoff1_interestCalculated() {
        assertEquals(BigDecimal("15.02"), InterestRateGenerator.calculateInterest(BigDecimal(1001)))
    }

    @Test
    fun calculateInterest_withinInterestCutoff2_interestCalculated() {
        assertEquals(BigDecimal("30.00"), InterestRateGenerator.calculateInterest(BigDecimal(2000)))
    }

    @Test
    fun calculateInterest_withinInterestCutoff3_interestCalculated() {
        assertEquals(BigDecimal("120.00"), InterestRateGenerator.calculateInterest(BigDecimal(6000)))
    }

    @Test
    fun calculateInterest_withinInterestCutoff4_interestCalculated() {
        assertEquals(BigDecimal("1800.00"), InterestRateGenerator.calculateInterest(BigDecimal(60000)))
    }

    @Test
    fun calculateInterest_stringInput_interestCalculated() {
        assertEquals(BigDecimal("15.02"), InterestRateGenerator.calculateInterest("$1,001"))
    }

    @Test
    fun calculateInterest_invalidStringInput_noInterestCalculated() {
        assertEquals(BigDecimal.ZERO, InterestRateGenerator.calculateInterest("1001x"))
    }
}