package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'ajout d'un materiel à une salle
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param salle DTO
  * @param materiel DTO
  */
class AjouterMaterielSalleCommande(system: Systeme,
                                   mediator: Mediator,
                                   salle: SalleDTO,
                                   materiel: MaterielFixeDTO) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    val new_salle = system.addMaterielFixe(salle, materiel).asInstanceOf[SalleDTO]
    //Suppression du matos dans la liste de dispo mobile
    system.popMaterielFixeDisponible(materiel)
    system.popSalle(salle)
    system.addSalle(new_salle)
    mediator.update(new_salle)

  }
}
