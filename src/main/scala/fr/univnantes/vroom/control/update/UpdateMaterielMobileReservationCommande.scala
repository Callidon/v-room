package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 19:04.
  *
  */
class UpdateMaterielMobileReservationCommande(
                                               system : Systeme,
                                              mediator : Mediator,
                                              reservation : ReservationDTO,
                                              old_materiel : MaterielMobileDTO,
                                              new_materiel : MaterielMobileDTO) extends Command[Unit](system) {
  override def execute() : Unit ={
    //SUpression de l'ancien materiel
    system.popMaterielMobile(reservation,old_materiel).asInstanceOf[ReservationDTO]
    //Ajout du nouveau materiel
    val new_reservation = system.addMaterielMobile(reservation,new_materiel).asInstanceOf[ReservationDTO]
    //update de la réservation
    system.popReservation(reservation)
    system.addReservation(new_reservation)
    mediator.update(new_reservation)
  }
}
