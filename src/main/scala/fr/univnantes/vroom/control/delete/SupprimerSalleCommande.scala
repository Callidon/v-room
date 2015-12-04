package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Salle, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC2.4
  */
class SupprimerSalleCommande (system : Systeme,
                              mediator: Mediator,
                              salle : Salle) extends Command[Unit](system) {
  override def execute() : Unit = {
    system.popSalle(salle)
    mediator.delete(salle)
  }
}
