package com.example.ailottecompany.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Launch {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("provider")
    @Expose
    var provider: String? = null
}