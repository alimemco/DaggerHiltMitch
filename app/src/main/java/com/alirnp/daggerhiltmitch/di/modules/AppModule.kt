package com.alirnp.daggerhiltmitch.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
object AppModule {

    @ActivityScoped
    @Provides
    fun provideCompany() : String{
        return "it's me"
    }
}