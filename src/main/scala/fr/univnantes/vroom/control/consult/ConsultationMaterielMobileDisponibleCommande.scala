package fr.univnantes.vroom.control.consult

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * EXIGENCE FONCTIONNELLE UC1.2
  */
class ConsultationMaterielMobileDisponibleCommande(system : Systeme) extends Command[DataTransfertObject](system){
  override def execute(): Set[DataTransfertObject] = {
    system.viewMaterielMobileDisponible()
  }
}
