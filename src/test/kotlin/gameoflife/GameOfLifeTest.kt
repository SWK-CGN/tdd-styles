package gameoflife

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class GameOfLifeTest {

    private val candidatesCalculator = mockk<CandidatesCalculator>()
    private val livingNeighboursCountCalculator = mockk<LivingNeighboursCountsCalculator>()
    private val nextLivingCellCalculator = mockk<NextLivingCellCalculator>()
    private val game = GameOfLife(candidatesCalculator, livingNeighboursCountCalculator, nextLivingCellCalculator)

    @Test
    fun `evolve a world`() {
        val livingCells = someSetOfCellsCells()

        val candidates = someSetOfCellsCells()
        every { candidatesCalculator.calculateCandidates(livingCells) } returns candidates

        val livingNeighboursCounts = mapOf(Cell(1, 1) to 1)
        every { livingNeighboursCountCalculator.calculateLivingNeighboursCounts(livingCells, candidates) } returns livingNeighboursCounts

        val nextLivingCells = someSetOfCellsCells()
        every { nextLivingCellCalculator.calculateNextLivingCells(livingCells, livingNeighboursCounts) } returns nextLivingCells

        val nextWorld = game.evolve(World(livingCells))

        assertThat(nextWorld.livingCells).isEqualTo(nextLivingCells)
        verify { nextLivingCellCalculator.calculateNextLivingCells(livingCells, livingNeighboursCounts) }
    }

    private fun someSetOfCellsCells() = setOf(Cell(1, 1))

}