package com.afdal.pua_3.repository

data class UserProfile(
    var id: String = "",
    val faculty: String = "",
    val department: Long = 0L
) {
    fun toMap(): Map<String, Any> {
        val profile = HashMap<String, Any>()
        profile["id"] = id
        profile["faculty"] = faculty
        profile["department"] = department
        return profile
    }
}
