package co.ke.soundcloud.util

abstract class UseCase<request:UseCase.RequestValues, response:UseCase.ResponseValue> {

    var requestValues: request? = null

    var useCaseCallback: UseCaseCallback<response>? = null

    internal fun run() {
        executeUseCase(requestValues)
    }

    protected abstract fun executeUseCase(requestValues: request?)

    /**
     * Data passed to a request.
     */
    interface RequestValues

    /**
     * Data received from a request.
     */
    interface ResponseValue

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
        fun onError(t: Throwable)
    }
}