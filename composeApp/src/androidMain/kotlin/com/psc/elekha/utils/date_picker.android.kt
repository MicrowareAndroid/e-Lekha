package com.psc.elekha.utils

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import java.lang.String.format
import java.util.Calendar
import java.util.Locale

actual fun pickTime(context: Any?, onTimePicked: (String) -> Unit) {
    // Ensure context is of type Context
    if (context !is Context) return

    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    // Android-specific TimePickerDialog
    TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            val time = format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute)
            onTimePicked(time)
        },
        hour,
        minute,
        true // is24HourView
    ).show()
}

actual fun pickDate(context: Any?, onDatePicked: (String) -> Unit) {
    // Ensure context is of type Context
    if (context !is Context) return

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // Android-specific DatePickerDialog
    DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDatePicked(date)
        },
        year,
        month,
        day
    ).show()

}

actual fun pickMinMaxDate(
    context: Any?,
    onDatePicked: (String) -> Unit,
    minDate: Instant?,
    maxDate: Instant?
) {
    if (context !is Context) return

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate =
                String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear)
            onDatePicked(formattedDate)
        },
        year,
        month,
        day
    )

    // Set min date if provided
    minDate?.let {
        datePickerDialog.datePicker.minDate = it.toEpochMilliseconds()
    }

    // Set max date if provided
    maxDate?.let {
        datePickerDialog.datePicker.maxDate = it.toEpochMilliseconds()
    }

    datePickerDialog.show()
}


// example: today
actual fun getMinDateInstant(): Instant {
    val cal = Calendar.getInstance()
    cal.set(1900, Calendar.JANUARY, 1)
    cal.set(Calendar.HOUR_OF_DAY, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MILLISECOND, 0)
    return Instant.fromEpochMilliseconds(cal.timeInMillis)
}


actual fun getMaxDateInstant(): Instant {
    return Instant.fromEpochMilliseconds(System.currentTimeMillis())
}