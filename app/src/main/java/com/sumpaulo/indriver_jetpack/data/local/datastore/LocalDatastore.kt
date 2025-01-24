package com.sumpaulo.indriver_jetpack.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sumpaulo.indriver_jetpack.core.Config.AUTH_KEY
import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDatastore(private val datastore: DataStore<Preferences>) {
    suspend fun save(authResponse: AuthResponse){
        val datastoreKey = stringPreferencesKey(AUTH_KEY)

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