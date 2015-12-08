package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.{BatimentDTO, DataTransfertObject}

/**
 * Classe représentant un bâtiment
 *
 * @constructor Crée un nouveau bâtiment
 * @param no_bat Un numéro unique qui représente le bâtiment
 * @param nom Le nom du bâtiment
 * @param adresse L'adresse du bâtiment
 */
case class Batiment( var no_bat: Int,
                     var nom: String,
                     var adresse: Adresse ) extends Persistable {

  override def toDTO() = new BatimentDTO(no_bat, nom, adresse.toDTO())

  private var _salles : Set[Salle] = Set()

  /**
    * Affiche récursivement les informations du batiment
    * @return
    */
  override def toString : String = " - Batiment : "+
    " \n  | Numero batiment :"+no_bat+
    " \n  | Nom : "+nom+
    " \n  | "+adresse

  /**
   * Ajoute une nouvelle salle
   * @param salle La salle à ajouter
   */
  def addSalle(salle: Salle): Unit = _salles += salle

  /**
   * Supprime une salle
   * @param salle La salle à supprimer
   */
  def popSalle(salle: Salle) : Unit = _salles -= salle

}
