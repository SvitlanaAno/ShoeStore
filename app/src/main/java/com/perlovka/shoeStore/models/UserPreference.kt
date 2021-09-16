package com.perlovka.shoeStore.models

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//Create the dataStore
private val Context.dataStore by preferencesDataStore("user_preferences")

class UserPreference(context: Context) {
    private val dataStore = context.dataStore

    //Get auth status
    val authStatus: Flow<UserStatus> = dataStore.data
        .map { preferences ->
            when (preferences[USER_STATUS] ?: false) {
                false -> UserStatus.UNAUTHENTICATED
                true -> UserStatus.AUTHENTICATED
            }
        }

    //Save auth status
    suspend fun saveAuthStatus(status: UserStatus) {
        dataStore.edit { preferences ->
            preferences[USER_STATUS] = when (status) {
                UserStatus.UNAUTHENTICATED -> false
                UserStatus.AUTHENTICATED -> true
            }
        }
    }

    //Create key
    companion object {
        val USER_STATUS = booleanPreferencesKey("user_status")
    }


}
enum class UserStatus {
    UNAUTHENTICATED, AUTHENTICATED
}