package sam.sultan.tokenandmedia.view_models

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.tokenandmedia.api.SessionManager
import sam.sultan.tokenandmedia.entities.LoginForm
import sam.sultan.tokenandmedia.entities.LoginResponse
import sam.sultan.tokenandmedia.entities.ProfileForm
import sam.sultan.tokenandmedia.entities.RegistrationForm
import sam.sultan.tokenandmedia.repositories.AuthRepository
import sam.sultan.tokenandmedia.utils.Resource

class AuthViewModel: ViewModel() {

    val repository = AuthRepository()

    val login: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

    val registration: MutableLiveData<Resource<LoginForm>> = MutableLiveData()

    val profileSet: MutableLiveData<Resource<ProfileForm>> = MutableLiveData()

    val profile: MutableLiveData<Resource<ProfileForm>> = MutableLiveData()

    val sessionManager = SessionManager()

    fun getProfile(){
        viewModelScope.launch {
            profile.postValue(Resource.Loading())
            val response = repository.getProfile()
            if (response.isSuccessful){
                response.body()?.let {
                    profile.postValue(Resource.Success(it))
                }
            }else{
                profile.postValue(Resource.Error(response.message()))
            }
        }
    }

    fun registration(registrationForm: RegistrationForm){
        viewModelScope.launch {
            registration.postValue(Resource.Loading())
            val response = repository.register(registrationForm)
            if (response.isSuccessful){
                response.body()?.let {
                    registration.postValue(Resource.Success(it))
                }
            }else{
                registration.postValue(Resource.Error(response.message()))
            }
        }
    }

    fun login(loginForm: LoginForm){
        viewModelScope.launch {
            login.postValue(Resource.Loading())
            val response = repository.login(loginForm)
            if (response.isSuccessful){
                response.body()?.let {
                    sessionManager.saveAuthToken(it.access)
                    login.postValue(Resource.Success(it))
                }
            }else{
                login.postValue(Resource.Error(response.message()))
            }
        }
    }

    fun validEmail(email: String): String?{
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid email"
        }
        return null
    }

    fun samePassword(password1: String, password2: String): String?{
        if(password1.equals(password2)){
            return null
        }
        return "Пароли не совпадают"
    }

    fun loginField(name: String, password: String): String?{
        if(name.isEmpty() || password.isEmpty()){
            return "Введите имя пользователя и пароль"
        }else{
            return null
        }
    }
}