package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'update de materiel mobile à une salle
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param reservation DTO
  * @param old_materiel ancien DTO
  * @param new_materiel nouveau DTO
  */
class UpdateMaterielMobileReservationCommande(
                                               system: Systeme,
                                               mediator: Mediator,
                                               reservation: ReservationDTO,
                                               old_materiel: MaterielMobileDTO,
                                               new_materiel: MaterielMobileDTO) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //SUpression de l'ancien materiel
    system.popMaterielMobile(reservation, old_materiel).asInstanceOf[ReservationDTO]
    //Ajout du nouveau materiel
    val new_reservation = system.addMaterielMobile(reservation, new_materiel).asInstanceOf[ReservationDTO]
    //update de la réservation
    system.popReservation(reservation)
    system.addReservation(new_reservation)
    mediator.update(new_reservation)
  }
}
