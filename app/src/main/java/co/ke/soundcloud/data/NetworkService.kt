package co.ke.soundcloud.data

import co.ke.soundcloud.data.remote.RemotePlaylist
import retrofit2.Response
import retrofit2.http.GET
import java.util.concurrent.Flow

interface NetworkService {

    @GET("playlist/{id}")
    suspend fun getPlaylist(id: Long): Response<RemotePlaylist>
}