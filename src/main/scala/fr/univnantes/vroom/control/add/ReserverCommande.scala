package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.persistable.Reservation
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC1.1
 * Classe repésentant la commande ajoutant une reservation au système
 */
class ReserverCommande(system : Systeme,
                       mediator: Mediator,
                       reservation : ReservationDTO) extends Command[Unit](system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {
    val res = new Reservation(reservation.ref_resa,
        reservation.date_resa,
        reservation.montant,
        DTOManager.dtoToObject(reservation.salle.no_salle),
        DTOManager.dtoToObject(reservation.demandeur.no_dem),
        DTOManager.dtoToObject(reservation.manifestation.code),
        DTOManager.dtoToObject(reservation.duree.code)
      )
    DTOManager.objectToDTO(res.ref_resa,res)
    system.addReservation(reservation)
    mediator.insert(reservation)

  }
}
