package com.psc.elekha.utils

import kotlinx.datetime.Instant

expect fun pickDate(context: Any?, onDatePicked: (String) -> Unit)
expect fun pickTime(context: Any?, onTimePicked: (String) -> Unit)

expect fun pickMinMaxDate(
    context: Any?,
    onDatePicked: (String) -> Unit,
    minDate: Instant? = null,
    maxDate: Instant? = null
)


expect fun getMinDateInstant(): Instant
expect fun getMaxDateInstant(): Instant
