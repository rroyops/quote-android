package com.rroyops.quoteapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Represents a single quote. This class is annotated for both Retrofit
 * (via Gson field mapping) and Room (as a local cache table), so the same
 * shape is used end-to-end — no separate DTO/Entity mapping layer needed
 * for a model this small. If this app grew, splitting them apart would be
 * the next refactor.
 */
@Entity(tableName = "favorite_quotes")
data class Quote(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("text")
    val text: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("category")
    val category: String
)
