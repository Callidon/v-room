package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Trait représentant la super classe d'un objet du système
  */
trait Persistable {
  /**
    * Transforme un objet en son DTO
    * @return Retourne un DTO
    */
  def toDTO: DataTransfertObject

}
