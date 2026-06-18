import java.time.LocalDate

object Commands{
	fun today() {

    val today = java.time.LocalDate.now()

    println("Today")
    println()

    println("Gregorian:")
    println(today)
    println()

    println("Hijri:")
    val hijri = Translator.convert(today)
    println(hijri)
}
}
