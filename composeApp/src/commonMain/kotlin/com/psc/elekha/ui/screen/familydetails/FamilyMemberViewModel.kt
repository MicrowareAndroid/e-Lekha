import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.viewmodel.CustomerFamilyMemberDetailsViewModel
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.generateRandomId
import com.psc.elekha.utils.parseNameDynamic
import com.psc.elekha.utils.returnIntToString
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import e_lekha.composeapp.generated.resources.data_updated_successfully
import e_lekha.composeapp.generated.resources.personal_customer_name
import e_lekha.composeapp.generated.resources.personal_district
import e_lekha.composeapp.generated.resources.personal_education
import e_lekha.composeapp.generated.resources.personal_marital
import e_lekha.composeapp.generated.resources.personal_purpose
import e_lekha.composeapp.generated.resources.personal_relation
import e_lekha.composeapp.generated.resources.personal_religion
import e_lekha.composeapp.generated.resources.personal_state
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class FamilyMemberDetailViewModel(
    private val appPreferences: AppPreferences,
    private val familyMemberViewModel: CustomerFamilyMemberDetailsViewModel
) : BaseValidationViewModel() {

    var memberName by mutableStateOf("")

    var relationId by mutableStateOf(0)
    var age by mutableStateOf("")
    var gender by mutableStateOf(0)
    var educationId by mutableStateOf(0)
    var occupationId by mutableStateOf(0)
    var monthlyIncome by mutableStateOf("")
    var remarks by mutableStateOf("")

    val bringIntoViewRequesterMemberName = BringIntoViewRequester()
    val bringIntoViewRequesterRelationId = BringIntoViewRequester()
    val bringIntoViewRequesterGender = BringIntoViewRequester()
    val bringIntoViewRequesterAge = BringIntoViewRequester()
    val bringIntoViewRequesterEducationId = BringIntoViewRequester()
    val bringIntoViewRequesterOccupationId = BringIntoViewRequester()
    val bringIntoViewRequesterMonthlyIncome = BringIntoViewRequester()
    val bringIntoViewRequesterRemarks = BringIntoViewRequester()

    val focusRequesterMemberName = FocusRequester()
    val focusRequesterRelationId = FocusRequester()

    val focusRequesterGender = FocusRequester()

    val focusRequesterAge = FocusRequester()
    val focusRequesterEducationId = FocusRequester()
    val focusRequesterOccupationId = FocusRequester()
    val focusRequesterMonthlyIncome = FocusRequester()
    val focusRequesterRemarks = FocusRequester()


    suspend fun saveFamilyMember() {
        val memberGuid = appPreferences.getString(AppSP.familyGuid)
        val memberFamilyName = parseNameDynamic(returnStringValue(memberName))

        if (memberGuid.isNullOrEmpty()) {
            val newGuid = generateRandomId()

            val entity = CustomerFamilyMemberDetailsEntity(
                newGuid,
                0,
                memberFamilyName.firstName,
                memberFamilyName.middleName,
                memberFamilyName.lastName,
                relationId,
                returnIntegerValue(age),
                0,
                educationId,
                0,
                occupationId,
                0,
                gender.toString(),
                0,
                returnIntegerValue(monthlyIncome),
                0,
                remarks
            )

            familyMemberViewModel.insertCustomerFamilyMember(entity)
            appPreferences.putString(AppSP.customerGuid, newGuid)

            saveMessage = getString(Res.string.data_saved_successfully)
            saveFlag = 1
            showSaveAlert = true
        } else {

            familyMemberViewModel.updateCustomerFamilyMemberByGuid(
                memberGuid,
                memberFamilyName.firstName,
                memberFamilyName.middleName,
                memberFamilyName.lastName,
                relationId,
                returnIntegerValue(age),
                gender.toString(),
                educationId,
                occupationId
            )

            saveMessage = getString(Res.string.data_updated_successfully)
            showSaveAlert = true
        }
    }

    fun loadData() {
        viewModelScope.launch {


            val savedGuid = returnStringValue(appPreferences.getString(AppSP.familyGuid))
            if (savedGuid.isNotEmpty()) {

                val listData = familyMemberViewModel.getCustomerDetailGuid(savedGuid)
                if (listData.isNotEmpty()) {

                    val data = listData[0]
                    memberName=returnStringValue(data.MFirstName)
                    gender=returnIntegerValue(data.Gender)
                    age= returnIntToString(data.Age)
                    relationId=returnIntegerValue(data.RelationID?.toString())
                    educationId=returnIntegerValue(data.EducationID?.toString())
                    occupationId=returnIntegerValue(data.OccupationID?.toString())
                    remarks=returnStringValue(data.Remarks)

                }
            }
        }

    }

    fun saveData() {
        viewModelScope.launch {
            saveFamilyMember()
           /* val validation = checkValidation()
            if (validation.isValid) {

                showSaveAlert = true
                saveFlag = 1
            } else {
                showValidationError(validation)
            }*/
        }
    }

    private suspend fun checkValidation(): ValidationModelContorl {
        val pleasemaritalstatus = getString(Res.string.personal_marital)
        val pleaseEducation = getString(Res.string.personal_education)
        val pleaseReligion = getString(Res.string.personal_religion)
        val pleasePurpose = getString(Res.string.personal_purpose)
        val pleaseRelation = getString(Res.string.personal_relation)
        val pleaseState = getString(Res.string.personal_state)
        val pleaseDistrict = getString(Res.string.personal_district)

        return when {

            returnStringValue(memberName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_customer_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterMemberName,
                    bringIntoViewRequester = bringIntoViewRequesterMemberName
                )
            }


            returnIntegerValue(gender.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleasemaritalstatus,
                    focusRequester = focusRequesterGender,
                    bringIntoViewRequester = bringIntoViewRequesterGender
                )
            }

            returnStringValue(age).isBlank() -> {
                val nameLabel = getString(Res.string.personal_customer_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterAge,
                    bringIntoViewRequester = bringIntoViewRequesterAge
                )
            }

            returnIntegerValue(educationId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseEducation,
                    focusRequester = focusRequesterEducationId,
                    bringIntoViewRequester = bringIntoViewRequesterEducationId
                )
            }

            else -> ValidationModelContorl(isValid = true)
        }
    }

}

