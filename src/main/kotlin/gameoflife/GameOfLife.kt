package gameoflife

class GameOfLife(
    private val candidatesCalculator: CandidatesCalculator,
    private val livingNeighboursCountsCalculator: LivingNeighboursCountsCalculator,
    private val nextLivingCellCalculator: NextLivingCellCalculator
) {

    fun evolve(world: World): World {
        val livingCells = world.livingCells
        val candidates = candidatesCalculator.calculateCandidates(livingCells)
        val livingNeighboursCounts = livingNeighboursCountsCalculator.calculateLivingNeighboursCounts(livingCells, candidates)
        val nextLivingCells = nextLivingCellCalculator.calculateNextLivingCells(livingCells, livingNeighboursCounts)
        return World(nextLivingCells)
    }

}
