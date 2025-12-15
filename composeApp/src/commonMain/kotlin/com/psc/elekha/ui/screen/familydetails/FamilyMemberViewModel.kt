import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.viewmodel.CustomerFamilyMemberDetailsViewModel
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.generateRandomId
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class FamilyMemberDetailViewModel(
    var appPreferences: AppPreferences,
    var familyMemberViewModel: CustomerFamilyMemberDetailsViewModel
) : BaseValidationViewModel() {

    var memberFirstName by mutableStateOf("")
    var memberMiddleName by mutableStateOf("")
    var memberLastName by mutableStateOf("")
    var relationId by mutableStateOf(0)
    var age by mutableStateOf(0)
    var gender by mutableStateOf(0)
    var isSchooling by mutableStateOf(0)
    var educationId by mutableStateOf(0)
    var isEarning by mutableStateOf(0)
    var occupationId by mutableStateOf(0)
    var monthlyIncomeId by mutableStateOf(0)
    var monthlyIncome by mutableStateOf(0)


    suspend fun saveFamilyMember() {

        val familyID =
            returnStringValue(appPreferences.getString(AppSP.familyGuid))

        if (returnStringValue(familyID).isEmpty()) {
            val newguid = generateRandomId()
            val entity = CustomerFamilyMemberDetailsEntity(
                GUID = newguid,
                MemberID = 0,
                MFirstName = memberFirstName,
                MMiddleName = memberMiddleName,
                MLastName = memberLastName,
                RelationID = relationId,
                Age = age,
                IsSchooling = isSchooling,
                EducationID = educationId,
                IsEarning = isEarning,
                OccupationID = occupationId,
                MonthlyIncomeID = monthlyIncomeId,
                Gender = gender.toString(),
                IsOld = 0,
                MonthlyIncome = monthlyIncome,
                IsUpload = 0
            )

            familyMemberViewModel.insertCustomerFamilyMember(entity)
            appPreferences.putString(AppSP.familyGuid,newguid)
            saveMessage = getString(Res.string.data_saved_successfully)
            showSaveAlert = true
        }
    }

    fun loadFamilyMembers() {
        viewModelScope.launch {
            val familyID =
                returnStringValue(appPreferences.getString(AppSP.familyGuid))



        }
    }
}
