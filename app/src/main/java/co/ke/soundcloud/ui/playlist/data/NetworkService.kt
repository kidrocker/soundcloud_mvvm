package co.ke.soundcloud.ui.playlist.data

import co.ke.soundcloud.ui.playlist.data.remote.Playlist
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    // Suspend function -> kotlin coroutines
    // return response object
    // so that we can handle all response types
    @GET("playlist/{id}")
    suspend fun getPlaylist(id: Long): Response<Playlist>
}