package com.itmoclimbing.features.common

interface FeatureComponent<TApi> {

    fun api(): TApi

}