package yash.com.example.weddingManagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class BigAdapter(
    private val models: ArrayList<ModelIcon>,
    private val mContext: Context
    ) : PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.square_slides, container, false) as ViewGroup

        val imageView : ImageView = view.findViewById(R.id.image_icon)
//        val title : TextView = view.findViewById(R.id.title)
//        val desc : TextView = view.findViewById(R.id.desc)

        imageView.setImageResource(models[position].image)
//        title.text = models[position].title
//        desc.text = models[position].desc

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

}