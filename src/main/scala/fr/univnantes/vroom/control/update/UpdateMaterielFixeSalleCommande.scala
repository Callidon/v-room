package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.core.dto.{ReservationDTO, SalleDTO}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 19:04.
  *
  */
class UpdateMaterielFixeSalleCommande(
                                               system : Systeme,
                                              mediator : Mediator,
                                              salle : SalleDTO,
                                              old_materiel : MaterielFixeDTO,
                                              new_materiel : MaterielFixeDTO) extends Command[Unit](system) {
  override def execute() : Unit ={
    //SUpression de l'ancien materiel
    system.popMaterielFixe(salle,old_materiel).asInstanceOf[ReservationDTO]
    //Ajout du nouveau materiel
    val new_salle = system.addMaterielFixe(salle,new_materiel).asInstanceOf[SalleDTO]
    //update de la réservation
    system.popSalle(salle)
    system.addSalle(new_salle)
    mediator.update(new_salle)
  }
}
