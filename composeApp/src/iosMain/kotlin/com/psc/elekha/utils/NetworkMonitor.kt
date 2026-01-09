package com.psc.elekha.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import platform.Network.*
import platform.darwin.dispatch_queue_create

actual class NetworkMonitor actual constructor() {

    private val _isConnected = MutableStateFlow(false)
    actual val isConnected: StateFlow<Boolean> = _isConnected

    private val monitor = nw_path_monitor_create()
    private val queue = dispatch_queue_create("NetworkMonitor", null)

    init {
        nw_path_monitor_set_update_handler(monitor) { path ->
            _isConnected.value =
                nw_path_get_status(path) == nw_path_status_satisfied
        }
        nw_path_monitor_set_queue(monitor, queue)
        nw_path_monitor_start(monitor)
    }
}
