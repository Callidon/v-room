package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 18:56.
  *
  */
class SupprimerMaterielFixeSalleCommande(
                                        system: Systeme,
                                        mediator: Mediator,
                                        salle: SalleDTO,
                                        materiel:MaterielFixeDTO
                                        )extends Command[Unit](system){
  override def execute() : Unit = {
    val res_salle = system.popMaterielFixe(salle,materiel).asInstanceOf[SalleDTO]
    //On met à jour le système et le mediator
    system.popSalle(salle)
    system.addSalle(res_salle)
    mediator.update(res_salle)
  }
}
