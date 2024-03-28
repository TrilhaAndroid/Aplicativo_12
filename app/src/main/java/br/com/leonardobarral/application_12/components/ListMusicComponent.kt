package br.com.leonardobarral.application_12.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_12.models.Music

@Composable
fun ListMusicComponent(
    listMusic: List<Music>,
    play: (Music) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                listMusic
            ) { it ->
                CardListMusic(music = it, play = { play(it) })
                Spacer(modifier = Modifier.height(5.dp))
            }

        }
    }

}