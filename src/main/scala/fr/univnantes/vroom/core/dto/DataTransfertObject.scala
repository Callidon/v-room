package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.persistable.Persistable

/**
  * Classe abstraite représentant un DTO
  * @param className Nom de la classe représentant le DTO
  */
abstract class DataTransfertObject(val className: String) {
  /**
    * Transforme le DTO en objet concret du système
    * @return Retourne un DTO
    */
  def toObject: Persistable

}
