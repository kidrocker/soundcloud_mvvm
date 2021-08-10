package co.ke.soundcloud.util

/**
 * Generic class to map network model classes into entity models
 */
interface EntityMapper<Entity, NetworkModel> {
    fun mapToEntity(networkModel: NetworkModel):Entity
}