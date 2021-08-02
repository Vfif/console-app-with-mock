package cloud.folium.test.app.dto

data class Person(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val passportId: String
){

    override fun toString(): String = "Person (firstName=$firstName, lastName=$lastName, email=$email, " +
        "phoneNumber=$phoneNumber)"
}
