package com.psc.elekha.apicall


import com.psc.elekha.model.GtrRequest
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.utils.Config.AUTHENTICATION
import com.psc.elekha.utils.Config.DASHBOARDDATA
import com.psc.elekha.utils.Config.GTR
import com.psc.elekha.utils.Config.LOAN_REPAYMENT
import com.psc.elekha.utils.Config.MASTER
import com.psc.elekha.utils.Config.SENDOTPCODE
import com.psc.elekha.utils.Config.VALIDATEOTP
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiService(private val client: HttpClient) {

    suspend fun getAuthentication(masterRequest: MasterRequest): HttpResponse {
        return client.get(AUTHENTICATION) {
            url {
                parameters.append("pUsername", masterRequest.pUsername)
                parameters.append("pPassword", masterRequest.pPassword)
            }
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getOTP(mobileNo: String): HttpResponse {
        return client.get(SENDOTPCODE) {
            url {
                parameters.append("sMobileNumber", mobileNo)
            }
            contentType(ContentType.Application.Json)
        }
    }
    suspend fun verifyOTP(mobileNo: String,enteredOTP: String): HttpResponse {
        return client.get(VALIDATEOTP) {
            url {
                parameters.append("sMobileNumber", mobileNo)
                parameters.append("sValidationCode", enteredOTP)
            }
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getMaster(masterRequest: MasterRequest): HttpResponse {
        return client.get(MASTER) {
            url {
                parameters.append("pUsername", masterRequest.pUsername)
                parameters.append("pPassword", masterRequest.pPassword)
            }
            contentType(ContentType.Application.Json)
        }
    }
    suspend fun getDashboardData(userId: String): HttpResponse {
        return client.get(DASHBOARDDATA) {
            url {
                parameters.append("userId", "1")
            }
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getLoanRepayment(masterRequest: MasterRequest): HttpResponse {
        return client.get(LOAN_REPAYMENT) {
            url {
                parameters.append("pUsername", masterRequest.pUsername)
                parameters.append("pPassword", masterRequest.pPassword)
            }
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun getGTRData(gtrRequest: GtrRequest): HttpResponse {
        return client.get(GTR) {
            url {
                parameters.append("pUsername", gtrRequest.pUsername)
                parameters.append("pPassword", gtrRequest.pPassword)
                parameters.append("sLoanOfficerID", gtrRequest.sLoanOfficerID)
                parameters.append("iVillageID", gtrRequest.iVillageID.toString())
            }
            contentType(ContentType.Application.Json)
        }
    }


}
