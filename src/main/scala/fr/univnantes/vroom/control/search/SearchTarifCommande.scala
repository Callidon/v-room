package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO

/**
  * Commande de recherche pour tarifs
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchTarifCommande(system: Systeme,
                          search_pred: (TarifDTO) => Boolean) extends Command[Set[TarifDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO tarif
    */
  override def execute(): Set[TarifDTO] = {
    system.searchTarif(search_pred)
  }
}
