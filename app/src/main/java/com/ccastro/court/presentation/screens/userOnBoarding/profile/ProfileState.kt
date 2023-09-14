package com.ccastro.court.presentation.screens.userOnBoarding.profile

import com.ccastro.court.domain.models.User

data class ProfileState(

    var userData: User = User(),
    var currentUser: String? = null

)
