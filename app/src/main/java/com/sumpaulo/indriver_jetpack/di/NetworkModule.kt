package com.sumpaulo.indriver_jetpack.di

import com.sumpaulo.indriver_jetpack.core.Config
import com.sumpaulo.indriver_jetpack.data.local.datastore.LocalDatastore
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.AuthService
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun provideOkHttpClient(datastore: LocalDatastore) = OkHttpClient.Builder()
        .addInterceptor{
            val token = runBlocking {
                datastore.getData().first().token
            }
            val newRequest = it.request().newBuilder()
                .addHeader("Authorization", token ?: "")
                .build()

            it.proceed(newRequest)
        }
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }


}