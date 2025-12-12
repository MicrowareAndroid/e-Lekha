import com.psc.elekha.database.dao.CustomerDao
import com.psc.elekha.database.entity.CustomerEntity


class CustomerRepository(private val customerDao: CustomerDao) {

    suspend fun insertCustomer(customer: CustomerEntity) {
        customerDao.insertCustomer(customer)
    }

    suspend fun insertAllCustomers(customers: List<CustomerEntity>) {
        customerDao.insertAllCustomer(customers)
    }

    suspend fun getAllCustomers(): List<CustomerEntity> {
        return customerDao.getAllCustomer()
    }

    suspend fun getCustomerByContact(contactNo: String): List<CustomerEntity> {
        return customerDao.getCustomerByContactNumber(contactNo)
    }

    suspend fun getCustomerDetails(guid: String): CustomerEntity {
        return customerDao.getCustomerDetails(guid)
    }

    suspend fun updateMyProfile(
        maritalStatusId: Int,
        firstName: String,
        middleName: String,
        lastName: String,
        customerImage: String,
        guarantorFName: String,
        guarantorMName: String,
        guarantorLName: String,
        guarantorImage: String,
        dob: String,
        age: Int,
        villageId: Int,
        pincode: String,
        guarantorAge: Int,
        guarantorDob: String,
        isEdited: Int,
        updatedBy: String,
        updatedOn: String,
        husbandFName: String,
        husbandMName: String,
        husbandLName: String,
        casteId: Int,
        educationId: Int,
        religionId: Int,
        guarantorId: Int,
        houseNo: String,
        mohalla: String,
        guid: String
    ) {
        customerDao.updateMyProfile(
            maritalStatusId,
            firstName,
            middleName,
            lastName,
            customerImage,
            guarantorFName,
            guarantorMName,
            guarantorLName,
            guarantorImage,
            dob,
            age,
            villageId,
            pincode,
            guarantorAge,
            guarantorDob,
            isEdited,
            updatedBy,
            updatedOn,
            husbandFName,
            husbandMName,
            husbandLName,
            casteId,
            educationId,
            religionId,
            guarantorId,
            houseNo,
            mohalla,
            guid
        )
    }


}
