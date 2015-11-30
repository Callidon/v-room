package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Reservation, Systeme}

/**
  * Created by folkvir on 27/11/15.
  */
class AnnulerReservationSalleCommande (
                                        system : Systeme,
                                        reservation : Reservation
                                      ) extends Command[Unit](system) {

  override def execute() : Unit = {
    system.mediator.delete(reservation)
    system.popReservation(reservation)
  }
}
