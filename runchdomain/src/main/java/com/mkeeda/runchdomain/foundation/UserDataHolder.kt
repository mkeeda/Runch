package com.mkeeda.runchdomain.foundation

class UserDataHolder {
    val connectionSetting: ConnectionSetting
    val userSession: UserSession

    constructor(connectionSetting: ConnectionSetting) {
        this.connectionSetting = connectionSetting
        this.userSession = UserSession()
    }
}
