package com.ccastro.court.core

import android.util.Log

object Utils {

    fun countWords(frase: String): Int {
        val totalWords = frase.trim().split("\\s+".toRegex()).size
        Log.d(Constans.TAG, "totalWords '$frase': $totalWords")
        return frase.trim().split("\\s+".toRegex()).size
    }

}