package com.example.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose1Theme { // bu proektni mavzusi
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) { // surface ilovani yuzasi. surfaceda ilovani rangini va razmeri kiritiladi, bu kiritilishi shart degani emas , chunki android studio avtamatik ravishdao'zini default rangi va razmerini oladi
                  /*  GreetingImage(
                        message = "Happy Birthday Alex!",
                        from = "From Jack"

                    )*/

                    ArticleScreen(title = stringResource(R.string.title), text1 = stringResource(R.string.text1), text2 = stringResource(R.string.text2))
                    // funksiya chaqirilyapti va undagi componentlarni qiymati berilyabdi va natijada . ilovada biz qilgan ui to'liq ishlayabdi, buni fqat telfonda tekshirsa bo'ladi
                }
            }
        }
    }
}

@Composable // composable bu ui qilinayotgan funksiyaligini anglatadi, composablesiz qilingan funksiya bu oddiy funksiya hisoblanadi
fun GreetingText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) { //Composable da albatta funksiya nomini  birinchi harfi kottada bo'lishi kerak aks holda , android studio bu composable funksiya ekanligini tanib ololmaydi
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) { // column bu ustun degani buni ichidagi componentlarni hammasi ustunga o'xshab tushadi, yani uida shunaqa ko'rinadi
// padding bu componentni hamma tomonini tashqaridan uzoqlashtiradi
        //verticalArrangement  Columnda funksiyadagi ui ustunma ustun qayerda joylashishini kiritish uchun ishlatiladi
        //horizontalAlignment  Columnda funksiyadagi ui qatorma qator qayerda joylashganini kiritish uchun ishlatiladi
        // ammo rowda esa
        Text( text = message, fontSize = 90.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
// Text() bu jetpackni bitta componentidir. bur orqali biz o'zimizga qulay bo'lgan tekisni yarata olamiz
        // fontSize bu tekstni razmeri, lineHeight bu tekistni balandligi . bunda tekstni balandligi qancha bo'lishi kiritiladi, textAlign bu tekistni biron bir tomonga qo'yish uchun ishlatiladi , misol uchun textAlign=TextAlign.Center, bu textni orientiri o'rtada degani.
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.End)
            // nima uchun textAlign mas degan savolga javob agar texda bitta so'z bo'lsa uni textAlign orqali orientirini o'zgartirib bo'lmaydiydi. shuning uchun bu yerda modifier.align(alignment = Alignment.End) dan foydalanilgan , bu har qanday textni orientirini o'zgartira oladi
        )
    }
}
@Composable
fun GreetingImage(message: String,from: String,modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = modifier, contentAlignment = Alignment.Center) {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(message, from, modifier = Modifier.padding(8.dp))
    }

}

@Preview(showBackground = true)
// preview nima. bu biz yaratga ui ni qanday bo'lganini ko'rsatib beradi va realtime holatida ishlaydi
@Composable
fun BirthdayCardPreview() {
    JetpackCompose1Theme {
        GreetingImage(message = "Happy Birthday Alex!", from = " From Jack")
        // greeting text funksiyasi chaqirilyabdi va undagi componentlarni qymatini beryabdi natijada , biz yaratga ui oynada nomoyish bo'lyabdi
    }
}
/*
//verticalAlignment  Rowda funksiyadagi ui ustunma ustun qayerda joylashishini kiritish uchun ishlatiladi
//horizontalArrangement Rowda funksiyadagi ui qatorma qator qayerda joylashganini kiritish uchun ishlatiladi, lekin bu albatta bo'lish kerak degani emas. chunki row o'zi horizantal bo'ladi va componentlar ketma ket horizantal joylashadi

Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
) {
    Text(text = "message", fontSize = 20.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
    Text(
        text = "from",
        fontSize = 20.sp,
        modifier = Modifier
            .padding(16.dp)

    )
}
}
*/


