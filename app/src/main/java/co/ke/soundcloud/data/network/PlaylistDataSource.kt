package co.ke.soundcloud.data.network

import co.ke.soundcloud.data.NetworkService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class PlaylistDataSource @Inject constructor(
    private val networkService: NetworkService
) {

    //
    suspend fun getPlaylist(id: Long) = networkService.getPlaylist(id)
}