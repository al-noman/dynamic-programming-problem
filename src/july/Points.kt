package july

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val (nearest, farthest) = findClosestAndFarthestPoints(
        arrayOf(
            Coordinate(1, 4),
            Coordinate(4, 4),
            Coordinate(3, 2),
            Coordinate(5, 1)
        )
    )

    println(nearest)
    println(farthest)
}

data class Coordinate(
    val x: Int,
    val y: Int
)

data class CoordinateDistance(val first: Coordinate, val second: Coordinate, val distance: Double)

fun findClosestAndFarthestPoints(coordinates: Array<Coordinate>, alreadyCalculated: MutableMap<Coordinate, Coordinate> = mutableMapOf()): Pair<CoordinateDistance, CoordinateDistance> {
    val list = mutableListOf<CoordinateDistance>()

    for (first in coordinates) {
        for (second in coordinates) {
            // alreadyCalculated[first] == second

            if (first != second) {
                list.add(calculateDistance(first, second))
            }
        }
    }
//    if (list.isEmpty()) return Pair(coordinates[0].)
    return Pair(list.minBy { it.distance }, list.maxBy { it.distance })
}

fun calculateDistance(first: Coordinate, second: Coordinate): CoordinateDistance {
    val distance = sqrt(
            (first.x.toDouble() - second.x.toDouble()).pow(2.toDouble()) + ((first.y.toDouble() - second.y.toDouble()).pow(2.toDouble()))
            )

    return CoordinateDistance(first, second, distance)
}
