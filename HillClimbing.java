import java.util.Random;

public class Main {
    static double objFunction(double x) {
        return -5 * x * x + 3 * x + 6;
    }

    static double randomNeighbor(double current) {
        Random random = new Random();
        return current + random.nextDouble() * 1.0 - 0.5;
    }

    static double hillClimbing(int maxIterations) {
        Random random = new Random();
        double currentSolution = random.nextDouble() * 20 - 10;

        for (int i = 0; i < maxIterations; i++) {
            double neighbor = randomNeighbor(currentSolution);
            if (objFunction(neighbor) > objFunction(currentSolution)) {
                currentSolution = neighbor;
            }
        }

        return currentSolution;
    }

    public static void main(String[] args) {
        int maxIterations = 1000;
        double bestSolution = hillClimbing(maxIterations);
        System.out.println("Best solution found: " + bestSolution);
        System.out.println("Objective value at best solution: " + objFunction(bestSolution));
    }
}
