package com.manager.singlescreenapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.manager.singlescreenapp.view.NoInternetConnectionFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class NoInternetConnectionFragmentTest {

    private lateinit var noInternetConnectionFragment: NoInternetConnectionFragment

    @Test
    fun shouldNotbeNull(){
        noInternetConnectionFragment = NoInternetConnectionFragment()
        startFragment(noInternetConnectionFragment)
    }

    fun startFragment(fragment: Fragment) {
        val activity =
            Robolectric.buildActivity(FragmentActivity::class.java)
                .create()
                .start()
                .resume()
                .get()
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment,null)
        fragmentTransaction.commit()
    }


}