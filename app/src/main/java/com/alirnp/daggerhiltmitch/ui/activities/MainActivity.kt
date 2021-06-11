package com.alirnp.daggerhiltmitch.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alirnp.daggerhiltmitch.R
import com.alirnp.daggerhiltmitch.interfaces.BaseInterface
import com.alirnp.daggerhiltmitch.di.qualifier.Impl1
import com.alirnp.daggerhiltmitch.di.qualifier.Impl2
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "LOG_ME"

    @Inject
    lateinit var firstClass: FirstClass

    @Inject
    lateinit var thirdClass: ThirdClass

    @Inject
    lateinit var fourthClass: FourthClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "firstClass getStart " + firstClass.getStart())
        Log.i(TAG, "firstClass getEnd " + firstClass.getEnd())


        Log.i(TAG, "thirdClass getStart " + thirdClass.getStart())
        Log.i(TAG, "thirdClass getEnd " + thirdClass.getEnd())

        Log.i(TAG, "fourthClass getStart " + fourthClass.getStart())
        Log.i(TAG, "fourthClass getEnd " + fourthClass.getEnd())
    }

    class FirstClass
    @Inject
    constructor(
        private val secondClass: SecondClass
    ) {
        fun getStart(): String {
            return "let's start"
        }

        fun getEnd(): String {
            return secondClass.getEnd()
        }
    }


    class SecondClass
    @Inject
    constructor() {
        fun getEnd(): String {
            return "i wanna stop"
        }
    }

    class ThirdClass
    @Inject
    constructor(
        private val baseInterfaceImpl: BaseInterfaceImpl
    ) {
        fun getStart(): String {
            return "let's start | baseInterfaceImpl"
        }

        fun getEnd(): String {
            return baseInterfaceImpl.getEnd()
        }
    }

    class FourthClass
    @Inject
    constructor(
        private val baseInterfaceImpl: BaseInterfaceWithStringImpl
    ) {
        fun getStart(): String {
            return "let's start | baseInterfaceImpl"
        }

        fun getEnd(): String {
            return baseInterfaceImpl.getEnd()
        }
    }


    class BaseInterfaceImpl @Inject constructor() : BaseInterface {
        override fun getEnd(): String {
            return "i wanna stop | baseInterfaceImpl"
        }
    }

    class BaseInterfaceWithStringImpl @Inject constructor(
        @Impl1 val anyString1: String,
        @Impl2 val anyString2: String
    ) : BaseInterface {
        override fun getEnd(): String {
            return "i wanna stop | baseInterfaceImpl | $anyString1| $anyString2 "
        }
    }
}