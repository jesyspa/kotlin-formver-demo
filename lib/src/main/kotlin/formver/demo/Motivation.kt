package formver.demo

import org.jetbrains.kotlin.formver.plugin.NeverConvert
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class Declaration(val elements: List<Any>)

@NeverConvert
fun find(index: Int): Any? = TODO()

@OptIn(ExperimentalContracts::class)
fun process(index: Int, nullIfNotFound: Boolean): List<Int>? {
    contract {
        returnsNotNull() implies (!nullIfNotFound)
    }

    val declaration = find(index) ?: return if (nullIfNotFound) null else emptyList()

    return if (declaration !is Declaration) {
        emptyList()
    } else declaration.elements
        .filterIsInstance<Int>()
}