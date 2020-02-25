package com.manager.singlescreenapp.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.facebook.shimmer.ShimmerFrameLayout
import com.manager.singlescreenapp.R
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.view.adapters.Adapter
import com.manager.singlescreenapp.viewmodel.RetroViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout
    private lateinit var retroViewModel: RetroViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        shimmerFrameLayout = findViewById(R.id.shimmer_view_container)
        recyclerView = findViewById(R.id.recycler_view)

        initViewModel()
        fetchRemoteData()

    }

    private fun fetchRemoteData() {
        retroViewModel.remoteLiveData.observe(this,
            Observer<List<Author>> { t ->
                t?.apply {
                    Log.e("Observer","response"+t.get(0))
                    setDataInAdapter(t)
                }
            })
    }

    private fun setDataInAdapter(t: List<Author>) {
        val adapter = Adapter(t,this)
        val layoutManager = LinearLayoutManager(this)
        (recyclerView.itemAnimator as SimpleItemAnimator?)?.supportsChangeAnimations = false
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        shimmerFrameLayout.stopShimmerAnimation()
        shimmerFrameLayout.visibility = View.GONE
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

    }

    override fun onPause() {
        super.onPause()
    }


}
