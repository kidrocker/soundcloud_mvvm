package co.ke.soundcloud.ui.playlist.domain

import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.ui.playlist.data.network.BaseApiResponse
import co.ke.soundcloud.ui.playlist.data.network.source.PlaylistDataSource
import co.ke.soundcloud.ui.playlist.data.remote.Playlist
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

    /**
     * work
     */
    suspend fun getPlaylist(id: Long): Flow<Resource<Playlist>> {
        return flow {

            // show loading bar to notify the ui of we are loading data
            emit(Resource.Loading)

            // fetch data from the backend  and emit
            emit(handleApiCall { dataSource.getPlaylist(id) })

        }.flowOn(Dispatchers.IO)
    }
}