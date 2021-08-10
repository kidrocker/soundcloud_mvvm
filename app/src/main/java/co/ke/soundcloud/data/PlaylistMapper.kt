package co.ke.soundcloud.data

import co.ke.soundcloud.data.model.Playlist
import co.ke.soundcloud.data.model.Track
import co.ke.soundcloud.data.remote.RemotePlaylist
import co.ke.soundcloud.util.DateFormatter
import co.ke.soundcloud.util.EntityMapper

/**
 * Mapping remote playlist object to local playlist object
 */
class PlaylistMapper : EntityMapper<Playlist, RemotePlaylist> {
    override fun mapToEntity(networkModel: RemotePlaylist): Playlist {

        val tracks = mutableListOf<Track>()
        networkModel.tracks.forEach {
            val track = Track(
                title = it.title,
                artist = it.artist.name,
                id = it.id,
                duration = DateFormatter.convertToString(it.duration)
            )
            tracks.add(track)
        }

        return Playlist(
            name = networkModel.title,
            duration = DateFormatter.convertToString(networkModel.duration),
            tracks = tracks
        )
    }
}