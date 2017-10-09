import java.util.Random;
import java.util.Scanner;

/**
 * Created by Shayan on 2017-10-04.
 */
public class Main {

    Scanner reader = new Scanner(System.in);
    Spreading spread = new Spreading();

    public static void main(String[] args) {

        String input = "";
        Main main = new Main();

        while (!(input.equals("YES") || input.equals("NO"))) {
            System.out.println("Do you want to run a premade simulation? PLease enter 'YES' or 'NO' ");
            input = main.reader.nextLine();
            if (input.equals("YES"))
                main.premade();
            else if (input.equals("NO")) main.custom();
            else System.out.println("Invalid input. Try Again!");
        }
    }

    private void premade() {
        System.out.println("Choose one of the following premade simulations: 'ht17', 'ht16', 'ht15', 'ht14',");
        String premade = reader.nextLine();
        if (premade.equals("ht17")) {
            spread.execute(initPop(40, 0.1, 0.2, 6, 9, 1, 20, 20), 6, 9);
        } else if (premade.equals("ht16")) {
            spread.execute(initPop(50, 0.1, 0.2, 1, 12, 1, 25, 25), 1, 12);
        } else if (premade.equals("ht15")) {
            spread.execute(initPop(50, 0.1, 0.2, 3, 9, 1, 25, 25), 3, 9);
        } else if (premade.equals("ht14")) {
            spread.execute(initPop(50, 0.1, 0.2, 4, 8, 1, 25, 25), 4, 8);
        } else {
            System.out.println("Invalid input. Try Again!");
            premade();
        }
    }

    private void custom() {
        System.out.println("Enter N where the population wil be N*N: ");
        int N = reader.nextInt();
        System.out.println("Enter probability per day a sick individual infectts a healthy neighbor");
        double prob_ill = reader.nextDouble();
        System.out.println("Enter probability per day a sick individual may die: ");
        double prob_dead = reader.nextDouble();
        System.out.println("Interval on which a individual will stay sick. Minimum amount of days? ");
        int minDays = reader.nextInt();
        System.out.println("Maximum amount of days? ");
        int maxDays = reader.nextInt();

        individual[][] population = new individual[N][N];
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population.length; j++) {
                population[i][j] = new individual(false, false, prob_ill, prob_dead);
            }
        }

        System.out.println("How many are initially sick? ");
        int illPeople = reader.nextInt();
        int x;
        int y;

        for (int count = 0; count < illPeople; count++) {
            System.out.println("Enter X coordinate for individual nr " + (count + 1) + ": ");
            x = reader.nextInt();
            System.out.println("Enter Y coordinate for individual nr " + (count + 1) + ": ");
            y = reader.nextInt();
            for (int i = 0; i < population.length; i++) {
                for (int j = 0; j < population.length; j++) {
                    if ((i == x && j == y)) {
                        population[i][j].setIll(true);
                        Random r = new Random();
                        population[i][j].setSickDays(minDays + r.nextInt(maxDays - minDays + 1));
                    }
                }
            }
        }
        spread.execute(population, minDays, maxDays);
    }

    private individual[][] initPop(int pop, double prob_ill, double prob_dead, int minDays, int maxDays, int initIll, int x, int y) {
        individual[][] population = new individual[pop][pop];
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population.length; j++) {
                population[i][j] = new individual(false, false, prob_ill, prob_dead);
                if ((i == x && j == y)) {
                    population[i][j].setIll(true);
                    Random r = new Random();
                    population[i][j].setSickDays(minDays + r.nextInt(maxDays - minDays + 1));
                }
            }
        }

        return population;
    }
}
