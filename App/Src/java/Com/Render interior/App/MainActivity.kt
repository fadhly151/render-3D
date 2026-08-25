package com.renderinterior.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.renderinterior.app.ui.navigation.NavGraph
import com.renderinterior.app.ui.theme.RenderInteriorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val app = application as RenderInteriorApp

        setContent {
            RenderInteriorTheme {
                NavGraph(app = app)
            }
        }
    }
}
