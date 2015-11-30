package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Salle, Systeme}

/**
 * Created by E122371M on 30/11/15.
 */
class SearchSalleCommande(
                           system : Systeme,
                           search_pred : (Salle) => Boolean
                           ) extends Command[Set[Salle]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[Salle] = {
    system.searchSalle(search_pred)
  }
}
