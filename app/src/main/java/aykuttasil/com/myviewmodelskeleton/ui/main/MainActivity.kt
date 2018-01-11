package aykuttasil.com.myviewmodelskeleton.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import aykuttasil.com.myviewmodelskeleton.R
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import aykuttasil.com.myviewmodelskeleton.databinding.ActivityMainBinding
import aykuttasil.com.myviewmodelskeleton.di.ViewModelFactory
import aykuttasil.com.myviewmodelskeleton.ui.base.BaseActivity
import aykuttasil.com.myviewmodelskeleton.util.delegates.contentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    private lateinit var userEntity: UserEntity


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
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.addSampleUser(UserEntity(UserName = "Aykut", UserEmail = "aykuttasil@gmail.com", UserAge = 26, UserCity = "İstanbul"))

        mainViewModel.dataManager.getUser(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    userEntity = it
                    binding.user = userEntity
                }

        binding.btnChange.onClick {
            userEntity.observeUserName = "aykuttasil" + Random().nextInt()
        }

        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
