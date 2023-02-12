package com.unfunnyguy.elegant.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.unfunnyguy.elegant.ui.home.screens.HomeScreen
import com.unfunnyguy.elegant.ui.theme.ElegantSplashComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ElegantSplashComposeTheme { HomeScreen() } }
    }
}
