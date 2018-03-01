package aykuttasil.com.myviewmodelskeleton.util.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import aykuttasil.com.myviewmodelskeleton.databinding.ItemUserLayoutBinding

/**
 * Created by aykutasil on 31.12.2017.
 */
class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var mList = arrayListOf<UserEntity>()

    fun setList(list: ArrayList<UserEntity>) {
        if (mList.size == 0) {
            mList = list
            notifyItemRangeChanged(0, mList.size)
        } else {
            val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldItem = mList[oldItemPosition]
                    val newItem = mList[newItemPosition]

                    return oldItem.UserId == newItem.UserId
                }

                override fun getOldListSize(): Int {
                    return mList.size
                }

                override fun getNewListSize(): Int {
                    return list.size
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldItem = mList[oldItemPosition]
                    val newItem = mList[newItemPosition]

                    return oldItem.UserName == newItem.UserName
                }

                /**
                 * link areItemsTheSame = true ve areContentsTheSame = false dönerse,
                 * yani row lar aynı item a ait ama içerik değişmiş ise
                 * getChangePayload çağrılır. Ve burada item ın hangi alanı değişmiş ise belirlenerek bir Bundle a eklenir.
                 * Eklenen Bundle onBindViewHolder da payloads argümanında yakalanarak sadece değişen alanın güncellenmesi sağlanır.
                 * Örnek: Borsa uygulamasında anlık değişen fiyatları bu şekilde yakalayarak sadece ilgili alanın istediğimiz
                 * şekilde değişmesini sağlayabiliriz.
                 */
                override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
                    return super.getChangePayload(oldItemPosition, newItemPosition)
                }

            })
            mList = list
            diffResult.dispatchUpdatesTo(this)
        }
    }

    fun addItem(item: UserEntity) {
        mList.add(item)
        notifyItemInserted(mList.size)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(mList[position])
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    class ViewHolder(private var binding: ItemUserLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(UserEntity: UserEntity) = with(binding) {
            user = UserEntity
            executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup?): ViewHolder {
                val binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                return ViewHolder(binding)
            }
        }
    }

}