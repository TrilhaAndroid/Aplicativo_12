package br.com.leonardobarral.application_12.models

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayMusicModel : ViewModel() {


    private val _listMusic = MutableLiveData<List<Music>>()
    val listMusic: LiveData<List<Music>> = _listMusic

    fun updateListMusic(novoValor: List<Music>) {
        _listMusic.value = novoValor
    }

    private val _indexMusic = MutableLiveData<Int>()
    val indexMusic: LiveData<Int> = _indexMusic

    fun updateIndexMusic(novoValor: Int) {
        _indexMusic.value = novoValor
    }

    private val _musicNow = MutableLiveData<MediaPlayer>()
    val musicNow: MutableLiveData<MediaPlayer> = _musicNow

    fun updateMusicNow(novoValor: MediaPlayer?) {
        _musicNow.value = novoValor!!
    }


    private val _status = MutableLiveData<Boolean>()
    val status: MutableLiveData<Boolean> = _status

    fun updateStatus(novoValor: Boolean) {
        _status.value = novoValor
    }


}