package ru.ibaevzz.vibehack.utils

import android.content.Context
import javax.inject.Inject

class ResourceUtils @Inject constructor(
    private val context: Context
) {

    fun getString(id: Int) = context.getString(id)

}