package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 19:02.
  *
  */
class SupprimerMaterielMobileReservationCommande (
                                                   system: Systeme,
                                                   mediator: Mediator,
                                                   reservation: ReservationDTO,
                                                   materiel:MaterielMobileDTO
                                                 )extends Command[Unit](system){
  override def execute() : Unit = {
    val reserv = system.popMaterielMobile(reservation,materiel).asInstanceOf[ReservationDTO]
    //On met à jour le système et le mediator
    system.popReservation(reservation)
    system.addReservation(reserv)
    mediator.update(reserv)
  }

}
