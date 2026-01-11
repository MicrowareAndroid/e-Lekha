import com.psc.elekha.database.entity.LoanRepaymentEntity

class LoanRepaymentUpload(private val loanList: List<LoanRepaymentEntity>) {

    suspend fun getUploadInsertDataAsMap(): List<Map<String, Any?>> {
        val result = mutableListOf<Map<String, Any?>>()
        for (loan in loanList) {
            val map = mutableMapOf<String, Any?>()
            map["GUID"] = loan.GUID
            map["CenterID"] = loan.CenterID
            map["CustomerID"] = loan.CustomerID
            map["CustomerName"] = loan.CustomerName
            map["SpouseName"] = loan.SpouseName
            map["DisbursementAmount"] = loan.DisbursementAmount
            map["DisbursementDate"] = loan.DisbursementDate
            map["GroupName"] = loan.GroupName
            map["LW"] = loan.LW
            map["LoanOutstandingAsOnDate"] = loan.LoanOutstandingAsOnDate
            map["WeekInArrea"] = loan.WeekInArrea
            map["PastDue"] = loan.PastDue
            map["CurrentDue"] = loan.CurrentDue
            map["Due"] = loan.Due
            map["Adavance"] = loan.Adavance
            map["Total"] = loan.Total
            map["WorkingDate"] = loan.WorkingDate
            map["EMIDueDate"] = loan.EMIDueDate
            map["EMI"] = loan.EMI
            map["MaxPayment"] = loan.MaxPayment
            map["MandateApproved"] = loan.MandateApproved
            map["LoanCollectionFrequency"] = loan.LoanCollectionFrequency
            map["PaymentType"] = loan.PaymentType
            map["NACHStatus"] = loan.NACHStatus
            map["ContactNo"] = loan.ContactNo
            map["IsUploaded"] = loan.IsUploaded
            map["IsEdited"] = loan.IsEdited
            map["PaidDate"] = loan.PaidDate
            map["IsEmiReceived"] = loan.IsEmiReceived
            map["LoanPlace"] = loan.LoanPlace
            map["LoanLat"] = loan.LoanLat
            map["LoanLong"] = loan.LoanLong
            map["UTRNumber"] = loan.UTRNumber
            result.add(map)
        }
        return result
    }
}