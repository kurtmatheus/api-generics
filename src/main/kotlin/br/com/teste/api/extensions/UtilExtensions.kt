package br.com.teste.api.extensions

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun LocalDate.converterLocalDateParaFormatoBRComBarras(): String {
    return format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}

fun LocalTime.converterLocalTimeParaString(): String {
    return format(DateTimeFormatter.ofPattern("hh:mm"))
}