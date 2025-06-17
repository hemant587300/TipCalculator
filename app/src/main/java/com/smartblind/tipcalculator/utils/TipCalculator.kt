package com.smartblind.tipcalculator.utils

import java.text.NumberFormat
import kotlin.math.ceil

fun calculateTip(amount: Double, tipPercent: Double, roundUp: Boolean): String {
    var tip = amount * tipPercent
    if (roundUp) tip = ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}
