package sam.sultan.tokenandmedia.entities

data class LoginResponse(
    val access: String,
    val refresh: String,
    val status: String
)