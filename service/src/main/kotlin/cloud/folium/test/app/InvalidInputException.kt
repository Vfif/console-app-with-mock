package cloud.folium.test.app

class InvalidInputException(url: String?) : RuntimeException("Invalid input url: $url")