package com.itmoclimbing.feature.routes.presentation.list

import android.annotation.SuppressLint
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.feature.routes.presentation.R
import com.kommander.components.android.recycler.SimpleAdapterDelegate
import com.kommander.components.android.recycler.ViewHolder
import kotlinx.android.synthetic.main.item_route.itemRouteGrade
import kotlinx.android.synthetic.main.item_route.itemRouteSetter
import kotlinx.android.synthetic.main.item_route.itemRouteTitle

class RouteAdapterDelegate(
        private val onRouteClick: (Route) -> Unit
) : SimpleAdapterDelegate<Route, Route>(R.layout.item_route, Route::class.java) {

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
            item: Route,
            viewHolder: ViewHolder
    ) = with(viewHolder) {
        itemView.setOnClickListener { onRouteClick(item) }
        itemRouteTitle.text = item.name
        // TODO ad images support
//        Glide
//                .with(itemRouteImage)
//                .load(item.imagesUrls.firstOrNull())
//                .into(itemRouteImage)
        itemRouteGrade.text = item.grade
        if (item.setter != null) {
            itemRouteSetter.text = "${item.setter?.firstName} ${item.setter?.lastName}"
        }
    }

}