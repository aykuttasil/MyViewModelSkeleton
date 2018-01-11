package aykuttasil.com.myviewmodelskeleton.ui.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import aykuttasil.com.myviewmodelskeleton.R
import aykuttasil.com.myviewmodelskeleton.databinding.ActivityUserBinding
import aykuttasil.com.myviewmodelskeleton.di.ViewModelFactory
import aykuttasil.com.myviewmodelskeleton.ui.base.BaseActivity
import aykuttasil.com.myviewmodelskeleton.util.delegates.contentView
import javax.inject.Inject


class UserActivity : BaseActivity() {

    private val binding: ActivityUserBinding by contentView(R.layout.activity_user)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this@UserActivity, viewModelFactory).get(UserViewModel::class.java)
    }
}
