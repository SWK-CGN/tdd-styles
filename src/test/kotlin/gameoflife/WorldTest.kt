package gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class WorldTest {

    @Test
    fun `evolve world with no living cells`() {
        val world = World(emptySet())

        world.tick()

        assertThat(world.livingCells).isEmpty()
    }

    @Test
    fun `a living cell with one living neighbour will die`() {
        val world = World(
            setOf(
                Cell(1, 1),
                Cell(1, 2)
            )
        )

        world.tick()

        assertThat(world.livingCells).doesNotContain(Cell(1, 2))
    }

    @Test
    fun `a living cell with four living neighbours will die`() {
        val world = World(
            setOf(
                Cell(1, 1), Cell(2, 1),
                Cell(1, 2), Cell(2, 2),
                Cell(1, 3)
            )
        )

        world.tick()

        assertThat(world.livingCells).doesNotContain(Cell(1, 2))
    }

    @Test
    fun `one living cell will survive and one will die`() {
        val world = World(
            setOf(
                Cell(1, 1), Cell(2, 1),
                Cell(1, 2), Cell(2, 2),
                Cell(1, 3), Cell(2, 3)
            )
        )

        world.tick()

        assertThat(world.livingCells).contains(Cell(2, 1))
        assertThat(world.livingCells).doesNotContain(Cell(1, 2))
    }

}