package co.ke.soundcloud.ui.playlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.ui.playlist.data.remote.Playlist
import co.ke.soundcloud.ui.playlist.domain.PlaylistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
        private val repo: PlaylistRepository,
        app: Application
) : AndroidViewModel(app) {

        private val _playlist: MutableLiveData<Resource<Playlist>> = MutableLiveData()

        val playlist: LiveData<Resource<Playlist>> = _playlist

        fun getPlaylist(id: Long) = viewModelScope.launch {
                repo.getPlaylist(id).collect { value ->
                        _playlist.value = value
                }
        }
}