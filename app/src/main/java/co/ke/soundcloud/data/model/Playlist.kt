package co.ke.soundcloud.data.model

/*
*Separating ui and network data classes allow us
* to hold only what is needed for the ui
 */
data class Playlist(
        val name: String,
        val tracks: List<Track>,
        val duration: String // conversion is done while mapping
)
