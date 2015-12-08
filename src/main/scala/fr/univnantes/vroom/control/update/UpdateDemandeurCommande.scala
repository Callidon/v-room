package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 22:59.
  *
  */
class UpdateDemandeurCommande (
                                system:Systeme,
                                mediator:Mediator,
                                old_demandeur:DemandeurDTO,
                                new_demandeur: DemandeurDTO
                              ) extends Command[Unit](system){

  override def execute() : Unit = {
    system.popDemandeur(old_demandeur)
    system.addDemandeur(new_demandeur)
    mediator.update(new_demandeur)
  }

}
