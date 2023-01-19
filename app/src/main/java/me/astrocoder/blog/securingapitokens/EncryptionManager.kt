package me.astrocoder.blog.securingapitokens

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

 class SharedPreferencesHelper {

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

     fun saveData(context: Context, key:String ,data: String){
        // Initialize/open an instance of EncryptedSharedPreferences on below line.
        val sharedPreferences = EncryptedSharedPreferences.create(
            // passing a file name to share a preferences
            FILE_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        sharedPreferences.edit().putString(key, data).apply()
    }


    fun getData(context: Context, key: String): String? {
        // Initialize/open an instance of EncryptedSharedPreferences on below line.
        val sharedPreferences = EncryptedSharedPreferences.create(
            // passing a file name to share a preferences
            FILE_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        // on below line creating a variable
        // to get the data from shared prefs.
        return sharedPreferences.getString(key, "")

    }

    companion object {
       const val FILE_NAME = "My_file_name"
    }
}