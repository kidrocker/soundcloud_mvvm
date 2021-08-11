package co.ke.soundcloud.ui.playlist.data.remote

import co.ke.soundcloud.ui.playlist.model.Playlist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Place all the api endpoints on this class
 */
interface NetworkService {

    // Suspend function -> kotlin coroutines
    // return response object
    // so that we can handle all response types
    @GET("playlists/{id}")
    suspend fun getPlaylist(@Path(value = "id", encoded = true) id: Long): Response<Playlist>
}