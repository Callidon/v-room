package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 19:04.
  *
  */
class UpdateMaterielFixeDisponibleCommande(
                                               system : Systeme,
                                              mediator : Mediator,
                                              old_materiel : MaterielFixeDTO,
                                              new_materiel : MaterielFixeDTO) extends Command[Unit](system) {
  override def execute() : Unit ={
    //SUpression de l'ancien materiel
    system.popMaterielFixeDisponible(old_materiel)
    system.addMaterieFixeDisponible(new_materiel)
    mediator.update(new_materiel)
  }
}
