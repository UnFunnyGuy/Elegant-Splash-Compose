package com.unfunnyguy.elegant.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesUnsplashApi(): UnsplashApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
                    )
                    .addInterceptor(
                        Interceptor { chain: Interceptor.Chain ->
                            val request =
                                chain
                                    .request()
                                    .newBuilder()
                                    .addHeader(
                                        "Authorization",
                                        "Client-ID " + "ky1qNRQxgQc1ecl5i9BOSh8RCmpZMFXB5rxn1sMHECk"
                                    )
                                    .build()
                            chain.proceed(request)
                        }
                    )
                    .build()
            )
            .build()
            .create(UnsplashApi::class.java)
}
