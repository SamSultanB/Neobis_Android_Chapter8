package sam.sultan.tokenandmedia.repositories

import sam.sultan.tokenandmedia.api.RetrofitInstance
import sam.sultan.tokenandmedia.api.SessionManager
import sam.sultan.tokenandmedia.entities.LoginForm
import sam.sultan.tokenandmedia.entities.LogoutForm
import sam.sultan.tokenandmedia.entities.ProfileForm
import sam.sultan.tokenandmedia.entities.RegistrationForm

class AuthRepository {

    private val authApi = RetrofitInstance.apiAuth

    suspend fun register(registrationForm: RegistrationForm) = authApi.register(registrationForm)

    suspend fun login(loginForm: LoginForm) = authApi.login(loginForm)

    suspend fun getProfile() = authApi.getProfile(SessionManager.USER_TOKEN, ProfileForm("", "", "", "", ""))

}