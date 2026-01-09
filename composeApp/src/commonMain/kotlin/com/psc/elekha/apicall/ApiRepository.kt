package com.psc.elekha.apicall


import com.psc.elekha.model.GtrRequest
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.model.RegistrationUploadRequest
import io.ktor.client.statement.HttpResponse

class ApiRepository(private val apiService: ApiService) {
    suspend fun getAuthentication(masterRequest: MasterRequest): HttpResponse = apiService.getAuthentication(masterRequest)
    suspend fun getOTP(mobileNo: String): HttpResponse = apiService.getOTP(mobileNo)
    suspend fun verifyOTP(mobileNo: String,enteredOTP: String): HttpResponse = apiService.verifyOTP(mobileNo,enteredOTP)
    suspend fun getMaster(masterRequest: MasterRequest): HttpResponse = apiService.getMaster(masterRequest)
    suspend fun getDashboardData(userId: String): HttpResponse = apiService.getDashboardData(userId)
    suspend fun getLoanRepayment(masterRequest: MasterRequest): HttpResponse = apiService.getLoanRepayment(masterRequest)

    suspend fun getGTRData(gtrRequest: GtrRequest): HttpResponse = apiService.getGTRData(gtrRequest)
    suspend fun uploadRegistrationData(registrationRequest: RegistrationUploadRequest): HttpResponse = apiService.uploadRegistration(registrationRequest)

}