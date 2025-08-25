package ru.ibaevzz.vibehack.utils

suspend inline fun <T> safeCallApi(
    callApi: suspend () -> Result<T>
) = try {
    callApi()
} catch (ex: Exception) {
    Result.failure(ex)
}