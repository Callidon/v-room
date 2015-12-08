package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC1.3
  * Commande pour annuler une réservation
  */
class AnnulerReservationCommande( system : Systeme,
                                  mediator : Mediator,
                                  reservation : ReservationDTO) extends Command[Unit](system) {

  override def execute() : Unit = {
    system.popReservation(reservation)
    mediator.delete(reservation)
  }
}
