package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  *
  * Commande de suppression d'un matériel fixe d'une salle
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param salle DTO
  * @param materiel DTO
  */
class SupprimerMaterielFixeSalleCommande(
                                          system: Systeme,
                                          mediator: Mediator,
                                          salle: SalleDTO,
                                          materiel: MaterielFixeDTO
                                        ) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    val res_salle = system.popMaterielFixe(salle, materiel).asInstanceOf[SalleDTO]
    system.addMaterieFixeDisponible(materiel)
    //On met à jour le système et le mediator
    system.popSalle(salle)
    system.addSalle(res_salle)
    mediator.update(res_salle)
  }
}
