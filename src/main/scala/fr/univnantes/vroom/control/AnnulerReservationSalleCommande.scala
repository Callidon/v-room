package fr.univnantes.vroom.control

import fr.univnantes.vroom.core.{Reservation, Systeme}

/**
  * Created by folkvir on 27/11/15.
  */
class AnnulerReservationSalleCommande (
                                        system : Systeme,
                                        reservation : Reservation
                                      ) extends Command(system) {

  override def execute() : Unit = {
    system.mediator.delete(reservation)
    system.popReservation(reservation)
  }
}
