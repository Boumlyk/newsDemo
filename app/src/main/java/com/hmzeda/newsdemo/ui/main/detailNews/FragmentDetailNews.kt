package com.hmzeda.newsdemo.ui.main.detailNews

import NewsObject
import android.app.ProgressDialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hmzeda.newsdemo.R
import com.hmzeda.newsdemo.databinding.FDetailNewsBinding
import com.hmzeda.newsdemo.databinding.FHomeBinding
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseFragment
import com.hmzeda.newsdemo.ui.util.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDetailNews constructor(private var newsObject: NewsObject):BaseFragment() {

    lateinit var binding: FDetailNewsBinding
    var progressDialog: ProgressDialog? = null




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.f_detail_news,container,false)

        initView()
        return binding.root
    }

    private fun initView(){
        viewModel= ViewModelProvider(this)[FragmentDetailNewsViewModel::class.java]
        binding.viewModel=(viewModel as FragmentDetailNewsViewModel)
        (viewModel as FragmentDetailNewsViewModel).initiateViewModel(requireActivity() as BaseActivity, newsObject)
        Glide.with(requireContext())
            .load(newsObject.newsInfoMoreInfo.imageInfo.get(0).url)
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    binding.progressbar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    binding.progressbar.visibility = View.GONE
                    return false
                }
            })
            .into(binding.imageNews)
        viewModel.actions?.observe(requireActivity()) { actions ->
            for (action in actions) {
                when (action) {
                    BaseActivity.ACTION_START_LOADING -> onStartLoading()
                    BaseActivity.ACTION_FINISH_LOADING -> onFinishLoading()
                }
            }
        }
    }
    private fun onStartLoading() {
        progressDialog = Utils.createProgressDialog(requireActivity())
    }

    private fun onFinishLoading() {
        progressDialog?.dismiss()
    }

}