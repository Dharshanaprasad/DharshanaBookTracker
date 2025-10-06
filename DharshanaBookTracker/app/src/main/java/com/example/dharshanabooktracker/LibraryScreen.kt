package com.example.dharshanabooktracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LibraryScreen(onOpenDetail: () -> Unit, onAdd: () -> Unit) {
    val demo = remember { List(4) { i -> DemoBook("Book Title " + (i+1), "Author " + (i+1)) } }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        item {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                placeholder = { Text("Search books...") },
                singleLine = true
            )
        }
        items(demo) { book ->
            ElevatedCard(
                onClick = onOpenDetail,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(Modifier.padding(16.dp)) {
                    Box(
                        Modifier.size(64.dp, 96.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                    )
                    Spacer(Modifier.width(16.dp))
                    Column(Modifier.weight(1f)) {
                        Text(book.title, style = MaterialTheme.typography.titleMedium)
                        Text(book.author, style = MaterialTheme.typography.bodyMedium)
                        AssistChip(onClick = {}, label = { Text("Read") })
                    }
                }
            }
        }
        item {
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(onClick = onAdd, modifier = Modifier.weight(1f)) { Text("Add Book") }
                Button(onClick = onOpenDetail, modifier = Modifier.weight(1f)) { Text("Open Detail") }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

data class DemoBook(val title: String, val author: String)
//end code