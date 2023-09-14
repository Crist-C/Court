package com.ccastro.court.domain.models

data class User (
    var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var country: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = ""
)