package aykuttasil.com.myviewmodelskeleton.ui.common

import android.support.v4.app.FragmentManager
import aykuttasil.com.myviewmodelskeleton.R
import aykuttasil.com.myviewmodelskeleton.ui.main.MainActivity
import javax.inject.Inject

/**
 * Created by aykutasil on 2.03.2018.
 */
class NavigationController @Inject constructor(private val mainActivity: MainActivity) {

    private var containerId: Int = 0
    private var fragmentManager: FragmentManager? = null

    init {
        this.containerId = R.id.container;
        this.fragmentManager = mainActivity.supportFragmentManager
    }

    /*
        public void navigateToSearch() {
        SearchFragment searchFragment = new SearchFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, searchFragment)
                .commitAllowingStateLoss();
    }

    public void navigateToRepo(String owner, String name) {
        RepoFragment fragment = RepoFragment.create(owner, name);
        String tag = "repo" + "/" + owner + "/" + name;
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    public void navigateToUser(String login) {
        String tag = "user" + "/" + login;
        UserFragment userFragment = UserFragment.create(login);
        fragmentManager.beginTransaction()
                .replace(containerId, userFragment, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
    */
}