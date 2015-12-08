package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 22:01.
  *
  */
class AjouterMaterielFixeDisponibleCommande(
                                    system : Systeme,
                                    mediator : Mediator,
                                    materiel : MaterielFixeDTO ) extends Command[Unit](system) {
  override def execute() : Unit = {
    system.addMaterieFixeDisponible(materiel)
    mediator.insert(materiel)
  }

}
