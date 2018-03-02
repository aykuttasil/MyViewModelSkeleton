package aykuttasil.com.myviewmodelskeleton.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import aykuttasil.com.myviewmodelskeleton.R
import aykuttasil.com.myviewmodelskeleton.databinding.ActivityMainBinding
import aykuttasil.com.myviewmodelskeleton.di.ViewModelFactory
import aykuttasil.com.myviewmodelskeleton.ui.common.BaseActivity
import aykuttasil.com.myviewmodelskeleton.ui.common.NavigationController
import aykuttasil.com.myviewmodelskeleton.ui.common.RetryCallback
import aykuttasil.com.myviewmodelskeleton.util.delegates.contentView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var navigationController: NavigationController

    private lateinit var mainViewModel: MainViewModel

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)


        mainViewModel.getUser("aykuttasillll").observe(this, Observer {
            binding.user = it?.data
            binding.resource = it
            binding.callback = object : RetryCallback {
                override fun retry() {
                    mainViewModel.retryGetUser("aykuttasil")
                }

            }
            binding.executePendingBindings()
        })

    }
}
