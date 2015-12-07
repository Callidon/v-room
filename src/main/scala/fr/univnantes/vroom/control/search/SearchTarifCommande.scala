package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO

/**
 * EXIGENCE FONCTIONNELLE UC3.5
 */
class SearchTarifCommande(system : Systeme,
                          search_pred : (TarifDTO) => Boolean) extends Command[Set[TarifDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[TarifDTO] = {
    system.searchTarif(search_pred)
  }
}
