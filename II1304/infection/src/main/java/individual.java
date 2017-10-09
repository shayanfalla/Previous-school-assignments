/**
 * Created by Shayan on 2017-10-04.
 */
public class individual {

    boolean ill = false;
    boolean newIll = false;
    boolean isDead = false;
    boolean beenInf = false;
    double prob_ill = 0;
    double prob_dead = 0;
    int sickDays = 0;

    individual(boolean ill, boolean newIll, double prob_ill, double prob_dead) {
        this.ill = ill;
        this.newIll = newIll;
        this.prob_ill = prob_ill;
        this.prob_dead = prob_dead;
    }

    @Override
    public String toString() {
        if (this.isDead) return "-";
        else if (this.ill) return "!";
        else return "¤";
    }

    public boolean isNewIll() {
        return this.newIll;
    }

    public double getProb_ill() {
        return this.prob_ill;
    }

    public double getProb_dead() {
        return this.prob_dead;
    }

    public boolean isIll() {
        return this.ill;
    }

    public boolean beenInf() {
        return this.beenInf;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public int getSickDays() {
        return this.sickDays;
    }

    public void setNewIll(boolean newIll) {
        this.newIll = newIll;
    }

    public void setIll(boolean ill) {
        this.ill = ill;
    }

    public void setDead(boolean Dead) {
        this.isDead = Dead;
    }

    public void setProb_ill(double prob_ill) {
        this.prob_ill = prob_ill;
    }

    public void setProb_dead(double prob_dead) {
        this.prob_dead = prob_dead;
    }

    public void setBeenInf(boolean beenInf) {
        this.beenInf = beenInf;
    }

    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }

}
