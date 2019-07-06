package gameoflife

class World(livingCells: Set<Cell>) {

    var livingCells = livingCells
        get() = HashSet(field)

    fun tick() {
        livingCells = livingCells
            .filter {
                val numberOfLivingNeighbours = numberOfLivingNeighbours(it)
                (numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3)
            }
            .toSet()
    }

    private fun numberOfLivingNeighbours(cell: Cell) =
        cell.neighbours()
            .filter { livingCells.contains(it) }
            .size

}
