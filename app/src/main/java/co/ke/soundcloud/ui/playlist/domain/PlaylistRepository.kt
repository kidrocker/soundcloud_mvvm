package co.ke.soundcloud.ui.playlist.domain

import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.data.network.BaseApiResponse
import co.ke.soundcloud.data.network.PlaylistDataSource
import co.ke.soundcloud.data.remote.RemotePlaylist
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class PlaylistRepository @Inject constructor(
    private val dataSource: PlaylistDataSource
): BaseApiResponse(){

    suspend fun getPlaylist(id:Long): Flow<Resource<RemotePlaylist>>{
        return flow<Resource<RemotePlaylist>>{
            emit(handleApiCall { dataSource.getPlaylist(id) })
        }.flowOn(Dispatchers.IO)
    }
}