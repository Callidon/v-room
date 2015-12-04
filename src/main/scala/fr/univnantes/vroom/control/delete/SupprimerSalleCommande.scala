package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Salle, Systeme}

/**
  * EXIGENCE FONCTIONNELLE UC2.4
  */
class SupprimerSalleCommande (
                               system : Systeme,
                               salle : Salle
                             ) extends Command[Unit](system) {
  override def execute() : Unit = {
    system.popSalle(salle)
    system.mediator.delete(salle)
  }
}
