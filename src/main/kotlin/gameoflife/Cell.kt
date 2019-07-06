package gameoflife

data class Cell(val x: Int, val y: Int) {
    fun isOrigin() = (x == 0 && y == 0)

    fun neighbours() = (-1..1).flatMap { dx -> (-1..1).map { dy -> Cell(dx, dy) } }
        .filter { !it.isOrigin() }
        .map { Cell(x + it.x, y + it.y) }
        .toSet()

}


