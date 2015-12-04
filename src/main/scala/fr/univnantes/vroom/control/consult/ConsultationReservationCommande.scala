package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC1.2
  */
class ConsultationReservationCommande(system : Systeme) extends Command[Unit](system){
  override def execute(): Unit = {
    system.viewReservation()
  }
}
