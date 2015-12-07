package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.BatimentDTO
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC3.4
  */
class SupprimerBatimentCommande(system : Systeme,
                                mediator: Mediator,
                                batiment : BatimentDTO) extends Command[Unit](system) {
  override def execute() : Unit = {
    DTOManager.deleteDto(batiment.no_bat)
    system.popBatiment(batiment)
    mediator.delete(batiment)
  }
}
