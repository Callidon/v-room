package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC2.1
 * Classe repésentant la commande ajoutant un materiel à une reservation au système
 */
class AjouterMaterielReservationCommande(system : Systeme,
                                         mediator : Mediator,
                                         reservation : ReservationDTO,
                                         materiel : MaterielMobileDTO ) extends Command[Unit](system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {
    val new_reservation = system.addMaterielMobile(reservation,materiel).asInstanceOf[ReservationDTO]
    //Suppression du matos dans la liste de dispo mobile
    system.popMaterielMobileDisponible(materiel)
    system.popReservation(reservation)
    system.addReservation(new_reservation)
    mediator.update(new_reservation)

  }
}
