package aykuttasil.com.myviewmodelskeleton.ui.user

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import aykuttasil.com.myviewmodelskeleton.R
import aykuttasil.com.myviewmodelskeleton.databinding.ActivityUserBinding
import aykuttasil.com.myviewmodelskeleton.di.ViewModelFactory
import aykuttasil.com.myviewmodelskeleton.ui.common.BaseActivity
import aykuttasil.com.myviewmodelskeleton.util.delegates.contentView
import aykuttasil.com.myviewmodelskeleton.util.logd
import javax.inject.Inject


class UserActivity : BaseActivity() {

    private val binding: ActivityUserBinding by contentView(R.layout.activity_user)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logd { "oncreate" }
        viewModel = ViewModelProviders.of(this@UserActivity, viewModelFactory).get(UserViewModel::class.java)
    }
}
