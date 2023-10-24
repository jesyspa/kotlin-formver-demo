@file:Suppress("unused")

package formver.demo

fun binarySearch1(arr: List<Int>, target: Int): Boolean {
    val size = arr.size
    val mid = arr.size / 2 + 1
    return when {
        arr.isEmpty() -> false
        arr[mid] == target -> true
        arr[mid] < target -> binarySearch1(arr.subList(mid + 1, size), target)
        else -> binarySearch1(arr.subList(0, mid), target)
    }
}

fun binarySearch2(arr: List<Int>, target: Int): Boolean {
    val size = arr.size
    val mid = arr.size / 2
    return when {
        arr.isEmpty() -> false
        arr[mid] == target -> true
        arr[mid] < target -> binarySearch2(arr.subList(mid + 1, size), target)
        else -> binarySearch2(arr.subList(0, mid - 1), target)
    }
}