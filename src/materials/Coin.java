package materials;

import java.util.Random;

public class Coin {

  private CoinState coinState;

  private static Coin instance = null;

  private Coin(){}

  public static Coin getInstance() {
    if(instance==null){
      instance = new Coin();
    }
    return instance;
  }


  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    // TODO : Votre code ici
    Random r = new Random();
    if(r.nextBoolean()==true){
      coinState = CoinState.HEADS;
    } else { coinState = CoinState.TAILS;}
  }

  public CoinState getState() {
    return coinState;
  }


}
