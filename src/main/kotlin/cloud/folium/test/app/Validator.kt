package cloud.folium.test.app

import java.net.URL

class Validator {

    fun validate(url: String) {
        try {
            URL(url)
        } catch (ex: Exception) {
            throw InvalidInputException("Invalid url form: $url")
        }
    }
}