package com.psc.elekha.apicall


import com.psc.elekha.model.MasterRequest
import io.ktor.client.statement.HttpResponse

class ApiRepository(private val apiService: ApiService) {
    suspend fun getMaster(masterRequest: MasterRequest): HttpResponse = apiService.getMaster(masterRequest)
    suspend fun getLoanRepayment(masterRequest: MasterRequest): HttpResponse = apiService.getLoanRepayment(masterRequest)

    suspend fun getGTRData(masterRequest: MasterRequest): HttpResponse = apiService.getGTRData(masterRequest)

}