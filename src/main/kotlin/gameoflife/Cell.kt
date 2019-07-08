package gameoflife

data class Cell(val x: Int, val y: Int) {

    operator fun plus(other: Cell) = Cell(x + other.x, y + other.y)

}
