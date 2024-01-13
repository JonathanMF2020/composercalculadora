@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.jmf.kotlin_opencv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jmf.kotlin_opencv.ui.theme.KotlinopencvTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            KotlinopencvTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                    Box {
                        calculadora()
                    }

                }
            }
        }
    }
}


@Composable
fun calculadora(){
    var number1 by rememberSaveable{ mutableStateOf("")}
    var number2 by rememberSaveable{ mutableStateOf("")}
    var resultado by rememberSaveable{ mutableStateOf(0.0)}

    Column {
        Row {
            Text(text = "Calculadora Prueba 1", textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())

        }
        Row(modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth()) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Black, // Color of the border when the field is in focus
                    unfocusedIndicatorColor = Color.Gray,
                    textColor = Color.Black,
                    focusedLabelColor = Color.Black, // Color of the border when the field is not in focus
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(8.dp),
                value = number1,
                onValueChange = { number1 = it },
                label = { Text("Numero 1") },
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .weight(1f),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Black, // Color of the border when the field is in focus
                    unfocusedIndicatorColor = Color.Gray,
                    textColor = Color.Black,
                    focusedLabelColor = Color.Black,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(8.dp),
                value = number2,
                onValueChange = { number2 = it },
                label = { Text("Numero 2") },
            )

        }
        Row(modifier = Modifier
            .padding(horizontal = 5.dp)
            .padding(top = 10.dp)
            .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly) {

            Button(onClick = { resultado =sumar(number1.toDouble(),number2.toDouble()) }) {
                Text("+", fontSize = 30.sp)
            }
            Button(onClick = { resultado =restar(number1.toDouble(),number2.toDouble()) }) {
                Text("-", fontSize = 30.sp)
            }
            Button(onClick = { resultado =multiplicar(number1.toDouble(),number2.toDouble()) }) {
                Text("*", fontSize = 30.sp)
            }
            Button(onClick = { resultado = dividir(number1.toDouble(),number2.toDouble()) }) {
                Text("/", fontSize = 30.sp)
            }

        }
        if(resultado > 0.0){
            Text(text = "El resultado es: $resultado", modifier = Modifier.padding(top = 15.dp).padding(horizontal = 10.dp).fillMaxHeight(), style = TextStyle(fontSize = 60.sp))
        }


    }
}

fun sumar(number: Double,number2: Double): Double{
    return number+number2
}

fun restar(number: Double,number2: Double): Double{
    return number-number2
}

fun multiplicar(number: Double,number2: Double): Double{
    return number*number2
}

fun dividir(number: Double,number2: Double): Double{
    return number/number2
}

@Preview(showBackground = true)
@Composable
fun Prew() {
    KotlinopencvTheme {
       calculadora()
    }
}