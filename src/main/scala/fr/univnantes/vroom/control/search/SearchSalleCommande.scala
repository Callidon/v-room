package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO

/**
 * EXIGENCE FONCTIONNELLE UC2.2
 */
class SearchSalleCommande(system : Systeme,
                          search_pred : (SalleDTO) => Boolean) extends Command[Set[SalleDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[SalleDTO] = {
    system.searchSalle(search_pred)
  }
}
