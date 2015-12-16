package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO

/**
  * Commande de recherche pour réservation
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchReservationCommande(system: Systeme,
                                search_pred: (ReservationDTO) => Boolean) extends Command[Set[ReservationDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO batiment
    */
  override def execute(): Set[ReservationDTO] = {
    system.searchReservation(search_pred)
  }
}
