package yash.com.example.weddingManagement

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

//    private var viewPagerIcon: ViewPager? = null
//    private var modelsIcon = arrayListOf<ModelIcon>()
//    var mIcon: BigAdapter? = null

    var recyclerView: RecyclerView? =null
//    var postAdapter: RecyclerAdaptor? = null
    val models = arrayListOf<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        actionBar?.title = "Home"

        recyclerView = findViewById(R.id.recyclerview)

//        iconSetter()
        loadBoards()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.logout){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun loadBoards() {
        models.add(Model(R.drawable.hair, "HAIR", "Find the Best Salon's Near You!!. Get ready with Threading, Waxing, facials, Hair Cutting,..."))
        models.add(Model(R.drawable.mehndi, "Mehndi Celebration", "A smile and dark stained henna are a bride's most beautiful makeup."))
        models.add(Model(R.drawable.makeup, "Beauty Parlor", "Taking care of all of your needs."))
        models.add(Model(R.drawable.camera_man, "Photographers", "Best Photographers from Pre-wedding shoot to Wedding. Bringing Joy of Every Photo"))
        models.add(Model(R.drawable.haldi, "Haldi Celebration", "A smell that is difficult to check."))
        models.add(Model(R.drawable.food, "Catering", "Giving you the best food experience. Mouth-watering dishes for your celebrations"))
        models.add(Model(R.drawable.hotel, "Hotels", "See life from a different perspective. Because comfort is more important"))

        recyclerView?.layoutManager = GridLayoutManager(this,1)
        recyclerView?.adapter = RecyclerAdaptor(this, models)
    }

}


//    private fun iconSetter(){
//        modelsIcon = ArrayList()
//        modelsIcon.add(ModelIcon(R.drawable.car))
//        modelsIcon.add(ModelIcon(R.drawable.celebration))
//        modelsIcon.add(ModelIcon(R.drawable.chocolate))
//        modelsIcon.add(ModelIcon(R.drawable.date))
//        modelsIcon.add(ModelIcon(R.drawable.sound))
//        modelsIcon.add(ModelIcon(R.drawable.cake))
//        modelsIcon.add(ModelIcon(R.drawable.car))
//        modelsIcon.add(ModelIcon(R.drawable.celebration))
//        modelsIcon.add(ModelIcon(R.drawable.chocolate))
//        modelsIcon.add(ModelIcon(R.drawable.date))
//
//
//        mIcon = BigAdapter(modelsIcon,this)
//
//        viewPagerIcon = findViewById(R.id.viewPagerIcon)
//        viewPagerIcon?.adapter = mIcon
//        viewPagerIcon?.setPadding(400,0,400,0)
//
//    }