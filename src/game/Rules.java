package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  private static Rules instance = null;

  private Rules(){

  }

  public static Rules getInstance() {
    if(instance == null){
      instance = new Rules();
    }
    return instance;
  }

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    // TODO: Votre code ici
    int heads = 0;
    if(states.size()>1){
      for(CoinState cs:states){
        if(cs.equals(CoinState.HEADS)){
          heads++;
          if(heads>2){return true;}
        }
      }
    }
    return false;
  }
}
