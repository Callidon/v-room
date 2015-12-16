package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Commande de consultation des réservation
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  */
class ConsultationReservationCommande(system: Systeme) extends Command[Set[DataTransfertObject]](system) {
  /**
    * Eecute la commande
    * @return Set de DTO de réservations
    */
  override def execute(): Set[DataTransfertObject] = system.viewReservation()
}
