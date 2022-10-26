package Game;

public class GameStats {
    public double balance;
    public double exp;

    public GameStats() {
        this.balance = 100;
        this.exp = 0;
    }
    public void addWallet(double amt){
        this.balance += amt;
        System.out.println("Balance added : +" + amt);
        System.out.println("Your wallet has: " + this.balance);
    }

    public void deductWallet(double amt){
        this.balance -= amt;
        System.out.println("Balance deducted : -" + amt);
        System.out.println("Your wallet has: " + this.balance);
    }

    public void gainExp(double amt){
        this.exp += amt;
        System.out.println("Exp added : +" + amt);
        System.out.println("Exp: " + this.exp);
    }

    public double getBalance() {
        return balance;
    }

    public double getExp() {
        return exp;
    }
}
