package com.htk.ytubevideo.authentication

import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FirebaseAuthenticator private constructor() {

    companion object {
        private var firebaseAuthenticator: FirebaseAuthenticator? = null

        fun getInstance() = firebaseAuthenticator ?: synchronized(this) {
            firebaseAuthenticator ?: FirebaseAuthenticator().also { firebaseAuth ->
                firebaseAuthenticator = firebaseAuth
            }
        }
    }

    private fun onInitialize() = Firebase.auth

    fun signIn(credentials: Credentials) = flow {
        try {
            val result =
                onInitialize().signInWithEmailAndPassword(credentials.email, credentials.password)
                    .await()

            emit(convertFirebaseUserToCurrentUser(result.user, result.credential))
        } catch (e: Exception) {

        }
    }

    private fun handleErrorSignIn(exception: Exception?) {}

    private fun convertFirebaseUserToCurrentUser(
        firebaseUser: FirebaseUser?,
        credential: AuthCredential?
    ): CurrentUser {
        firebaseUser?.let { firebaseUser ->
            return CurrentUser.build {
                displayName = firebaseUser.displayName
                email = firebaseUser.email
                profilePhoto = firebaseUser.photoUrl
                uid = firebaseUser.uid
                isEmailVerified = firebaseUser.isEmailVerified
                signInMethod = credential?.signInMethod
            }
        }
        error("Current User Firebase Don't Found")
    }
}