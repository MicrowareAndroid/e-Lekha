package com.psc.elekha.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.viewmodel.LoanOfficerDashboardViewModel
import com.psc.elekha.response.LoanOfficerDashboardResponse
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.currentDate
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.something_wentwrong
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class HomeScreenViewModel(
    private val apiRepository: ApiRepository,
    private val loanOfficerDashboardViewModel: LoanOfficerDashboardViewModel,
    val appPreferences: AppPreferences
) : ViewModel() {

    private val _dataState = MutableStateFlow<APiState>(APiState.idle)
    val dataState: StateFlow<APiState> = _dataState

    fun getDashboardData(userId: String) {
        viewModelScope.launch {
            _dataState.value = APiState.loading
            try {
                val response = apiRepository.getDashboardData(userId)

                val code = response.status.value
                if (code == 200) {
                    val body = response.body<LoanOfficerDashboardResponse>()
                    body.let {
                        loanOfficerDashboardViewModel.insertAllLoanOfficerData(it.loanofficerDashBoardData)
                        appPreferences.putString(AppSP.DashboardDownloaddate, currentDate())
                    }
                    _dataState.value = APiState.success("Download successfully")

                } else if (code == 401) {
                    _dataState.value = APiState.error(getString(Res.string.something_wentwrong))
                } else {
                    _dataState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _dataState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

}