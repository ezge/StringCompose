package com.assessment.stringdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assessment.stringdemo.ui.theme.StringDemoTheme
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.graphics.Brush

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StringDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        SpanString()
        ParaString()
        BrushStyle()
    }
}

@Composable
fun SpanString() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)) {
                append("T")
            }
            withStyle(style = SpanStyle(color = Color.Gray)) {
                append("his")
            }
            append(" is ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.Blue
                )
            ) {
                append("great!")
            }
        }
    )
}

@Composable
fun ParaString() {
    Text(
        buildAnnotatedString {
            append("\nThis is some text that doesn't have any style applied to it.\n")
            withStyle(style = ParagraphStyle(lineHeight = 30.sp,
                                             textIndent = TextIndent(firstLine = 60.sp,
                                             restLine = 25.sp))
            ) {
                append("This is some text that is indented more on the first lines than " +
                       "the rest of the lines. It also has an increased line height.\n")
            }
            withStyle(style = ParagraphStyle(textAlign = TextAlign.End)) {
                append("This is some text that is right aligned.")
            }
        })
}

@Composable
fun BrushStyle() {
    val colorList: List<Color> = listOf(Color.Red, Color.Blue, Color.Magenta,
                                        Color.Yellow, Color.Green, Color.Red)
    Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 70.sp,
                                                brush = Brush.linearGradient(colors = colorList))){
                        append("COMPOSE!")}}
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StringDemoTheme {
        MainScreen()
    }
}