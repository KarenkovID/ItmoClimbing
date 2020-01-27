package com.itmoclimbing.feature.routes.presentation.list

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.feature.routes.presentation.R
import com.kommander.components.android.recycler.SimpleAdapterDelegate
import com.kommander.components.android.recycler.ViewHolder
import kotlinx.android.synthetic.main.item_route.itemRouteGrade
import kotlinx.android.synthetic.main.item_route.itemRouteImage
import kotlinx.android.synthetic.main.item_route.itemRouteSetter
import kotlinx.android.synthetic.main.item_route.itemRouteTitle

class RouteAdapterDelegate : SimpleAdapterDelegate<Route, Route>(R.layout.item_route, Route::class.java) {

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
            item: Route,
            viewHolder: ViewHolder
    ): Unit = with(viewHolder) {
        itemRouteTitle.text = item.name
        // TODO ad images support
//        Glide
//                .with(itemRouteImage)
//                .load(item.imagesUrls.firstOrNull())
//                .into(itemRouteImage)
        itemRouteGrade.text = item.grade
        itemRouteSetter.text = "${item.setter?.firstName} ${item.setter?.lastName}"
    }

}