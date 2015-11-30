package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme

/**
  * Created by folkvir on 28/11/15.
  */
class ConsultationReservationCommande(
                                     system : Systeme
                                     ) extends Command[Unit](system){
  override def execute(): Unit = {
    system.viewReservation()
  }
}
