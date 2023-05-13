package com.hmzeda.newsdemo.ui.adapter

import NewsObject
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.hmzeda.newsdemo.R
import com.hmzeda.newsdemo.ui.BaseViewModel
import com.hmzeda.newsdemo.ui.main.home.FragmentHomeViewModel
import com.hmzeda.newsdemo.util.Utils

class NewsAdapter(private val context: Context,private val viewModel : BaseViewModel)  :RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    protected var itemList: ArrayList<NewsObject> = ArrayList<NewsObject>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_historique, viewGroup, false),viewModel)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val news:NewsObject=itemList.get(position)
        viewHolder.title.text= Html.fromHtml(news.title.rendered)
        viewHolder.date.text=Utils.convertDate(news.date_gmt)
//        viewHolder.category.text="To do"
        Glide.with(context)
            .load(news.newsInfoMoreInfo.imageInfo.get(0).url)
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    viewHolder.progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    viewHolder.progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(viewHolder.image)
        viewHolder.itemView.setOnClickListener(View.OnClickListener {
            (viewModel as FragmentHomeViewModel).onItemClicked(news)
        })
    }

    override fun getItemCount(): Int {
        return itemList.size;
    }
    public fun getList(): List<NewsObject> {
        return itemList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun feedList(list:List<NewsObject>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    public fun addToList(l: NewsObject, position: Int) {
        itemList.add(l)
        try {
            notifyItemInserted(position)
        }catch (ignore: java.lang.Exception){

        }

    }

    class ViewHolder(view: View,viewModel: BaseViewModel) : RecyclerView.ViewHolder(view) {
        lateinit var title : TextView
        lateinit var date : TextView
        lateinit var progressBar : ProgressBar
        lateinit var category : TextView
        lateinit var image : ImageView
        init {
            title=view.findViewById(R.id.title)
            date=view.findViewById(R.id.date)
            category=view.findViewById(R.id.category)
            image=view.findViewById(R.id.imageNews)
            progressBar=view.findViewById(R.id.progressbar)

        }

    }
}