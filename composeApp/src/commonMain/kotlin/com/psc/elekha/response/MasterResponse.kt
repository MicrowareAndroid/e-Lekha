package com.psc.elekha.response


import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.KYCDocCategoryEntity
import com.psc.elekha.database.entity.KYCDocConfigurationEntity
import com.psc.elekha.database.entity.KYCDocumentEntity
import com.psc.elekha.database.entity.KYCStatusConditionEntity
import com.psc.elekha.database.entity.KYCStatusEntity
import com.psc.elekha.database.entity.MSTAssetsValuationEntity
import com.psc.elekha.database.entity.MSTBankEntity
import com.psc.elekha.database.entity.MSTBranchEntity
import com.psc.elekha.database.entity.MSTCenterEntity
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.entity.MSTDistrictEntity
import com.psc.elekha.database.entity.MSTLoanOfficerEntity
import com.psc.elekha.database.entity.MSTLoanProductEntity
import com.psc.elekha.database.entity.MSTLoanTypeEntity
import com.psc.elekha.database.entity.MSTMonthlyIncomeMarksEntity
import com.psc.elekha.database.entity.MSTPovertyStatusEntity
import com.psc.elekha.database.entity.MSTStateEntity
import com.psc.elekha.database.entity.MSTVillageEntity
import com.psc.elekha.database.entity.TabletMenuEntity
import com.psc.elekha.database.entity.TabletMenuRoleEntity
import com.psc.elekha.database.entity.TrainingGroupStatusEntity
import com.psc.elekha.database.entity.UserBranchEntity
import com.psc.elekha.database.entity.UserContactDetailEntity
import com.psc.elekha.database.entity.UsersEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement



@Serializable
data class MasterResponse(


    @SerialName("User")
    val user: List<UsersEntity> = emptyList(),

    @SerialName("TabletMenu")
    val tabletMenu: List<TabletMenuEntity> = emptyList(),

    @SerialName("TabletMenuRole")
    val tabletMenuRole: List<TabletMenuRoleEntity> = emptyList(),

    @SerialName("State")
    val state: List<MSTStateEntity> = emptyList(),

    @SerialName("District")
    val district: List<MSTDistrictEntity> = emptyList(),

    @SerialName("Branch")
    val branch: List<MSTBranchEntity> = emptyList(),

    @SerialName("Village")
    val village: List<MSTVillageEntity> = emptyList(),

    @SerialName("MstComboBox_N")
    val mstComboBoxN: List<MSTComboBox_NEntity> = emptyList(),

    @SerialName("AssetValuation")
    val assetValuation: List<MSTAssetsValuationEntity> = emptyList(),

    /* @SerialName("CustomerLoanProduct")
      val customerLoanProduct: List<TblCaseCategoryVictimTypeEntity> = emptyList(),*/

    @SerialName("Bank")
    val bank: List<MSTBankEntity> = emptyList(),

    @SerialName("Center")
    val center: List<MSTCenterEntity> = emptyList(),

    @SerialName("PovertyStatus")
    val povertyStatus: List<MSTPovertyStatusEntity> = emptyList(),

    @SerialName("CustomerStatus")
    val customerStatus: List<CustomerStatusEntity> = emptyList(),

    @SerialName("LoanType")
    val loanType: List<MSTLoanTypeEntity> = emptyList(),

    @SerialName("TrainingGroupStatus")
    val trainingGroupStatus: List<TrainingGroupStatusEntity> = emptyList(),

    @SerialName("MonthlyIncomeMarks")
    val monthlyIncomeMarks: List<MSTMonthlyIncomeMarksEntity> = emptyList(),

    @SerialName("UserBranch")
    val userBranch: List<UserBranchEntity> = emptyList(),

    @SerialName("LoanOfficer")
    val loanOfficer: List<MSTLoanOfficerEntity> = emptyList(),

    @SerialName("KYCDocCategory")
    val kycDocCategory: List<KYCDocCategoryEntity> = emptyList(),

    @SerialName("KYCDocConfiguration")
    val kycDocConfiguration: List<KYCDocConfigurationEntity> = emptyList(),

    @SerialName("KYCDocument")
    val kycDocument: List<KYCDocumentEntity> = emptyList(),

    @SerialName("KYCStatus")
    val kycStatus: List<KYCStatusEntity> = emptyList(),

    @SerialName("KYCStatusCondition")
    val kycStatusCondition: List<KYCStatusConditionEntity> = emptyList(),

    @SerialName("CustomerLoanProduct")
    val mstLoanProduct: List<MSTLoanProductEntity> = emptyList(),

    @SerialName("UserContactDetails")
    val userContactDetails: List<UserContactDetailEntity> = emptyList()



    /*@SerialName("NoName1")
    val noName1: List<NoNaame1> = emptyList(),

   @SerialName("NoName2")
    val noName2: List<MstLanguageEntity> = emptyList(),

   @SerialName("NoName3")
    val noName3: List<Any> = emptyList()*/
)




