package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Commande permettant la consultation des demandeurs
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  */
class ConsulterDemandeurCommande(
                                  system: Systeme
                                ) extends Command[Set[DataTransfertObject]](system) {
  /**
    *
    * @return Set de DTO de demandeurs
    */
  override def execute(): Set[DataTransfertObject] = system.viewDemandeur()
}
