package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 19:02.
  *
  */
class SupprimerMaterielMobileDisponibleCommande(
                                                   system: Systeme,
                                                   mediator: Mediator,
                                                   materiel:MaterielMobileDTO
                                                 ) extends Command[Unit](system){
  override def execute() : Unit = {
    system.popMaterielMobileDisponible(materiel)
    //On met à jour le système et le mediator
    mediator.update(materiel)
  }

}
