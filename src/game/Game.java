package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    private int total, smallest, biggest;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      // TODO: Votre code ici
        List<CoinState> lst = new ArrayList<>();
        history.put(player, lst);
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      // TODO: Votre code ici
        total = 0;
        smallest = -1;
        biggest = -1;
        coin = coin.getInstance();
        rules = rules.getInstance();
        List<CoinState> lstCS;
        for(Player p : history.keySet()){
             lstCS = history.get(p);
            while (rules.checkWin(lstCS)==false){
                p.play(coin);
                lstCS.add(coin.getState());
                total++;
            }
            history.replace(p,lstCS);
            if(lstCS.size() < smallest){
                smallest = lstCS.size();
            }

            if(lstCS.size() > biggest){
                biggest = lstCS.size();
            }

        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      // TODO: Votre code ici
        return new Statistics(total/history.size(), smallest, biggest, total);
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici
      return new HashMap<>(history);
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici
      return new ArrayList<>(history.get(player));
    }

}
