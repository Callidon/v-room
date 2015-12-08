package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Projet : v-room
  * Créé par folkvir le 08/12/15 à 22:01.
  *
  */
class AjouterMaterielMobileDisponibleCommande(
                                    system : Systeme,
                                    mediator : Mediator,
                                    materiel : MaterielMobileDTO ) extends Command[Unit](system) {
  override def execute() : Unit = {
    system.addMaterielMobileDisponible(materiel)
    mediator.insert(materiel)
  }

}
