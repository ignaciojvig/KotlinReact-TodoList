package util

import org.w3c.dom.events.Event

val Event.value: String
    get() = this.currentTarget.asDynamic().value as String

fun Event.bar(): String {
    return this.value + "bar"
}

val sample = listOf(1, 2, 3)

val enUSLanguage = mapOf(
        "Hello Bootcamp" to "Hello Bootcamp 2"
)