package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Batiment, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC3.4
  */
class SupprimerBatimentCommande(system : Systeme,
                                mediator: Mediator,
                                batiment : Batiment) extends Command[Unit](system) {
  override def execute() : Unit = {
    system.popBatiment(batiment)
    mediator.delete(batiment)
  }
}
