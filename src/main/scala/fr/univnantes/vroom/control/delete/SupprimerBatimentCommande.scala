package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Batiment, Systeme}

/**
  * Created by folkvir on 03/12/15.
  */
class SupprimerBatimentCommande (
                                  system : Systeme,
                                  batiment : Batiment
                                ) extends Command[Unit](system) {
  override def execute : Unit = {
    system.popBatiment(batiment)
    system.mediator.delete(batiment)
  }
}
