package gameoflife

// Collaborator
class GameOfLife(
    private val candidatesCalculator: CandidatesCalculator,
    private val livingNeighboursCountsCalculator: LivingNeighboursCountsCalculator,
    private val nextLivingCellsCalculator: NextLivingCellsCalculator
) {

    fun evolve(world: World): World {
        val livingCells = world.livingCells
        val candidates = candidatesCalculator.calculatesCandidates(livingCells)
        val livingNeighboursCounts = livingNeighboursCountsCalculator.calculateLivingNeighboursCounts(livingCells, candidates)
        val nextLivingCells = nextLivingCellsCalculator.calculateNextLivingCells(livingCells, livingNeighboursCounts)
        return World(nextLivingCells)
    }

}
