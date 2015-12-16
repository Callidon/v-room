package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande de suppression d'une réservation
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param reservation DT
  */
class AnnulerReservationCommande(system: Systeme,
                                 mediator: Mediator,
                                 reservation: ReservationDTO) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    system.popReservation(reservation)
    mediator.delete(reservation)
  }
}
