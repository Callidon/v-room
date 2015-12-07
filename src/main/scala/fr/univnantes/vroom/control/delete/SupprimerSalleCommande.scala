package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC2.4
  */
class SupprimerSalleCommande (system : Systeme,
                              mediator: Mediator,
                              salle : SalleDTO) extends Command[Unit](system) {
  override def execute() : Unit = {
    DTOManager.deleteDto(salle.no_salle)
    system.popSalle(salle)
    mediator.delete(salle)
  }
}
