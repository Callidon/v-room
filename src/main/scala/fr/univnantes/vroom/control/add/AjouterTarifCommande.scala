package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'ajout d'un tarif
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param tarif DTO
  */
class AjouterTarifCommande(system: Systeme,
                           mediator: Mediator,
                           tarif: TarifDTO) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.addTarif(tarif)
    mediator.insert(tarif)
  }

}
