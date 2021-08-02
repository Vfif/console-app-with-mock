package cloud.folium.test.app

import cloud.folium.test.app.dto.Person
import java.net.URL

class Client(
    private val parser: Parser
) {

    fun get(url: String) : Person = URL(url).readText().asPerson()

    private fun String.asPerson() = parser.parse(this)
}
