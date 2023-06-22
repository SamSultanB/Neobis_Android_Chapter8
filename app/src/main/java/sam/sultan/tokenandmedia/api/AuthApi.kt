package sam.sultan.tokenandmedia.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import sam.sultan.tokenandmedia.entities.LoginForm
import sam.sultan.tokenandmedia.entities.LogoutForm
import sam.sultan.tokenandmedia.entities.RegistrationForm

interface AuthApi {

    @POST("registration/")
    suspend fun register(@Body registrationForm: RegistrationForm): Response<RegistrationForm>

    @POST("login/")
    suspend fun login(@Body loginForm: LoginForm): Response<LoginForm>

    @POST("logout/")
    suspend fun logout(@Body logoutForm: LogoutForm): Response<LogoutForm>


}