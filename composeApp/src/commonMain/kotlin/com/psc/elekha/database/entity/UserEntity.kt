package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey @ColumnInfo(name="Id") var id : Int,
    @ColumnInfo(name="UserId_PK") var userIdPk : String?,
    @ColumnInfo(name="Username") var username : String?,
    @ColumnInfo(name="Password") var password : String?,
    @ColumnInfo(name="UserLevel") var userLevel : String?,
    @ColumnInfo(name="Name") var name : String?,
    @ColumnInfo(name="PhoneNumber") var phoneNumber :Int?,
    @ColumnInfo(name="Email") var email :String?,
    @ColumnInfo(name="RoleId") var roleId :Int?,
    @ColumnInfo(name="Active") var active :Int?,
    @ColumnInfo(name = "CreatedBy") var createdBy : Int?,
    @ColumnInfo(name = "CreatedOn") var createdOn : String?,
    @ColumnInfo(name = "ModifiedOn") var modifiedOn : String?,
    @ColumnInfo(name = "ModifiedBy") var modifiedBy :  Int?,
    @ColumnInfo(name = "DeactivatedOn") var deactivatedOn : String?,
    @ColumnInfo(name = "DeactivatedBy") var deactivatedBy :  Int?,
)