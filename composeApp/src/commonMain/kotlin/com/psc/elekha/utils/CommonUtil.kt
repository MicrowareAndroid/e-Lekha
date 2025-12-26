package com.psc.elekha.utils

import kotlin.random.Random
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject

fun generateRandomId(): String {
    val chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    val sb = StringBuilder()
    repeat(30) {
        sb.append(chars[Random.nextInt(chars.length)])
    }

    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val timestamp = "${now.year}${now.monthNumber.toString().padStart(2, '0')}" +
            "${now.dayOfMonth.toString().padStart(2, '0')}" +
            "${now.hour.toString().padStart(2, '0')}" +
            "${now.minute.toString().padStart(2, '0')}" +
            "${now.second.toString().padStart(2, '0')}" +
            "${now.nanosecond / 1_000_000}" // ms part

    return sb.toString() + timestamp
}

fun currentDate(): String {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    return now.year.toString().padStart(4, '0') + "-" +
            now.monthNumber.toString().padStart(2, '0') + "-" +
            now.dayOfMonth.toString().padStart(2, '0')
}

fun currentDatetime(): String {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val millis = (now.nanosecond / 1_000_000).toString().padStart(3, '0')
    return now.year.toString().padStart(4, '0') +
            now.monthNumber.toString().padStart(2, '0') +
            now.dayOfMonth.toString().padStart(2, '0') +
            now.hour.toString().padStart(2, '0') +
            now.minute.toString().padStart(2, '0') +
            now.second.toString().padStart(2, '0') +
            millis
}
fun currentTime(): String {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    // hh:mm a
    val hour = if (now.hour % 12 == 0) 12 else now.hour % 12
    val amPm = if (now.hour < 12) "AM" else "PM"
    return hour.toString().padStart(2, '0') + ":" +
            now.minute.toString().padStart(2, '0') + " " +
            amPm
}

fun returnIntegerValue(myString: String?): Int {
    return myString
        ?.takeIf { it.isNotBlank() && !it.equals("null", ignoreCase = true) }
        ?.toIntOrNull()
        ?: 0
}

fun returnStringValue(myString: String?): String {
    return myString
        ?.takeIf { it.isNotBlank() && !it.equals("null", ignoreCase = true) }
        ?: ""
}

fun returnIntToString(value: Int?): String {
    return if (value != null && value != 0) value.toString() else ""
}

fun returnJson(
    abc: Array<ArrayList<*>>,
    tableNames: Array<String>
): String {
    val jsonObjectCombined = buildJsonObject {
        for (i in tableNames.indices) {
            try {
                val jsonArray = buildJsonArray {
                    abc.getOrNull(i)?.forEach { element ->
                        add(JsonPrimitive(element.toString()))
                    }
                }
                put(tableNames[i], jsonArray)
            } catch (e: Exception) {
                e.printStackTrace()
                put(tableNames[i], JsonArray(emptyList()))
            }
        }
    }

    return Json.encodeToString(jsonObjectCombined)
}

/*fun returnID(pos: Int, data: List<LookUpValueEntity>?): Int? {
    return if (!data.isNullOrEmpty() && pos > 0) {
        data[pos - 1].lookupTypeFK
    } else 0
}

fun returnPos(id: Int, data: List<LookUpValueEntity>?): Int {
    if (!data.isNullOrEmpty() && id > 0) {
        data.forEachIndexed { index, entity ->
            if (entity.lookupTypeFK == id) return index + 1
        }
    }
    return 0
}*/

