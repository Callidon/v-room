package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  *
  * Commande de suppression d'un materiel mobile disponible
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param materiel DTO
  */
class SupprimerMaterielMobileDisponibleCommande(
                                                 system: Systeme,
                                                 mediator: Mediator,
                                                 materiel: MaterielMobileDTO
                                               ) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    system.popMaterielMobileDisponible(materiel)
    //On met à jour le système et le mediator
    mediator.update(materiel)
  }

}
