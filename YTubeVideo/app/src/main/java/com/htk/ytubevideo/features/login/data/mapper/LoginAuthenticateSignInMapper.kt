package com.htk.ytubevideo.features.login.data.mapper

import com.htk.ytubevideo.authentication.CurrentUser
import com.htk.ytubevideo.core.utils.Mapper
import com.htk.ytubevideo.features.login.data.model.LoginAuthenticateCredentials

class LoginAuthenticateSignInMapper : Mapper<CurrentUser, LoginAuthenticateCredentials> {

    override fun map(source: CurrentUser) = LoginAuthenticateCredentials(uid = source.uid)
}