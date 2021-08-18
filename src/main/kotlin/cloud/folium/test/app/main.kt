import cloud.folium.test.app.DefaultUrlProcessingService

fun main(args: Array<String>) {

    print("Enter url:")
    val input = readLine()
    println("Input: $input")

    val service = DefaultUrlProcessingService(...)
    service.handle(input)
}