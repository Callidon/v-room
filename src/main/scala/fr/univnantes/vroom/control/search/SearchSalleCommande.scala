package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO

/**
  * Commande de recherche pour Salle
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchSalleCommande(system: Systeme,
                          search_pred: (SalleDTO) => Boolean) extends Command[Set[SalleDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO sale
    */
  override def execute(): Set[SalleDTO] = {
    system.searchSalle(search_pred)
  }
}
