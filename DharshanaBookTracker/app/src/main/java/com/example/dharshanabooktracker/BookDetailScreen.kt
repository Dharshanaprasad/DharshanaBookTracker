package com.example.dharshanabooktracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookDetailScreen() {
    Column(
        Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(Modifier.fillMaxWidth().height(200.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant))
        Text("Book Title • Author", style = MaterialTheme.typography.titleLarge)
        Row { repeat(4) { Text("★") }; Text("☆") }
        Text("Progress")
        LinearProgressIndicator(progress = { 0.5f }, modifier = Modifier.fillMaxWidth())
        Text("My Notes")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().height(120.dp),
            placeholder = { Text("Type notes...") }
        )
        Text("Reading Timeline")
        Box(Modifier.fillMaxWidth().height(140.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant))
    }
}
