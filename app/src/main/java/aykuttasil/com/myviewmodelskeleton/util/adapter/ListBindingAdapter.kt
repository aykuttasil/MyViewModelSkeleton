package aykuttasil.com.myviewmodelskeleton.util.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import aykuttasil.com.myviewmodelskeleton.data.Resource

/*
class ListBindingAdapter {
    @BindingAdapter(value = "resource")
    fun setResource(recyclerView: RecyclerView, resource: Resource<>) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter ?: return

        if (resource.data == null)
            return

        if (adapter is BaseAdapter) {
            ((BaseAdapter) adapter).setData((List) resource . data);
        }
    }
}
*/