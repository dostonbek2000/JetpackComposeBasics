package com.example.jetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme

class Article : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    ArticleScreen(
                        modifier = Modifier.padding(paddingValues),
                        title = stringResource(R.string.title),
                        text1 = stringResource(R.string.text1),
                        text2 = stringResource(R.string.text2)
                    )


                }
            }
        }
    }
}

@Composable
fun ArticleScreen(modifier: Modifier = Modifier, title: String, text1: String, text2: String) {
    val image = painterResource(R.drawable.article_image)
    // rasmni shunday qib o'zgaruvchiga chaqirb olsa kegin , shu nom bilan har qayerda muammosiz ishlatsa bo'ladi
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top, // arrangement.top component tepada turishini taminlatdi

    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier.fillMaxWidth()
        ) // filmaxwidth bu horizantal tomonlama ekranni to'liq qoplasin degani
        Text(text = title, fontSize = 24.sp, modifier = modifier.padding(16.dp))
        Text(text = text1, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify)
        Text(text = text2, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticleScreen(
        title = stringResource(R.string.title), // matnlarni string qo'shib , ularni nomi bilan butun matnni ishlatdim
        text1 = stringResource(R.string.text1),
        text2 = stringResource(R.string.text2)
    )
}


