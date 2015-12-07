package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO

/**
*  Projet : v-room
*  Créé par E122371M le 30/11/15 à 00:03.
*
*/
class SearchReservationCommande(system : Systeme,
                                search_pred : (ReservationDTO) => Boolean) extends Command[Set[ReservationDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[ReservationDTO] = {
    system.searchReservation(search_pred)
  }
}
