package br.com.leonardobarral.application_12.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_12.models.Music

@Composable
fun CardListMusic(
    music: Music,
    play: (Music) -> Unit
) {

    Card(
        modifier = Modifier.clickable {
            play(music)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = music.nome,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color(0xFF314561)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = music.autor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color(0xFF03A9F4)
            )
        }
    }
}