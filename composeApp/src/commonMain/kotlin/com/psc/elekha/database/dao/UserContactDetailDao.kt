package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.ImageDetailEntity
import com.psc.elekha.database.entity.UserContactDetailEntity

@Dao
interface UserContactDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserContactDetail(user: UserContactDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUserContactDetail(users: List<UserContactDetailEntity>)


    @Query("Delete from UserContactDetails")
    suspend fun deleteAllUserContactDetail()

}