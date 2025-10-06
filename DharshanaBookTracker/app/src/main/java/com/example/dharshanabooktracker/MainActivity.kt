package com.example.dharshanabooktracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}

@Composable
fun App() {
    // This MaterialTheme is a Compose composable (not an XML theme)
    MaterialTheme {
        val nav = rememberNavController()
        val back by nav.currentBackStackEntryAsState()
        val route = back?.destination?.route ?: "library"

        Scaffold(
            topBar = {
                SmallTopAppBar(title = {
                    Text(
                        when (route) {
                            "library" -> "Library"
                            "detail" -> "Book Detail"
                            "add" -> "Add Book"
                            else -> "DharshanaBookTracker"
                        }
                    )
                })
            }
        ) { padding ->
            Column(Modifier.padding(padding)) {
                Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { nav.navigate("library") }, modifier = Modifier.weight(1f)) { Text("Library") }
                    Button(onClick = { nav.navigate("detail") }, modifier = Modifier.weight(1f)) { Text("Detail") }
                    Button(onClick = { nav.navigate("add") }, modifier = Modifier.weight(1f)) { Text("Add") }
                }
                NavHost(navController = nav, startDestination = "library", modifier = Modifier.fillMaxSize()) {
                    composable("library") { LibraryScreen(
                        onOpenDetail = { nav.navigate("detail") },
                        onAdd = { nav.navigate("add") }
                    ) }
                    composable("detail") { BookDetailScreen() }
                    composable("add") { AddBookScreen(onSaved = { nav.navigate("library") }) }
                }
            }
        }
    }
}
//activity