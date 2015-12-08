package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.{DataTransfertObject, DemandeurDTO}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 22:54.
  *
  */
class ConsulterDemandeurCommande (
                                   system:Systeme,
                                   mediator:Mediator,
                                   demandeur:DemandeurDTO
                                 ) extends Command[Set[DataTransfertObject]](system){

  override def execute() : Set[DataTransfertObject] = system.viewDemandeur()
}
