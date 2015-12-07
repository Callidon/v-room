package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.persistable.Batiment

/**
 * EXIGENCE FONCTIONNELLE UC3.2
 */
class SearchBatimentCommande( system : Systeme,
                              search_pred : (Batiment) => Boolean) extends Command[Set[Batiment]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[Batiment] = {
    system.searchBatiment(search_pred)
  }
}
