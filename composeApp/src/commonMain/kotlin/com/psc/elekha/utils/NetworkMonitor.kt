// commonMain
package com.psc.elekha.utils

import kotlinx.coroutines.flow.StateFlow

expect class NetworkMonitor() {
    val isConnected: StateFlow<Boolean>
}
