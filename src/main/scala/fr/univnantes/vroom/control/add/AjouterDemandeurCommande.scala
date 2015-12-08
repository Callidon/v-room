package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 22:51.
  *
  */
class AjouterDemandeurCommande(
                              system:Systeme,
                              mediator:Mediator,
                              demandeur:DemandeurDTO
                              ) extends Command[Unit](system){
  override def execute() : Unit = {
    system.addDemandeur(demandeur)
    mediator.insert(demandeur)
  }
}
