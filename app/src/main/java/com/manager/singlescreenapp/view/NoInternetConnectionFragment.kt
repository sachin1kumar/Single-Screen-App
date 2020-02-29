package com.manager.singlescreenapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.manager.singlescreenapp.R
import com.manager.singlescreenapp.utils.CustomApplication

class NoInternetConnectionFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var retry: TextView
    private var callBack: SimpleCallBack? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         rootView = inflater.inflate(R.layout.no_internet_connection,container,false)
         initializeViews()
         retryOnclickListener()
         return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SimpleCallBack) {
            callBack = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        callBack =  null
    }

    private fun initializeViews() {
        retry = rootView.findViewById(R.id.retry)
    }

    private fun retryOnclickListener() {
        retry.setOnClickListener {
            callBack?.onRetry()
        }
    }


}