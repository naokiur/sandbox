package jp.ne.naokiur.sample.fuel

fun main() {
    val accessor = HttpAccessor()

    // Text
    val resultText = accessor.getText("http://localhost:8080/text")

    println(resultText)

    // JSON
    val resultJson = accessor.getJson("http://localhost:8080/json")

    println(resultJson.get("message"))
    println(resultJson.get("a"))
    println(resultJson.get("b"))

}