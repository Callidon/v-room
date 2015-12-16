package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO

/**
  * Commande de recherche pour demandeur
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchDemandeurCommande(system: Systeme,
                              search_pred: (DemandeurDTO) => Boolean) extends Command[Set[DemandeurDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO demandeur
    */
  override def execute(): Set[DemandeurDTO] = {
    system.searchDemandeur(search_pred)
  }
}
