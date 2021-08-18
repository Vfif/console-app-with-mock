package cloud.folium.test.app

interface ResponseValidator {

    fun validate(response: HttpResponse): Boolean
}