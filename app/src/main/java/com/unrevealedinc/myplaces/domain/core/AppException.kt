package com.unrevealedinc.myplaces.domain.core

import com.unrevealedinc.myplaces.R

internal sealed class AppException(
    override val message: String?,
    val messageResource: StringResource = StringResource(R.string.exception_something_bag_happened),
    cause: Throwable? = null
) : Exception(message, cause) {

    class ParsingAPIResponseException(
        message: String? = null,
        messageResource: StringResource = StringResource(R.string.exception_parsing_response_error),
        throwable: Throwable? = null
    ) : AppException(message, messageResource, throwable)

    class NetworkException(
        message: String? = null,
        messageResource: StringResource = StringResource(messageResId = R.string.exception_internet_connection),
        throwable: Throwable? = null
    ) : AppException(message, messageResource, throwable)

    class SomethingBadHappenException(
        message: String? = null,
        messageResource: StringResource = StringResource(messageResId = R.string.exception_something_bag_happened),
        throwable: Throwable? = null
    ) : AppException(message, messageResource, throwable)

    open class HttpException(
        message: String? = null,
        messageResource: StringResource = StringResource(messageResId = R.string.exception_something_bag_happened),
        throwable: Throwable? = null,
        val errorCode: Int
    ) : AppException(message, messageResource, throwable) {

        class ClientException(
            message: String? = null,
            messageResource: StringResource = StringResource(messageResId = R.string.exception_client_side_error),
            throwable: Throwable? = null,
            errorCode: Int
        ) : HttpException(message, messageResource, throwable, errorCode)

        class ServerException(
            message: String? = null,
            messageResource: StringResource = StringResource(messageResId = R.string.exception_server_side_error),
            throwable: Throwable? = null,
            errorCode: Int
        ) : HttpException(message, messageResource, throwable, errorCode)
    }
}