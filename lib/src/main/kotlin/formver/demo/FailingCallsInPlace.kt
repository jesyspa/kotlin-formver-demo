@file:Suppress("unused")

package formver.demo

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


@OptIn(ExperimentalContracts::class)
fun testCallsInPlace(b: Boolean, f: () -> Unit) {
    contract { callsInPlace(f, InvocationKind.AT_LEAST_ONCE) }
    if (b) {
        f()
    }
}