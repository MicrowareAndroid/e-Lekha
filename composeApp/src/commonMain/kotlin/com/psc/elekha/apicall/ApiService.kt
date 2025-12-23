package com.psc.elekha.apicall


import com.psc.elekha.model.MasterRequest
import com.psc.elekha.utils.Config.MASTER
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiService(private val client: HttpClient) {

    suspend fun getMaster(masterRequest: MasterRequest): HttpResponse {
        return client.get(MASTER) {
            url {
                parameters.append("pUsername", masterRequest.pUsername)
                parameters.append("pPassword", masterRequest.pPassword)
            }
            contentType(ContentType.Application.Json)
        }
    }




}
