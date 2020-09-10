package com.adair.wanandroid.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.adair.wanandroid.R
import com.adair.wanandroid.common.base.BaseActivity
import com.adair.wanandroid.ui.home.HomeFragment
import com.adair.wanandroid.ui.knowledge.KnowledgeFragment
import com.adair.wanandroid.ui.navigation.NavigationFragment
import com.adair.wanandroid.ui.officialaccounts.OfficialAccountsFragment
import com.adair.wanandroid.ui.project.ProjectFragment
import com.gyf.immersionbar.ktx.immersionBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * 首页主页面
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/7
 */
class MainActivity : BaseActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    private lateinit var fragmentStateAdapter: FragmentStateAdapter

    private val fragments = listOf(HomeFragment.newInstance(),
        KnowledgeFragment.newInstance(),
        NavigationFragment.newInstance(),
        OfficialAccountsFragment.newInstance(),
        ProjectFragment.newInstance()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        immersionBar {}

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        fragmentStateAdapter = MainFragmentAdapter(this, fragments)

        contentViewPager2.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
            adapter = fragmentStateAdapter
            registerOnPageChangeCallback(object : OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    navView.menu.getItem(position).isChecked = true
                }
            })
        }

        navView.apply {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.homeFragment -> contentViewPager2.setCurrentItem(0, true)
                    R.id.knowledgeFragment -> contentViewPager2.setCurrentItem(1, true)
                    R.id.navigationFragment -> contentViewPager2.setCurrentItem(2, true)
                    R.id.officialAccountsFragment -> contentViewPager2.setCurrentItem(3, true)
                    R.id.projectFragment -> contentViewPager2.setCurrentItem(4, true)
                }
                true
            }
        }
    }

    class MainFragmentAdapter(
        fragmentActivity: FragmentActivity,
        private val fragments: List<Fragment>
    ) : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }
}


