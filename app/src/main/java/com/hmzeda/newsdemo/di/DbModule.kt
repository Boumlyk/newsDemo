package com.hmzeda.newsdemo.di

import android.content.Context
import com.hmzeda.newsdemo.data.local.db.DemoDatabase
import com.hmzeda.newsdemo.data.local.doa.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    companion object{
        @Provides
        @Singleton
        fun provideDemoDataBase(@ApplicationContext context: Context): DemoDatabase {
            return  DemoDatabase.getInstance(context)
        }

        @Provides
        @Singleton
        fun provideNewsDao(database: DemoDatabase): NewsDao {
            return database.newsDao()
        }

    }
}