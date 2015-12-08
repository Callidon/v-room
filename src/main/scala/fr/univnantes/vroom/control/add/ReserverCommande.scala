package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
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
    system.addReservation(reservation)
    mediator.insert(reservation)

  }
}
