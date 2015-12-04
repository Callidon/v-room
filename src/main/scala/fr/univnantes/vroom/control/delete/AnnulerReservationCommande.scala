package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Reservation, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC1.3
  */
class AnnulerReservationCommande( system : Systeme,
                                  mediator : Mediator,
                                  reservation : Reservation) extends Command[Unit](system) {

  override def execute() : Unit = {
    system.popReservation(reservation)
    mediator.delete(reservation)
  }
}
