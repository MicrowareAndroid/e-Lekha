package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCDocumentEntity

@Dao
interface KYCDocumentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKYCDocument(kYCDocumentEntity: KYCDocumentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllKYCDocument(kYCDocumentEntity: List<KYCDocumentEntity>?)

    @Query("Select * from KYCDocument")
    suspend fun getAllKYCDocument(): List<KYCDocumentEntity>?

    @Query("Delete from KYCDocument")
    suspend fun deleteAllKYCDocument()

}