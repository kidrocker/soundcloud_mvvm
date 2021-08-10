package co.ke.soundcloud.ui.playlist.data.network.source

import co.ke.soundcloud.ui.playlist.data.NetworkService
import javax.inject.Inject

class PlaylistDataSource @Inject constructor(
    private val networkService: NetworkService
) {

    suspend fun getPlaylist(id: Long) = networkService.getPlaylist(id)
}