package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.BatimentDTO

/**
  * Commande de recherche pour batiment
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchBatimentCommande(system: Systeme,
                             search_pred: (BatimentDTO) => Boolean) extends Command[Set[BatimentDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO batiment
    */
  override def execute(): Set[BatimentDTO] = {
    system.searchBatiment(search_pred)
  }
}
