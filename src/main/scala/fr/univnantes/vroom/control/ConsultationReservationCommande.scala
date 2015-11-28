package fr.univnantes.vroom.control

import fr.univnantes.vroom.core.Systeme

/**
  * Created by folkvir on 28/11/15.
  */
class ConsultationReservationCommande(
                                     system : Systeme
                                     ) extends Command(system){
  override def execute(): Unit = {
    system.viewReservation()
  }
}
