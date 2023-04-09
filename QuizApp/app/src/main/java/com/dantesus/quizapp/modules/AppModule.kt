package com.dantesus.quizapp.modules

import android.app.Activity
import com.dantesus.quizapp.helpers.dataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @Provides
    @ActivityScoped
    fun createDataManager(): dataManager {
        return dataManager()
    }
}