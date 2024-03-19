package com.vinay.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinay.unitconverter.ui.theme.UnitConverterTheme
import androidx.compose.material.icons.Icons as Icons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    // by keyword is used to handle getting and setting values

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnits by remember { mutableStateOf("Centimeters") }
    var outputUnits by remember { mutableStateOf("Meters") }
    var iDropdownExpanded by remember { mutableStateOf(false) }
    var oDropdownExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(0.01) }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextType(name = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
           Box{
               Button(onClick = { /*TODO*/ }) {
                   Text(text = "Select")
                   Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
               }
               DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                   DropdownMenuItem(text = { Text("Centimeter") }, onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text("Milimeter") }, onClick = { /*TODO*/ })

               }
           }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { /*TODO*/ })   {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text("Centimeter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Milimeter") }, onClick = { /*TODO*/ })

                }
            }
        }
    }
}

@Composable
fun TextType(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        TextType("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}