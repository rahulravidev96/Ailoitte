package com.example.ailottecompany.data.model

import com.example.ailottecompany.data.model.Launch
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsApus {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("imageUrl")
    @Expose
    var imageUrl: String? = null

    @SerializedName("newsSite")
    @Expose
    var newsSite: String? = null

    @SerializedName("summary")
    @Expose
    var summary: String? = null

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null

    @SerializedName("featured")
    @Expose
    var featured: Boolean? = null

    @SerializedName("launches")
    @Expose
    var launches: List<Launch>? = null

    @SerializedName("events")
    @Expose
    var events: List<Any>? = null
}