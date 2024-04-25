import java.util.*;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numChromosomes = getInput("Enter the number of chromosomes: ", scanner);
        int numVariables = 4; // Assuming 4 variables (x, y, z, w) for the given equation

        List<int[]> initialPopulation = generatePopulation(numChromosomes, numVariables);
        System.out.println("Initial Population:");
        printPopulation(initialPopulation);

        int[] bestChromosome = geneticAlgorithm(numChromosomes, numVariables);
        System.out.println("Best solution: " + Arrays.toString(bestChromosome));
    }

    static int[] geneticAlgorithm(int numChromosomes, int numVariables) {
        List<int[]> population = generatePopulation(numChromosomes, numVariables);
        int generation = 1;

        while (true) {
            int[] bestChromosome = findBestChromosome(population);
            int fitness = fitnessFunction(bestChromosome);

            if (fitness == 0) {
                System.out.println("Optimal Solution after " + generation + " Generations");
                return bestChromosome;
            }

            population = generatePopulation(numChromosomes, numVariables);
            generation++;
        }
    }

    static List<int[]> generatePopulation(int size, int numVariables) {
        List<int[]> population = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int[] individual = new int[numVariables];
            for (int j = 0; j < numVariables; j++) {
                individual[j] = random.nextInt(11); // Random value between 0 and 10
            }
            population.add(individual);
        }
        return population;
    }

    static void printPopulation(List<int[]> population) {
        for (int[] chromosome : population) {
            System.out.println(Arrays.toString(chromosome));
        }
    }

    static int fitnessFunction(int[] variables) {
        int x = variables[0];
        int y = variables[1];
        int z = variables[2];
        int w = variables[3];
        return Math.abs((x + 2 * y + 3 * z + 4 * w) - 30);
    }

    static int getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    static int[] findBestChromosome(List<int[]> population) {
        int[] bestChromosome = population.get(0);
        int minFitness = fitnessFunction(bestChromosome);

        for (int[] chromosome : population) {
            int fitness = fitnessFunction(chromosome);
            if (fitness < minFitness) {
                minFitness = fitness;
                bestChromosome = chromosome;
            }
        }

        return bestChromosome;
    }
}
