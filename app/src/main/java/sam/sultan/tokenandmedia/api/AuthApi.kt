package sam.sultan.tokenandmedia.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import sam.sultan.tokenandmedia.entities.*

interface AuthApi {

    @POST("auth/registration/")
    suspend fun register(@Body registrationForm: RegistrationForm): Response<RegistrationForm>

    @POST("auth/login/")
    suspend fun login(@Body loginForm: LoginForm): Response<LoginResponse>

    @POST("auth/logout/")
    suspend fun logout(@Body logoutForm: LogoutForm): Response<LogoutForm>

    @PUT("auth/profile/")
    suspend fun profile(@Body profileForm: ProfileForm)

    @PUT("auth/send-code/")
    suspend fun phoneNumber(@Body phoneNumberForm: PhoneNumberForm)

    @POST("auth/token/refresh/")
    suspend fun tokenRefresh(@Body refresh: TokenRefresh): Response<TokenRefresh>

}