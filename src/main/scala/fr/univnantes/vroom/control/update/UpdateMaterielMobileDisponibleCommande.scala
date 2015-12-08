package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 19:04.
  *
  */
class UpdateMaterielMobileDisponibleCommande(
                                               system : Systeme,
                                              mediator : Mediator,
                                              old_materiel : MaterielMobileDTO,
                                              new_materiel : MaterielMobileDTO) extends Command[Unit](system) {
  override def execute() : Unit ={
    system.popMaterielMobileDisponible(old_materiel)
    system.addMaterielMobileDisponible(new_materiel)
    mediator.update(new_materiel)
  }
}
