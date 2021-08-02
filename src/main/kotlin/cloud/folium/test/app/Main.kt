package cloud.folium.test.app

fun main() {
    val inputReader = UrlInputReader()
    val url = inputReader.read()

    val validator = Validator()
    validator.validate(url)

    val parser = Parser()
    val client = Client(parser)
    val jsonStr = client.get(url)

    print(jsonStr)
}