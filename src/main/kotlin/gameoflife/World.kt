package gameoflife

class World(var livingCells: Set<Cell> = emptySet()) {

    private val neighboursOfOrigin = setOf(
        Cell(-1, -1), Cell(0, -1), Cell(1, -1),
        Cell(-1, 0), Cell(1, 0),
        Cell(-1, 1), Cell(0, 1), Cell(1, 1)
    )

    fun tick() {
        livingCells = livingCells
            .filter {
                val numberOfLivingNeighbours = numberOfLivingNeighbours(it)
                numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3
            }.toSet()
    }

    private fun numberOfLivingNeighbours(cell: Cell) = livingNeighboursOf(cell).size

    private fun livingNeighboursOf(cell: Cell) = neigbours(cell)
        .filter { livingCells.contains(it) }

    private fun neigbours(cell: Cell) = neighboursOfOrigin
        .map { cell + it }

}
