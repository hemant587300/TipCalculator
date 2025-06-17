package com.smartblind.tipcalculator.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartblind.tipcalculator.utils.calculateTip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorScreen() {
    var amountInput by remember { mutableStateOf("") }
    var tipPercentage by remember { mutableStateOf(0.07) }
    var roundUp by remember { mutableStateOf(true) }
    var tipResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Tip Calculator",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                OutlinedTextField(
                    value = amountInput,
                    onValueChange = { amountInput = it },
                    label = { Text("Cost of Service") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Text(text = "How was the service?", fontSize = 18.sp)

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = tipPercentage == 0.10,
                            onClick = { tipPercentage = 0.10 }
                        )
                        Text("Amazing (10%)")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = tipPercentage == 0.07,
                            onClick = { tipPercentage = 0.07 }
                        )
                        Text("Good (7%)")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = tipPercentage == 0.05,
                            onClick = { tipPercentage = 0.05 }
                        )
                        Text("Okay (5%)")
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(checked = roundUp, onCheckedChange = { roundUp = it })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Round up the tip?")
                }

                Button(
                    onClick = {
                        val amount = amountInput.toDoubleOrNull() ?: 0.0
                        tipResult = calculateTip(amount, tipPercentage, roundUp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Calculate", fontSize = 16.sp)
                }

                if (tipResult.isNotEmpty()) {
                    Text(
                        text = "Tip Amount: $tipResult",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        }
    }
}
@Composable
fun TipCalculatorScreenPreview() {
    com.smartblind.tipcalculator.ui.theme.TipCalculatorTheme {
        TipCalculatorScreen()
    }
}
