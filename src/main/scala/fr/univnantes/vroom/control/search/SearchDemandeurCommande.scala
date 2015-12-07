package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO

/**
 * Projet : Default (Template) Project
 * Créé par E122371M le 30/11/15 à 00:01.
 *
 */
class SearchDemandeurCommande(system : Systeme,
                              search_pred : (DemandeurDTO) => Boolean) extends Command[Set[DemandeurDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[DemandeurDTO] = {
    system.searchDemandeur(search_pred)
  }
}
