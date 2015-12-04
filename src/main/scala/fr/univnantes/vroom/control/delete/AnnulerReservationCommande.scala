package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Reservation, Systeme}

/**
  * EXIGENCE FONCTIONNELLE UC1.3
  */
class AnnulerReservationCommande(
                                        system : Systeme,
                                        reservation : Reservation
                                      ) extends Command[Unit](system) {

  override def execute() : Unit = {
    system.mediator.delete(reservation)
    system.popReservation(reservation)
  }
}
