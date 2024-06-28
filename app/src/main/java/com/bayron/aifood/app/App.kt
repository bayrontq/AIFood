package com.bayron.aifood.app

import android.app.Application
import android.util.Log
import com.aallam.openai.api.logging.LogLevel
import com.aallam.openai.client.LoggingConfig
import com.aallam.openai.client.OpenAI
import com.bayron.aifood.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    /*
     * Objeto criado neste local para exemplificar uma chamada de método usando o
     * Design Pattern Singleton (Poderia ser criado usando DI).
     */
    private lateinit var openAI: OpenAI

    override fun onCreate() {
        super.onCreate()
        instance = this

        val openAiApiKey = BuildConfig.openAiApiKey
        Log.e("AIFOOD", "openAiApiKey: $openAiApiKey")
        openAI = OpenAI(token = openAiApiKey, logging = LoggingConfig(LogLevel.All))
    }

    /*
     * Objeto estático instanciado aqui para exemplificar o Design Pattern Singleton.
     */
    companion object {
        lateinit var instance: App
            private set
    }

    /*
     * Método criado neste local para exemplificar uma chamada de método
     * usando o Design Pattern Singleton.
     */
    fun getOpenAI(): OpenAI {
        return openAI
    }
}