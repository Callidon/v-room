package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Reservation, Systeme}

/**
 * Created by E122371M on 30/11/15.
 */
class SearchReservationCommande(
                                 system : Systeme,
                                 search_pred : (Reservation) => Boolean
                                 ) extends Command[Set[Reservation]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[Reservation] = {
    system.searchReservation(search_pred)
  }
}
