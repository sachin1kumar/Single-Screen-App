package com.manager.singlescreenapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.facebook.shimmer.ShimmerFrameLayout
import com.manager.singlescreenapp.R
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.viewmodel.RetroViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout
    lateinit var retroViewModel: RetroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        shimmerFrameLayout = findViewById(R.id.shimmer_view_container)

        initViewModel()
        fetchRemoteData()

    }

    private fun fetchRemoteData() {
        retroViewModel.remoteLiveData.observe(this, object : Observer<List<Author>> {
            override fun onChanged(t: List<Author>?) {
                t?.apply {
                    Log.e("Observer","response"+t.get(0))
                }
            }
        })
    }

    private fun initViewModel() {
        retroViewModel = ViewModelProviders.of(this).get(RetroViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return true
    }

    override fun onResume() {
        super.onResume()
        shimmerFrameLayout.startShimmerAnimation()

        //TODO

    }

    override fun onPause() {
        super.onPause()
        shimmerFrameLayout.stopShimmerAnimation()
    }


}
