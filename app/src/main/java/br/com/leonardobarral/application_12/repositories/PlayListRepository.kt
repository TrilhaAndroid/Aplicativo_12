package br.com.leonardobarral.application_12.repositories

import androidx.compose.runtime.Composable
import br.com.leonardobarral.application_12.R
import br.com.leonardobarral.application_12.models.Music

@Composable
fun PlayListRepository():List<Music> {
    return listOf(
        Music(nome = "Nego Drama", autor = "Racionais MC's", musica = R.raw.nego_drama),
        Music(nome = "Jesus Chorou", autor = "Racionais MC's", musica = R.raw.jesus_chorou),
        Music(nome = "Vida Loka Parte 2", autor = "Racionais MC's", musica = R.raw.vida_loka_pt_2)
    )
}