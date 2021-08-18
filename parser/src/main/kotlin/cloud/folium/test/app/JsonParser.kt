package cloud.folium.test.app

interface JsonParser {

    fun parse(json: String): Person
}