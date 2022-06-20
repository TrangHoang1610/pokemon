package com.example.myfirstapp.data.model.ability

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class FlavorTextEntry {
    @SerializedName("flavor_text")
    @Expose
    var flavorText: String? = null

    @SerializedName("language")
    @Expose
    var language: Language? = null

    @SerializedName("version_group")
    @Expose
    var versionGroup: VersionGroup? = null
}