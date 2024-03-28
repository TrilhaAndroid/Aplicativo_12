package br.com.leonardobarral.application_12.screens

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_12.components.ListMusicComponent
import br.com.leonardobarral.application_12.components.MenuComponent
import br.com.leonardobarral.application_12.models.PlayMusicModel
import br.com.leonardobarral.application_12.repositories.PlayListRepository

@Composable
fun PlayMusicScreen(playMusicModel: PlayMusicModel, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        val listMusic by playMusicModel.listMusic.observeAsState(initial = PlayListRepository())
        val status by playMusicModel.status.observeAsState(initial = true)
        val indexMusic by playMusicModel.indexMusic.observeAsState(initial = 0)
        val player by playMusicModel.musicNow.observeAsState(
            initial = MediaPlayer.create(
                context,
                listMusic[indexMusic].musica
            )
        )



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = listMusic[indexMusic].nome,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = listMusic[indexMusic].nome,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
        MenuComponent(
            status,
            mudaStatus = {
                playMusicModel.updateStatus(!status)
            },
            player = player,
            previous = {
                if (indexMusic != 0 && player != null) {
                    player.stop()
                    player.reset()
                    player.release()
                    playMusicModel.updateIndexMusic(novoValor = indexMusic - 1)
                    playMusicModel.updateMusicNow(
                        MediaPlayer.create(
                            context,
                            listMusic[indexMusic].musica
                        )
                    )
                    player.start()
                }
            },

            play = {
                if (player == null) {
                    playMusicModel.updateMusicNow(
                        MediaPlayer.create(
                            context,
                            listMusic[indexMusic].musica
                        )
                    )
                }
                player.start()
            },
            stop = {
                if (player != null) {
                    player.stop()
                    player.reset()
                    player.release()
                    playMusicModel.updateIndexMusic(0)
                }
            },
            next = {
                if (indexMusic < listMusic.size - 1 && player != null) {
                    player.stop()
                    player.reset()
                    player.release()
                    playMusicModel.updateIndexMusic(novoValor = indexMusic + 1)
                    playMusicModel.updateMusicNow(
                        MediaPlayer.create(
                            context,
                            listMusic[indexMusic].musica
                        )
                    )
                    player.start()
                }
            },

            pause = {
                if (player != null) {
                    player.pause()
                }
            }

        )
        Spacer(modifier = Modifier.height(5.dp))
        ListMusicComponent(
            listMusic,
            play = {
                player.stop()
                player.reset()
                player.release()
                playMusicModel.updateIndexMusic(listMusic.indexOf(it))
                playMusicModel.updateMusicNow(
                    MediaPlayer.create(
                        context,
                        listMusic[indexMusic].musica
                    )
                )
                player.start()
            }
        )
    }

}