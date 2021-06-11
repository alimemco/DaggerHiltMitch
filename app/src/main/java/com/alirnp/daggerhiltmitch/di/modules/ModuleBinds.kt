package com.alirnp.daggerhiltmitch.di.modules

import com.alirnp.daggerhiltmitch.ui.activities.MainActivity
import com.alirnp.daggerhiltmitch.interfaces.BaseInterface
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
    @Module
    abstract class ModuleBinds {

        @ActivityScoped
        @Binds
        abstract fun bindSomeDependency(
            baseInterfaceImpl: MainActivity.BaseInterfaceImpl
        ): BaseInterface

        @ActivityScoped
        @Binds
        abstract fun bindGson(
            gson: Gson
        ): Gson
    }