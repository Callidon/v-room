package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'ajout de salle
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param salle DTO
  */
class AjouterSalleCommande(system: Systeme,
                           mediator: Mediator,
                           salle: SalleDTO) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.addSalle(salle)
    mediator.insert(salle)

  }
}
