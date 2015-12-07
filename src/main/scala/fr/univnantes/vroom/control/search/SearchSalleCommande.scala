package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.persistable.Salle

/**
 * EXIGENCE FONCTIONNELLE UC2.2
 */
class SearchSalleCommande(system : Systeme,
                          search_pred : (Salle) => Boolean) extends Command[Set[Salle]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[Salle] = {
    system.searchSalle(search_pred)
  }
}
