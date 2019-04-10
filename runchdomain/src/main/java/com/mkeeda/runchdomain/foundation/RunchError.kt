package com.mkeeda.runchdomain.foundation

object RunchError {
    data class Network(val type: RunchNetworkError): Throwable()
    data class Domain(val type: RunchDomainError): Throwable()
    data class View(val type: RunchViewErrorAbstract): Throwable()

    fun network(type: RunchNetworkError): Throwable {
        return Network(type = type)
    }

    fun domain(type: RunchDomainError): Throwable {
        return Domain(type = type)
    }

    fun view(type: RunchViewErrorAbstract): Throwable {
        return View(type = type)
    }
}

sealed class RunchNetworkError {
    data class HTTP(val code: Int): RunchNetworkError()
    data class API(val code: String, val message: String): RunchNetworkError()
    object SessionExpired: RunchNetworkError()
    object InvalidResponse: RunchNetworkError()
}


sealed class RunchDomainError {
    object InvalidSubDomainName: RunchDomainError()
    object pingClientCertificateRequired: RunchDomainError()
    object pingSubdomainNotFound: RunchDomainError()
    object pingServiceUnavailable: RunchDomainError()
    object pingUnknownError: RunchDomainError()
    object LoginInvalidUsernamePassword: RunchDomainError()
    data class LoginUnknownError(val throwable: Throwable): RunchDomainError()
    object invalidCertificate: RunchDomainError()
}

interface RunchViewErrorAbstract {}
