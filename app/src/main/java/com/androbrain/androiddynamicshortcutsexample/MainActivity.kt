package com.androbrain.androiddynamicshortcutsexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.androbrain.androiddynamicshortcutsexample.ui.theme.AndroidDynamicShortcutsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            AndroidDynamicShortcutsExampleTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text(text = "email") }
                        )
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "password") },
                            visualTransformation = PasswordVisualTransformation(),
                        )
                        Button(onClick = {
                            ShortcutManager.enableLoginShortcuts(this@MainActivity)
                            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                        }) {
                            Text(text = "Log in")
                        }
                    }
                }
            }
        }
    }
}
