package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Commqnde de consultation des matériel mobile
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  */
class ConsultationMaterielFixeDisponibleCommande(system: Systeme) extends Command[Set[DataTransfertObject]](system) {

  /**
    * Fonction lançant la commande
    * @return Retourne un Set de DTO de matériels mobile disponible
    */
  override def execute(): Set[DataTransfertObject] = system.viewMaterielFixeDisponible()

}
