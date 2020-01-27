package com.itmoclimbing.feature.users.presentation.list

import com.itmoclimbing.domainCommon.model.User
import com.itmoclimbing.feature.users.presentation.R
import com.kommander.components.android.recycler.SimpleAdapterDelegate
import com.kommander.components.android.recycler.ViewHolder
import kotlinx.android.synthetic.main.item_user.itemUserFirstName
import kotlinx.android.synthetic.main.item_user.itemUserLastName

class UsersAdapterDelegate : SimpleAdapterDelegate<User, User>(R.layout.item_user, User::class.java) {

    override fun onBindViewHolder(
            item: User,
            viewHolder: ViewHolder
    ): Unit = with(viewHolder) {
        itemUserFirstName.text = item.firstName
        itemUserLastName.text = item.lastName
    }

}