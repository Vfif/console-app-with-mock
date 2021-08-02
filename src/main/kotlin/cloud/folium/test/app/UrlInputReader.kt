package cloud.folium.test.app

import cloud.folium.test.app.Validator

class UrlInputReader {

    fun read(): String {
        print("Enter url:")
        val input = readLine()
        println("Input: $input")
        return input ?: ""
    }
}