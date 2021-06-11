package com.alirnp.daggerhiltmitch.di.modules

import com.alirnp.daggerhiltmitch.ui.activities.MainActivity
import com.alirnp.daggerhiltmitch.interfaces.BaseInterface
import com.alirnp.daggerhiltmitch.di.qualifier.Impl1
import com.alirnp.daggerhiltmitch.di.qualifier.Impl2
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
    @Module
    class ModuleProvide {

        @ActivityScoped
        @Provides
        fun provideGson(): Gson {
            return Gson()
        }

        @Impl1
        @ActivityScoped
        @Provides
        fun provideString1(): String {
            return "provide string 1"
        }

        @Impl2
        @ActivityScoped
        @Provides
        fun provideString2(): String {
            return "provide string 2"
        }

        @ActivityScoped
        @Provides
        fun provideInterface(
            anyString1: String,
            anyString2: String
        ): BaseInterface {
            return MainActivity.BaseInterfaceWithStringImpl(anyString1, anyString2)
        }
    }