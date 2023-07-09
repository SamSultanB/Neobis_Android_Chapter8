package sam.sultan.tokenandmedia.entities

data class RegistrationForm(
    val username: String,
    val email: String,
    val password: String,
    val confirm_password: String
)
