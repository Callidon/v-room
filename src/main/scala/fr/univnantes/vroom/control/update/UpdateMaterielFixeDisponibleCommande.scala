package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'update de materiel fixe disponible
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param old_materiel ancien DTO
  * @param new_materiel nouveau DTO
  */
class UpdateMaterielFixeDisponibleCommande(
                                            system: Systeme,
                                            mediator: Mediator,
                                            old_materiel: MaterielFixeDTO,
                                            new_materiel: MaterielFixeDTO) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.popMaterielFixeDisponible(old_materiel)
    system.addMaterieFixeDisponible(new_materiel)
    mediator.update(new_materiel)
  }
}
