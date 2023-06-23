package sam.sultan.tokenandmedia.view_models

import android.util.Patterns
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {

    fun validEmail(email: String): String?{
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid email"
        }
        return null
    }

    fun samePassword(password1: String, password2: String): String?{
        if(!password1.equals(password2)){
            return null
        }
        return "Пароли не совпадают"
    }
}