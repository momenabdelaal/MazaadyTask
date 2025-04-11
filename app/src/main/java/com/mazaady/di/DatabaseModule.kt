package com.mazaady.di

import android.content.Context
import androidx.room.Room
import com.mazaady.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(
        @ApplicationContext context: Context
    ): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movies.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieDatabase) = database.movieDao()
}
