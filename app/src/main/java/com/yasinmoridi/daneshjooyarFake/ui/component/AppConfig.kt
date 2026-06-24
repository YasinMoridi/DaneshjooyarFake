package com.yasinmoridi.daneshjooyarFake.ui.component

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.yasinmoridi.daneshjooyarFake.utils.Constants
import com.yasinmoridi.daneshjooyarFake.viewModel.DatStoreViewModel

@Composable
fun AppConfig(
    datStoreViewModel: DatStoreViewModel = hiltViewModel()
) {
    Constants.CHECK_LOGIN = datStoreViewModel.getIsLogin() ?: false
    Constants.USER_PIP = datStoreViewModel.getEnablePip() ?: false

}