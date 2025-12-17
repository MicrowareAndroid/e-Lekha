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
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class FamilyMemberDetailViewModel(
    private val appPreferences: AppPreferences,
    private val familyMemberViewModel: CustomerFamilyMemberDetailsViewModel
) : BaseValidationViewModel() {

    var memberFirstName by mutableStateOf("")
    var memberMiddleName by mutableStateOf("")
    var memberLastName by mutableStateOf("")
    var relationId by mutableStateOf("")
    var age by mutableStateOf("")
    var gender by mutableStateOf("")
    var educationId by mutableStateOf("")
    var occupationId by mutableStateOf("")
    var monthlyIncome by mutableStateOf("")



    fun saveDataWithoutValidation(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val memberGuid = generateRandomId()

            val entity = CustomerFamilyMemberDetailsEntity(
                GUID = memberGuid,  // Each member gets unique GUID
                MemberID = 0,
                MFirstName = memberFirstName,
                MMiddleName = memberMiddleName,
                MLastName = memberLastName,
                RelationID = relationId.toIntOrNull() ?: 0,
                Age = age.toIntOrNull() ?: 0,
                IsSchooling = 0,
                EducationID = educationId.toIntOrNull() ?: 0,
                IsEarning = 0,
                OccupationID = occupationId.toIntOrNull() ?: 0,
                MonthlyIncomeID = 0,
                Gender = gender,
                IsOld = 0,
                MonthlyIncome = occupationId.toIntOrNull() ?: 0,
                IsUpload = 0
            )

            familyMemberViewModel.insertCustomerFamilyMember(entity)
            saveMessage = getString(Res.string.data_saved_successfully)

            saveFlag = 1
            showSaveAlert = true

            onSuccess()
        }
    }
    }

