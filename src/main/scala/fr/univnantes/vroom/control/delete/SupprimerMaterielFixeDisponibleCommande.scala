package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande de suppression d'un materiel fixe disponible
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param materiel DTO
  */
class SupprimerMaterielFixeDisponibleCommande(
                                               system: Systeme,
                                               mediator: Mediator,
                                               materiel: MaterielFixeDTO
                                             ) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    system.popMaterielFixeDisponible(materiel)
    //On met à jour  le mediator
    mediator.update(materiel)
  }
}
