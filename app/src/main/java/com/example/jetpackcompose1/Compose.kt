package com.example.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose1.ui.theme.First
import com.example.jetpackcompose1.ui.theme.Fourth
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme
import com.example.jetpackcompose1.ui.theme.Second
import com.example.jetpackcompose1.ui.theme.Third

class Compose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        Modifier.fillMaxWidth(), // ekranni horizontal machasi to'liq qoplaydi
    ) {
        Row( // row qator. bu ni ichida yozilga componentlar hammasi horizontal joylashadi
            Modifier.weight(1f) // weight bu og'irligi . 1 qilishni sababi hamma componentlar birxil razmerda bo'lishini support tqiladi
        ) {
            TextScreen(
                title = "Text composable",
                text = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f),
                background = First // background bu orqa fon rangi
            )
            TextScreen(
                title = "Image composable",
                text = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                background = Second
            )

        }
        Row(
            Modifier.weight(1f)
        ) {
            TextScreen(
                title = "Row composable",
                text = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f),
                background = Third
            )
            TextScreen(
                title = stringResource(R.string.column_composable),
                text = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                modifier = Modifier.weight(1f),
                background = Fourth
            )

        }
    }
}

@Composable
fun TextScreen(title: String, text: String, modifier: Modifier = Modifier, background: Color) {
    Column( // column bu ustun, bunu ichida ishlatilgan barcha componentlar vertical holatda ketma ket joylashadi
        verticalArrangement = Arrangement.Center, // vertical holda o'rtada bo'ladi
        horizontalAlignment = Alignment.CenterHorizontally, //horizontal holda o'rtada bo'ladi
        modifier = modifier

            .fillMaxSize() // bu ekranni to'liq qoplasin degan buyruq
            .background(background)
    ) {
        Text( // text bu , textni yaratish uchun ishlatiladi, bu ham bir composable
            text = title,
            fontWeight = FontWeight.Bold, // fontweight bu harflarni shakli , misol uchun ingichka, qalin
            modifier = Modifier.padding(16.dp), // bu tashqaridan 16 dp qochadi

        )
        Text(text = text, textAlign = TextAlign.Justify,modifier=Modifier.padding(16.dp))
// textalign, tekst qayerda joylashganini kiritish uchun ishlatiladi. justify degani ikala chekkasixam tekkis turaddi degani
    }
}

@Preview(showBackground = true) // bu bizga qilgan ui ni ko'rsatib turish uchun ishlatiladi, show background = true degani esa telfonni oynasiga qo'yib chiqaradi degani
@Composable
fun ComposePreview() {
    MainScreen()
}