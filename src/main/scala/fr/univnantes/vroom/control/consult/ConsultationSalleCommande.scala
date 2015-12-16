package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Commande de consultation des salles
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  */
class ConsultationSalleCommande(system: Systeme) extends Command[Set[DataTransfertObject]](system) {
  /**
    * Execute la commande
    * @return Set de DTO de salles
    */
  override def execute(): Set[DataTransfertObject] = system.viewSalle()

}
