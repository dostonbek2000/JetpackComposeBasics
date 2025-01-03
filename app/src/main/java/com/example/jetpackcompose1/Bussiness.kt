package com.example.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme

class Bussiness : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  BusinessScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom, // ERTICAL HOLDA ENG PASIDA TURADI
        horizontalAlignment = Alignment.CenterHorizontally // BU HORIZNTAL HOLDA O'RTADA TURADI
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 180.dp)// PASTDAN 180 DP TEPADA TURADI
        ) {
            FirstScreen("Doston Husanov", "Android Developer")
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SecondScreen("+998 91 044 67 10", "@Dostonbek_1010", "hu.do.android.com")
        }
    }
}

@Composable
fun FirstScreen(title: String, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        val logo = painterResource(R.drawable.android_logo) // LOGONI O'ZGARUVCHGA TNEGLAB SHU NOM BILAN ISHLATDIM
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .height(120.dp) // UZUNLIGI 120 DP DEGANI
                .width(120.dp) // ENI 120 DP DEGANI
                .clip(shape = RectangleShape) // CLIP BU SHAPE NI BERISHNI IMKONINI BERADI. SHAPE = RECTANGLE BU TO'RTBURCHAK DEYILADI
                .background(
                    Color(
                        0xFF211C2A
                    ) // ORQA FON RASMI RANGI
                )
        )
        Text(text = title, fontSize = 36.sp, fontWeight = FontWeight.Bold) // FONTSIZE BU TEKSTSIE. FONTWEIGHT TEXTNI KO'RINISHI , BOLD YOIKI ITALIC
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold)


    }

}

@Composable
fun SecondScreen(number: String, insta: String, gmail: String) {
    Column( // COMPONENTLAR VERTIKAL JOTLASHADI
        modifier = Modifier.padding(60.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val phoneI = painterResource(R.drawable.phone) // LOGONI O'ZGARUVCHGA TNEGLAB SHU NOM BILAN ISHLATDIM
        val instaI = painterResource(R.drawable.contact)
        val mailI = painterResource(R.drawable.mail)
        Row( // COMPONENTLAR HORIZANTAL JOTLASHADI
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth() // ENI BO'YICHA EKRANNI TO'LIQ EGALLAYDI
                .padding(2.dp) // HAR TOMONDAN 2 DP QOCHADI
        ) {
            Image(painter = phoneI, contentDescription = null, modifier = Modifier.size(25.dp))
            Spacer(modifier = Modifier.width(8.dp)) // BU BO'SHLIQ YARATIB BERADI. AGAR WIDTH BO'SA ENIGA JOY TASHEDI. HEIGHT QILINSA TEPADAN PASGA JOY TASHEDI
            Text(text = number)
        }

        Row( // COMPONENTLAR QATOR VA QATOR JOYLASHADI
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Image(painter = instaI, contentDescription = null, modifier = Modifier.size(25.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = insta)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Image(painter = mailI, contentDescription = null, modifier = Modifier.size(25.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = gmail)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun BusinessPreview() {
    JetpackCompose1Theme {
        BusinessScreen()
    }
}