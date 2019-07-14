package gameoflife

typealias Cells = Set<Cell>

data class World(val livingCells: Cells)
