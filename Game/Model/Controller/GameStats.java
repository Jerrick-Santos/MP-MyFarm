package Game.Model.Controller;

/**
 * The GameStats class contains the variables responsible for holding the wallet balance and
 * experience points of the player. A player may call methods from this class for increment or
 * decrement of their balances as well as call a method for gaining experience points.
 */
public class GameStats {
    public double balance;
    public double exp;

    /**
     * This constructor class holds the player's game stats'. The player's game stats' include
     * the player's wallet balance and experience.
     */
    public GameStats() {
        this.balance = 100;
        this.exp = 0;
    }

    /**
     * When addWallet() is called, called-in value for parameter will be added
     * to the 'player's' wallet.
     * @param amt - amount to be added to wallet
     */
    public void addWallet(double amt){
        this.balance += amt;
        System.out.println("Balance added : +" + amt);
        System.out.println("Your wallet has: " + this.balance);
    }

    /**
     * When deductWallet() is called, called-in value for parameter will be deducted
     * to the 'player's' wallet.
     * @param amt - amount to be deducted to wallet
     */
    public void deductWallet(double amt){
        this.balance -= amt;
        System.out.println("Balance deducted : -" + amt);
        System.out.println("Your wallet has: " + this.balance);
    }

    /**
     * When gainExp() is called, called-in value for parameter will be added
     * to the 'player's' experience.
     * @param amt - amount of exp to be added to player's experience
     */
    public void gainExp(double amt){
        this.exp += amt;
        System.out.println("Exp added : +" + amt);
        System.out.println("Exp: " + this.exp);
    }

    /**
     * Getter class for unique variable, balance.
     * @return wallet balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter class for unique variable, exp.
     * @return player's experience.
     */
    public double getExp() {
        return exp;
    }
}