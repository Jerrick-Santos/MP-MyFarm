public class GameStats {
    public double balance;
    public double exp;

    public GameStats() {
        this.balance = 100;
        this.exp = 0;
    }
    public void addWallet(double amt){
        this.balance += amt;
    }

    public void deductWallet(double amt){
        this.balance -= amt;
    }

    public void gainExp(double amt){
        this.exp += amt;
    }

    public double getBalance() {
        return balance;
    }

    public double getExp() {
        return exp;
    }
}
