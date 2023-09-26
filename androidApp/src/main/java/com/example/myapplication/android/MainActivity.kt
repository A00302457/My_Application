package com.example.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.Greeting
import com.example.myapplication.getPlatform
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting(listOf("Hello, Android!")).greet())
                }
            }
        }
    }
}

@Composable

fun GreetingView(phrases: List<String>) {
    LazyColumn(
        contentPadding = PaddingValues(25.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(phrases) { phrase ->
            Text(phrase)
            Divider()
        }
    }
}

@Composable
fun LazyColumn(contentPadding: Any, verticalArrangement: Any, content: () -> Unit) {

}

fun greet(): List<String> = buildList {
    add(if (Random.nextBoolean()) "Hi!" else "Hello!")
    add("Guess what it is its me! > ${getPlatform().name.reversed()}!")
}
@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView(listOf("Hello, pooja!"))
    }
}

