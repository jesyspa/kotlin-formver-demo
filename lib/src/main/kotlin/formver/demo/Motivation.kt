@file:Suppress("unused")

package formver.demo

import org.jetbrains.kotlin.formver.plugin.NeverConvert
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class Elements
class Declaration(val elements: Elements)

@NeverConvert
fun find(index: Int): Any? = TODO()
@NeverConvert
fun noElements() = Elements()

@OptIn(ExperimentalContracts::class)
fun process(index: Int, nullIfNotFound: Boolean): Elements? {
    contract {
        returnsNotNull() implies (!nullIfNotFound)
    }

    val declaration = find(index) ?: return if (nullIfNotFound) null else noElements()

    return if (declaration !is Declaration) noElements()
    else declaration.elements
}