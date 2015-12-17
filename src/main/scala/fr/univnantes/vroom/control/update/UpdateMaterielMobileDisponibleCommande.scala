package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'update de materiel mobile disponible
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param old_materiel ancien DTO
  * @param new_materiel nouveau DTO
  */
class UpdateMaterielMobileDisponibleCommande(
                                              system: Systeme,
                                              mediator: Mediator,
                                              old_materiel: MaterielMobileDTO,
                                              new_materiel: MaterielMobileDTO) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.popMaterielMobileDisponible(old_materiel)
    system.addMaterielMobileDisponible(new_materiel)
    mediator.update(new_materiel)
  }
}
