package com.example.componentes_estado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->

                BasicComponetsScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun BasicComponetsScreen(
    modifier: Modifier = Modifier
) {

    val textFieldValue = remember {
        mutableStateOf("")
    }

    val quantidade = remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(239, 247, 207))
    ) {

        Text(
            text = "Aulas Android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ED37F),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )

        Text(
            text = "Com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        TextField(
            value = textFieldValue.value,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)
                textFieldValue.value = novoValor
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            ),
            placeholder = {
                Text("Qual a quantidade?")
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Nome e Sobrenome")
            }
        )

        TextField(
            value = quantidade.value,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)
                quantidade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            ),
            placeholder = {
                Text("Olho por olho")
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Android Enemy",
        modifier = modifier,
        colorFilter = ColorFilter.tint(color)
    )
}
