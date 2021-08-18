package cloud.folium.test.app

interface UrlProcessingService {

    fun handle(url: String?): Person
}