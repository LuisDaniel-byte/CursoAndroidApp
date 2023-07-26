package com.example.cursoandroidapp

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView

class TemarySessions : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private  lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sessions_temary)

        val mToolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        mToolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(mToolbar)
        supportActionBar?.title="Temario"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this,drawer,mToolbar, R.string.open_menu, R.string.close_menu)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nombre -> {
                val intent = Intent(this, FirstScreen::class.java)
                startActivity(intent)
            }
            R.id.reglas -> {
                val intent = Intent(this, RulesSessions::class.java)
                startActivity(intent)
            }
            R.id.resume -> {
                val intent = Intent(this, TemarySessions::class.java)
                startActivity(intent)
            }
            R.id.temary-> {
                recreate()
            }
            R.id.sessions-> {
                val intent = Intent(this, SessionsSessions::class.java)
                startActivity(intent)
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}