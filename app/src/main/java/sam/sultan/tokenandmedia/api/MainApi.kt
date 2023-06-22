package sam.sultan.tokenandmedia.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import sam.sultan.tokenandmedia.entities.ProfileForm

interface MainApi {

    @PUT("profile/")
    suspend fun setProfile(@Body profileForm: ProfileForm): Response<ProfileForm>

}