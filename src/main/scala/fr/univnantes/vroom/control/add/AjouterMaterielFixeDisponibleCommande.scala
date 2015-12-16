package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'ajout d'un materiel fixe disponible
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param materiel DTO
  */
class AjouterMaterielFixeDisponibleCommande(
                                             system: Systeme,
                                             mediator: Mediator,
                                             materiel: MaterielFixeDTO) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.addMaterieFixeDisponible(materiel)
    mediator.insert(materiel)
  }

}
