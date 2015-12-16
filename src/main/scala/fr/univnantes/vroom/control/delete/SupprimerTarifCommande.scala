package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  *
  * Commande de suppression d'un tarif
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param tarif DTO
  */
class SupprimerTarifCommande(system: Systeme,
                             mediator: Mediator,
                             tarif: TarifDTO) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    DTOManager.deleteDto(tarif.code)
    system.popTarif(tarif)
    mediator.delete(tarif)
  }

}
