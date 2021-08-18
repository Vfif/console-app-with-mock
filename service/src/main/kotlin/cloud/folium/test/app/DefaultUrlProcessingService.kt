package cloud.folium.test.app

class DefaultUrlProcessingService (
    private val urlValidator: UrlValidator,
    private val client: HttpClient,
    private val responseValidator: ResponseValidator,
    private val parser: JsonParser,
 ): UrlProcessingService {

    override fun handle(input: String?): Person {

        if (urlValidator.validate(input)) throw InvalidInputException(input)

        val url = input!!
        val response = client.get(url)

        if (responseValidator.validate(response)) throw InvalidResponseException(response)

        val person = parser.parse(response.body)

        return person.secureInfo()
    }
}