package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.BatimentDTO

/**
 * EXIGENCE FONCTIONNELLE UC3.2
 */
class SearchBatimentCommande( system : Systeme,
                              search_pred : (BatimentDTO) => Boolean) extends Command[Set[BatimentDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[BatimentDTO] = {
    system.searchBatiment(search_pred)
  }
}
