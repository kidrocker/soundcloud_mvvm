package co.ke.soundcloud.data.network

import co.ke.soundcloud.core.Resource
import retrofit2.Response

/**
 * Generic class to handle the response and all errors
 */
abstract class BaseApiResponse {

    suspend fun <T> handleApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }
    private fun <T> error(errorMessage: String): Resource<T> =
        Resource.Failure("Error occurred:  $errorMessage")
}