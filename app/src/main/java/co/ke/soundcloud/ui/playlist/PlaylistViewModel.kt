package co.ke.soundcloud.ui.playlist

import androidx.lifecycle.ViewModel
import co.ke.soundcloud.ui.playlist.domain.GetPlaylist

class PlaylistViewModel(
        val getPlaylist: GetPlaylist
): ViewModel() {
}