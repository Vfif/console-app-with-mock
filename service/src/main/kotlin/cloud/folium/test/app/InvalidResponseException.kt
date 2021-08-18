package cloud.folium.test.app

class InvalidResponseException(response: HttpResponse) : RuntimeException("Invalid response: $response")