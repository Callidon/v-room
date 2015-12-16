package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.BatimentDTO
import fr.univnantes.vroom.datacontroller.Mediator


/**
  * Commande d'ajout d'un batiment
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param batiment DTO
  */
class AjouterBatimentCommande(system: Systeme,
                              mediator: Mediator,
                              batiment: BatimentDTO) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {

    system.addBatiment(batiment)
    mediator.insert(batiment)

  }
}
