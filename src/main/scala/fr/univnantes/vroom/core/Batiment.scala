package fr.univnantes.vroom.core

/**
 * Classe représentant un bâtiment
 *
 * @constructor Crée un nouveau bâtiment
 * @param no_bat Un numéro unique qui représente le bâtiment
 * @param nom Le nom du bâtiment
 * @param adresse L'adresse du bâtiment
 */
case class Batiment(var no_bat: Int,
               var nom: String,
               var adresse: Adresse ) {

  private var _salles : Set[Salle] = Set();

  /**
   * Ajoute une nouvelle salle
   * @param salle La salle à ajouter
   */
  def addSalle(salle: Salle): Unit = {
    _salles += salle
  }

  /**
   * Supprime une salle
   * @param salle La salle à supprimer
   */
  def popSalle(salle: Salle) : Unit = {
    _salles -= salle
  }

}
