package gameoflife

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class GameOfLifeTest {

    val candidatesCalculator = mockk<CandidatesCalculator>()
    val livingNeighboursCountsCalculator = mockk<LivingNeighboursCountsCalculator>()
    val nextLivingCellsCalculator = mockk<NextLivingCellsCalculator>()
    val game = GameOfLife(candidatesCalculator, livingNeighboursCountsCalculator, nextLivingCellsCalculator)

    @Test
    fun `evolve world`() {

        // given

        val livingCells = someSetOfCells()
        val livingNeighboursCounts = mapOf(Cell(1, 1) to 1)
        val nextLivingCells = someSetOfCells()
        val candidate = someSetOfCells()

        every { candidatesCalculator.calculatesCandidates(livingCells) } returns candidate
        every { livingNeighboursCountsCalculator.calculateLivingNeighboursCounts(livingCells, candidate) } returns livingNeighboursCounts
        every { nextLivingCellsCalculator.calculateNextLivingCells(livingCells, livingNeighboursCounts) } returns nextLivingCells

        // when

        val world = World(livingCells)
        val nextWorld = game.evolve(world)

        // then

        assertThat(nextWorld.livingCells).isEqualTo(nextLivingCells)
    }

    private fun someSetOfCells(): Set<Cell> = setOf(Cell(1, 1))

}