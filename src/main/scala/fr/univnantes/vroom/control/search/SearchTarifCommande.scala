package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.tarifs.Tarif
import fr.univnantes.vroom.core.Systeme

/**
 * EXIGENCE FONCTIONNELLE UC3.5
 */
class SearchTarifCommande(system : Systeme,
                          search_pred : (Tarif) => Boolean) extends Command[Set[Tarif]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[Tarif] = {
    system.searchTarif(search_pred)
  }
}
