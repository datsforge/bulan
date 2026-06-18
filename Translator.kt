import java.time.LocalDate

object Translator {

    fun convert(date: LocalDate): HijriDate {

        val jdn = gregorianToJdn(
            date.year,
            date.monthValue,
            date.dayOfMonth
        )

        return jdnToHijri(jdn)
    }

    private fun gregorianToJdn(year: Int, month: Int, day: Int): Long {

        val a = (14 - month) / 12
        val y = year + 4800 - a
        val m = month + 12 * a - 3

        return (
            day +
            (153 * m + 2) / 5 +
            365L * y +
            y / 4 -
            y / 100 +
            y / 400 -
            32045
        )
    }

    private fun jdnToHijri(jdn: Long): HijriDate {

    val days = jdn - 1948440 + 10632

    val n = (days - 1) / 10631
    var remainder = days - 10631 * n + 354

    val j = ((10985 - remainder) / 5316) *
            ((50 * remainder) / 17719) +
            (remainder / 5670) *
            ((43 * remainder) / 15238)

    remainder =
        remainder -
        ((30 - j) / 15) *
        ((17719 * j) / 50) -
        (j / 16) *
        ((15238 * j) / 43) +
        29

    val month = (24 * remainder) / 709
    val day = remainder - (709 * month) / 24
    val year = 30 * n + j - 30

    return HijriDate(
        year.toInt(),
        month.toInt(),
        day.toInt()
    )
}
}
