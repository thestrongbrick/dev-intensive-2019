package ru.skillbanch.devintensive.utils

import android.app.backup.FullBackupDataOutput

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts:List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliterarion(payload: String, divider:String = " "): String {
        return "penis"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return "penis"
    }
}