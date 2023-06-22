package sam.sultan.tokenandmedia.entities

data class RegistrationForm(
    val userName: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
)
