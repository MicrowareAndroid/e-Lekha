package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCDocumentEntity

@Dao
interface KYCDocumentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKYCDocument(kYCDocumentEntity: KYCDocumentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllKYCDocument(kYCDocumentEntity: List<KYCDocumentEntity>?)

    @Query("Select * from KYCDocument")
    fun getAllKYCDocument(): List<KYCDocumentEntity>?

    @Query("Delete from KYCDocument")
    fun deleteAllKYCDocument()

}