package com.example.tracker_domain.di

import com.example.core.domain.preferences.Preferences
import com.example.tracker_domain.repository.TrackerRepository
import com.example.tracker_domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ) :  TrackerUseCases{

        return TrackerUseCases(
            TrackFood(repository),
            SearchFood(repository),
            GetFoodsForDate(repository),
            DeleteTrackedFood(repository),
            CalculateMealNutrients(preferences)
        )
    }
}