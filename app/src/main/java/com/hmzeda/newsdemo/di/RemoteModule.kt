package com.hmzeda.newsdemo.di

import android.content.Context
import com.hmzeda.newsdemo.BuildConfig
import com.hmzeda.newsdemo.data.remote.APISettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    companion object{

        @Provides
        @Singleton
        fun provideRetrofit(@ApplicationContext context: Context):Retrofit{

            // in this section we can many thing to archive our needs and have more visibility
            // and customize our api request like interceptors, evenListner,authenticator to api..
            // here i will implement just my need to do this task its just a demo

            val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
                .connectTimeout(APISettings.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(APISettings.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(APISettings.WRITE_TIMEOUT, TimeUnit.SECONDS)

            val okHttpClient: OkHttpClient = httpClientBuilder.build()
            val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(BuildConfig.BACKEND_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
            return  retrofitBuilder.client(okHttpClient).build()
        }
    }


}