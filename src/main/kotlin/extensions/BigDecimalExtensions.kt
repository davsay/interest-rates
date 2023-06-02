package extensions

import java.math.BigDecimal
import java.text.NumberFormat

fun BigDecimal.toPercentageFormat(): String {
    return this.movePointRight(2).setScale(2).toPlainString() + "%"
}

fun BigDecimal.toMoneyFormat(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}