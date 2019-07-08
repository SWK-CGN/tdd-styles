package gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class WorldTest {

    @Test
    fun `evolve an empty world`() {
        val world = World()

        world.tick()

        assertThat(world.livingCells).isEmpty()
    }

    @Test
    fun `evolve a world with one living cell`() {
        val world = World(setOf(Cell(1, 1)))

        world.tick()

        assertThat(world.livingCells).isEmpty()
    }

    @Test
    fun `a living cell with two living neighbours survives`() {
        val world = World(
            setOf(
                Cell(1, 1), Cell(2, 1),
                Cell(1, 2)
            )
        )

        world.tick()

        assertThat(world.livingCells).contains(Cell(1, 2));
    }

    @Test
    fun `a living cell with four living neighbours dies`() {
        val world = World(
            setOf(
                Cell(1, 1), Cell(2, 1),
                Cell(1, 2), Cell(2, 2),
                Cell(1, 3)
            )
        )

        world.tick()

        assertThat(world.livingCells).doesNotContain(Cell(1, 2));
    }

    @Test
    fun `one cell survives and one dies`() {
        val world = World(
            setOf(
                Cell(1, 1), Cell(2, 1),
                Cell(1, 2), Cell(2, 2),
                Cell(1, 3)
            )
        )

        world.tick()

        assertThat(world.livingCells).contains(Cell(2, 1));
        assertThat(world.livingCells).doesNotContain(Cell(1, 2));
    }


}