package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'ajout d'un materiel mobile dispnible
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param materiel DTO
  */
class AjouterMaterielMobileDisponibleCommande(
                                               system: Systeme,
                                               mediator: Mediator,
                                               materiel: MaterielMobileDTO) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.addMaterielMobileDisponible(materiel)
    mediator.insert(materiel)
  }

}
