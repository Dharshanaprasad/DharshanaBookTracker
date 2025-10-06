package com.example.dharshanabooktracker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddBookScreen(onSaved: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var isbn by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(title, { title = it }, Modifier.fillMaxWidth(), label = { Text("Title") })
        OutlinedTextField(author, { author = it }, Modifier.fillMaxWidth(), label = { Text("Author") })
        OutlinedTextField(isbn, { isbn = it }, Modifier.fillMaxWidth(), label = { Text("ISBN (optional)") })
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedButton(onClick = { title = ""; author = ""; isbn = "" }) { Text("Cancel") }
            Button(onClick = onSaved) { Text("Save") }
        }
    }
}
