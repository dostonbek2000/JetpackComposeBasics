package com.example.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.ModifierLocalModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme

class Task : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // scaffold bizga title yozish va bottom navigation ni ishlatish uchun kerak bo'ladi.
                    TaskScreen(
                        modifier = Modifier.padding(innerPadding),
                        stringResource(R.string.all_tasks_completed),
                        stringResource(R.string.nice_work)
                        // stringResourceda siz , kerakli textlarni kiritib yozib qo'yasiz va zarur bo'lganda ularni nomi bilan barcha tekistni ishlatish mumkin
                    )
                }
            }
        }
    }
}

@Composable
fun TaskScreen(
    modifier: Modifier = Modifier, text1: String, text2: String
) { // bu funksiyada hamma component vertical joylashishi uchun  column dan foydalanildi
    // manga ikkita text keragli uchun man o'zim funkiyani ichiga ikkita data oldim
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        val image =
            painterResource(R.drawable.task) // painterResource bu biga rasmni implement qilib beradi, va duch kegan joyda uni nomi orqali qo'llashimiz mumkun

        Image(
            painter = image, contentDescription = null
        ) // painter = deb image oldim, chunki man tepadia imageni o'zgaruvchi qilib olgandim
        Text(
            text = text1,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
        ) // padding(top=0.dp) tepadan pastga qochadi,bottom bo'lsa pastdan qochadi, agar left yoki right bo'lssa shular tomondan ham qoshadi
        Text(text = text2, fontSize = 18.sp)// fontsize bu harfni razmeri
    }

}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    TaskScreen(
        modifier = Modifier,
        stringResource(R.string.all_tasks_completed),// bu textni stringga tashab qo'yganimcuhun , uni nomi ilan butun matnni ishlatdim
        stringResource(R.string.nice_work)
    )
}