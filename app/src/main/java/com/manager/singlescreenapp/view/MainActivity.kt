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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        swipeRefreshListener()
        initViewModel()
        fetchRemoteData()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container)
        recyclerView = findViewById(R.id.recycler_view)
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout)
    }

    private fun fetchRemoteData() {
        retroViewModel.remoteLiveData.observe(this,
            Observer<List<Author>> { data ->
                data?.apply {
                    Log.e("Observer","response"+data.get(0))
                    setDataInAdapter(data)
                }
            })
    }

    private fun setDataInAdapter(data: List<Author>) {
        adapter = Adapter(data,this)
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

    private fun swipeRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener {
            //request network data.
            fetchRemoteData()
            adapter.notifyDataSetChanged()
            swipeRefreshLayout.isRefreshing = false
        }
    }

}
