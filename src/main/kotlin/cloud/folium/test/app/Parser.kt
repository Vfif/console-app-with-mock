package cloud.folium.test.app

import cloud.folium.test.app.dto.Person
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder


class Parser {
    private val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    fun parse(json: String) = gson.fromJson(json, Person::class.java)
}