package com.sumpaulo.indriver_jetpack.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sumpaulo.indriver_jetpack.core.Config.AUTH_KEY
import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class LocalDatastore(private val datastore: DataStore<Preferences>) {
    suspend fun save(authResponse: AuthResponse){
        val datastoreKey = stringPreferencesKey(AUTH_KEY)

        datastore.edit { pref ->
            pref[datastoreKey] = authResponse.toJson() //salva em string
        }
    }

    suspend fun update(user: User){
        val datastoreKey = stringPreferencesKey(AUTH_KEY)

        val authResponse = runBlocking {
            getData().first()
        }

        authResponse.user?.name = user.name
        authResponse.user?.lastname = user.lastname
        authResponse.user?.phone = user.phone

        if(!user.image.isNullOrBlank()){
            authResponse.user?.image = user.image
        }

        datastore.edit { pref ->
            pref[datastoreKey] = authResponse.toJson() //salva em string
        }
    }

    suspend fun delete(){
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        datastore.edit { pref ->
            pref.remove(datastoreKey)
        }
    }


    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return datastore.data.map { pref ->
            if(pref[dataStoreKey] != null){
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            }
            else {
                AuthResponse()
            }
        }
    }
}