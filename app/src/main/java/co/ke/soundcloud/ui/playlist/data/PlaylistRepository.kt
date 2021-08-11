package co.ke.soundcloud.ui.playlist.data

import co.ke.soundcloud.core.Resource
import co.ke.soundcloud.ui.playlist.model.BaseApiResponse
import co.ke.soundcloud.ui.playlist.data.remote.PlaylistDataSource
import co.ke.soundcloud.ui.playlist.model.Playlist
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * The repository controls the source of our data
 * The class can be extended to add extra sources of data eg cache
 * Using hilt we can define the lifecycle of the repository to live as long as the activity
 */
@ActivityRetainedScoped
class PlaylistRepository @Inject constructor(
    private val dataSource: PlaylistDataSource
): BaseApiResponse(){
    /**
     * fetch the playlist from the network
     * Since the return type is a stream, we can emit the loading state
     * and continue to load the data in the same method
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