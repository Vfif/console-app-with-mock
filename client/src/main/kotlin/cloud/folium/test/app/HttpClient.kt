package cloud.folium.test.app

interface HttpClient {

    fun get(url: String): HttpResponse
}