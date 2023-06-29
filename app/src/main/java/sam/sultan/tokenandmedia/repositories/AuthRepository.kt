package sam.sultan.tokenandmedia.repositories

import sam.sultan.tokenandmedia.api.MainRetrofitInstance
import sam.sultan.tokenandmedia.entities.LoginForm
import sam.sultan.tokenandmedia.entities.LogoutForm
import sam.sultan.tokenandmedia.entities.RegistrationForm

class AuthRepository {

    private val authApi = MainRetrofitInstance.apiAuth

    suspend fun register(registrationForm: RegistrationForm) = authApi.register(registrationForm)

    suspend fun login(loginForm: LoginForm) = authApi.login(loginForm)

    suspend fun logout(logoutForm: LogoutForm) = authApi.logout(logoutForm)

}