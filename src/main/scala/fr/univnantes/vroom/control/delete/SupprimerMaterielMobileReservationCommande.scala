package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  *
  * Commande de suppression d'un materiel mobile d'une résrvation
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param reservation DTO
  * @param materiel DTO
  */
class SupprimerMaterielMobileReservationCommande(
                                                  system: Systeme,
                                                  mediator: Mediator,
                                                  reservation: ReservationDTO,
                                                  materiel: MaterielMobileDTO
                                                ) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    val reserv = system.popMaterielMobile(reservation, materiel).asInstanceOf[ReservationDTO]
    system.addMaterielMobileDisponible(materiel)
    //On met à jour le système et le mediator
    system.popReservation(reservation)
    system.addReservation(reserv)
    mediator.update(reserv)
  }

}
