package com.ccastro.court.domain.use_cases.auth

/**
 * Relaciona todos los casos de uso referentes a la autenticación
 * tales como:
 *  Login
 *  GetCurrentUser
 *  Logout
 */
data class AuthUseCases (

    val singUp: SingUp,
    val login: Login,
    val logout: Logout,
    val getCurrentUser: GetCurrentUser,

    )