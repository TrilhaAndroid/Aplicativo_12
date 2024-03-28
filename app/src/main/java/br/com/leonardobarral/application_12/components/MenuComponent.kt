package br.com.leonardobarral.application_12.components

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_12.R

@Composable
fun MenuComponent(
    status:Boolean,
    mudaStatus: () -> Unit,
    previous: () -> Unit,
    play: () -> Unit,
    stop: () -> Unit,
    next: () -> Unit,
    pause: () -> Unit,
    player: MediaPlayer
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .minimumInteractiveComponentSize()
            .background(
                color = Color.LightGray
            )
            .padding(vertical = 2.dp, horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,

        ) {

        IconButton(onClick = {
            previous()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_skip_previous_24),
                contentDescription = ""
            )
        }

        IconButton(onClick = {
            if(status){
                pause()
                mudaStatus()
            }else{
                play()
                mudaStatus()
            }
        }) {

            if(status){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_pause_24),
                    contentDescription = ""
                )
            } else {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "")
            }
        }

        IconButton(onClick = {
            stop()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_stop_24),
                contentDescription = ""
            )
        }

        IconButton(onClick = {
            next()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_skip_next_24),
                contentDescription = ""
            )
        }
    }
}