package co.ke.soundcloud.ui.playlist

import androidx.lifecycle.*
import co.ke.soundcloud.SoundCloudApplication
import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.ui.playlist.data.remote.Playlist
import co.ke.soundcloud.ui.playlist.domain.PlaylistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class PlaylistViewModel(
        val repo:PlaylistRepository,
        app:SoundCloudApplication
): AndroidViewModel(app) {

        private  val _playlist:MutableLiveData<Resource<Playlist>> = MutableLiveData()

        val playlist:LiveData<Resource<Playlist>> = _playlist

        fun getPlaylist(id:Long) = viewModelScope.launch {
                repo.getPlaylist(id).collect { value ->
                        _playlist.value = value
                }
        }
}