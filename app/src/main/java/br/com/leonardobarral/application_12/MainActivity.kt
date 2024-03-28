package br.com.leonardobarral.application_12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.com.leonardobarral.application_12.models.PlayMusicModel
import br.com.leonardobarral.application_12.screens.PlayMusicScreen
import br.com.leonardobarral.application_12.ui.theme.Application_12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application_12Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlayMusicScreen(PlayMusicModel(),context = LocalContext.current)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PlayMusicScreenPreview() {
    Application_12Theme{
        PlayMusicScreen(PlayMusicModel(),context = LocalContext.current)
    }
}

