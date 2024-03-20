package com.htk.ytubevideo.features.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.htk.ytubevideo.R
import com.htk.ytubevideo.core.base.onViewModelAction
import com.htk.ytubevideo.core.components.CircularImage
import com.htk.ytubevideo.core.components.CustomButton
import com.htk.ytubevideo.core.components.CustomTextField
import com.htk.ytubevideo.core.components.TextView
import com.htk.ytubevideo.core.components.utils.Padding
import com.htk.ytubevideo.core.ui.color.YTubeColors
import com.htk.ytubevideo.core.utils.OnBackPressed
import com.htk.ytubevideo.features.login.ui.extensions.customTextFieldLogin
import org.koin.androidx.compose.koinViewModel


@Composable
internal fun SetupLoginScreen(
    navHost: NavHostController,
    loginViewModel: LoginViewModel = koinViewModel()
) {
    loginViewModel.setController(navHost)

    loginViewModel.onViewModelAction {

    }

    OnBackPressed(disableBackPressed = true)

    SetupLoginScreenBody(loginViewModel)
}

@Composable
internal fun SetupLoginScreenBody(loginViewModel: LoginViewModel) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = innerPadding.calculateBottomPadding(),
                    top = innerPadding.calculateTopPadding(),
                    start = 0.dp,
                    end = 0.dp
                )
                .background(color = Color.Black)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.size(48.dp))

            CircularImage(
                imageDrawableId = R.drawable.logo_app,
                contentDescription = stringResource(id = R.string.description_logo_app),
                size = 100.dp,
                padding = Padding(top = 24.dp),
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextView(
                text = stringResource(id = R.string.title_logo_app),
                fontSize = 24.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(24.dp))

            CustomTextField(value = loginViewModel.userNameInputText.value,
                onValueChange = { text ->
                    loginViewModel.userNameInputText.value = text
                }, label = {
                    TextView(
                        text = stringResource(id = R.string.login_label_username),
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }, modifier = Modifier.customTextFieldLogin()
            )

            Spacer(modifier = Modifier.size(24.dp))

            CustomTextField(value = loginViewModel.passwordInputText.value,
                onValueChange = { text ->
                    loginViewModel.passwordInputText.value = text
                }, label = {
                    TextView(
                        text = stringResource(id = R.string.login_label_password),
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }, modifier = Modifier.customTextFieldLogin()
            )

            Spacer(modifier = Modifier.size(12.dp))

            CustomButton(
                nameButton = stringResource(id = R.string.login_label_button_enter),
                onClick = {
                    loginViewModel.submitLogin(
                        loginViewModel.userNameInputText.value,
                        loginViewModel.passwordInputText.value
                    )
                })

            Spacer(modifier = Modifier.size(12.dp))

            TextView(
                text = stringResource(id = R.string.login_label_your_need_help),
                fontSize = 14.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(8.dp))

            TextView(
                text = stringResource(id = R.string.login_label_singup_now),
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}
