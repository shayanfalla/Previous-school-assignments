import java.util.Random;
import java.util.Scanner;

/**
 * Created by Shayan on 2017-10-04.
 */
public class Spreading {

    Scanner reader = new Scanner(System.in);

    public void execute(individual[][] population, int minDays, int maxDays) {
        System.out.println("Do you want the data output? if YES, enter 'YES', elsewise simply enter");
        if (reader.nextLine().equals("YES")) {
            prestart(population);
            execute(population, minDays, maxDays, 0, 0, true);
        } else {
            prestart(population);
            execute(population, minDays, maxDays, 0, 0, false);
        }
    }

    public void execute(individual[][] population, int minDays, int maxDays, int accumIll, int accumDeath, boolean skip) {
        int infectCount = 0;
        int deathCount = 0;
        int recovCount = 0;
        int illCount = 0;
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population.length; j++) {
                if (neighInfected(i, j, population) && randomInfect(population[i][j]) && !population[i][j].isIll() && !population[i][j].isDead()) {
                    population[i][j].setNewIll(true);
                    Random r = new Random();
                    population[i][j].setSickDays(minDays + r.nextInt(maxDays - minDays + 1));
                    infectCount++;
                } else if (population[i][j].getSickDays() > 0 && !population[i][j].isDead()) {
                    if (Dead(population[i][j])) {
                        deathCount++;
                        population[i][j].setIll(false);
                    }
                    population[i][j].setSickDays(population[i][j].getSickDays() - 1);
                    if (population[i][j].getSickDays() == 0) {
                        population[i][j].setIll(false);
                        recovCount++;
                    }
                }
            }
        }


        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population.length; j++) {
                if (population[i][j].isNewIll()) {
                    population[i][j].setIll(true);
                    population[i][j].setNewIll(false);
                }
                if (population[i][j].isIll()) {
                    illCount++;
                }
                if (!population[i][j].beenInf() && population[i][j].isIll()) {
                    population[i][j].setBeenInf(true);
                    accumIll++;
                }
                System.out.print(population[i][j].toString());
            }
            System.out.println("");
        }
        System.out.println("\n");
        if (!skip) {
            System.out.println("Nr of infected today: " + infectCount);
            System.out.println("Nr of deaths today: " + deathCount);
            System.out.println("Nr of recovered today: " + recovCount);
            System.out.println("Nr of ill individuals today: " + illCount);
            System.out.println("Nr of total infected as of today: " + accumIll);
            System.out.println("Nr of total deaths as of today: " + accumDeath + "\n");
        }

        System.out.println("If you want to exit, enter 'EXIT', elsewise, simply enter anything");
        if ((!reader.nextLine().equals("EXIT")) || illCount != 0)
            execute(population, minDays, maxDays, accumIll, accumDeath + deathCount, skip);
    }

    private void prestart(individual[][] population) {
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population.length; j++) {
                System.out.print(population[i][j].toString());
            }
            System.out.println("");
        }
        System.out.println("Start of simulation. \npress anything to start");
        reader.nextLine();
    }

    private boolean randomInfect(individual x) {
        Random r = new Random();
        Double randomValue = r.nextDouble();
        if (x.getProb_ill() >= randomValue)
            return true;
        else return false;
    }

    private boolean Dead(individual x) {
        Random r = new Random();
        Double randomValue = r.nextDouble();
        if (x.getProb_dead() >= randomValue) {
            x.setDead(true);
            return true;
        }
        return false;
    }

    private boolean neighInfected(int i, int j, individual[][] population) {

        if (i >= 1 && j >= 1) {
            if (population[i - 1][j - 1].isIll()) return true;
        }
        if (i >= 1) {
            if (population[i - 1][j].isIll()) return true;
        }
        if (i >= 1 && j < population.length - 1) {
            if (population[i - 1][j + 1].isIll()) return true;
        }
        if (j >= 1) {
            if (population[i][j - 1].isIll()) return true;
        }
        if (j < population.length - 1) {
            if (population[i][j + 1].isIll()) return true;
        }
        if (i < population.length - 1 && j >= 1) {
            if (population[i + 1][j - 1].isIll()) return true;
        }
        if (i < population.length - 1) {
            if (population[i + 1][j].isIll()) return true;
        }
        if (i < population.length - 1 && j < population.length - 1) {
            if (population[i + 1][j + 1].isIll()) return true;
        }
        return false;
    }
}
