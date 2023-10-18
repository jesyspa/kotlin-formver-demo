@file:Suppress("unused")

package formver.demo

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract


class IntHolder(val x: Int)
@OptIn(ExperimentalContracts::class)
fun getX(a: Any) : Int? {
    contract {
        returnsNotNull() implies (a is IntHolder)
    }
    return (a as? IntHolder)?.x
}



