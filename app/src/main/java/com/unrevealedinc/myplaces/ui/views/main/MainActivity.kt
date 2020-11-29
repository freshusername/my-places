package com.unrevealedinc.myplaces.ui.views.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.unrevealedinc.myplaces.R
import com.unrevealedinc.myplaces.databinding.ActivityMainBinding
import com.unrevealedinc.myplaces.ui.utils.timer.ActiveTimer
import com.unrevealedinc.myplaces.ui.utils.timer.DestroyTimer
import com.unrevealedinc.myplaces.ui.utils.timer.MyPlacesTimer
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
const val SAVED_COUNT = "save_count"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var timerActive: MyPlacesTimer
    private lateinit var timerDestroy: MyPlacesTimer
    private var bundleSavedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("onCreate Called")

        //init timers
        timerActive = ActiveTimer(this.lifecycle)
        timerDestroy = DestroyTimer(this.lifecycle)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            bottomNavigationView.setupWithNavController(findNavController(R.id.navigationHostFragment))
        }

        if(savedInstanceState != null){
            bundleSavedCount = savedInstanceState.getInt(SAVED_COUNT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //saves key-value to bundle
        outState.putInt(SAVED_COUNT, bundleSavedCount++)
        Timber.i("onSaveInstanceState called")

    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
        Timber.i("bundleSavedCount = $bundleSavedCount")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
        var percentage = timerActive.secondsCount.toDouble()/timerDestroy.secondsCount.toDouble() * 100
        Timber.i("Time between onStart <-> onDestroy is : ${timerActive.secondsCount}/${timerDestroy.secondsCount} sec => $percentage %")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }
}