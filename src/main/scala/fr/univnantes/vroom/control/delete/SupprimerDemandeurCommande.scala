package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 22:56.
  *
  */
class SupprimerDemandeurCommande (
                                   system:Systeme,
                                   mediator:Mediator,
                                   demandeur:DemandeurDTO
                                 ) extends Command[Unit](system){

  override def execute() : Unit = {
    system.popDemandeur(demandeur)
    mediator.delete(demandeur)
  }

}
