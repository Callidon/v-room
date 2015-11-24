package fr.univnantes.vroom.core

import fr.univnantes.vroom.materiel.{MaterielFixe, Materiel}

/**
 * Classe représentant une salle
 *
 * @constructor Crée une nouvelle salle
 * @param no_etage Le numéro de l'étage où se situe la salle
 * @param no_salle Le numéro de la salle
 * @param no_bat Le numéro du bâtiment où se situe la salle
 * @param superficie La superficie de la salle
 * @param batiment Le bâtiment dans lequel se situe la salle
 */
case class Salle(var no_etage: Int,
            var no_salle: Int,
            var no_bat: Int,
            var superficie: Int,
            var batiment: Batiment ) {

  // Ensemble des matériels fixes liés à la salle
  private var _materiels_fixes : Set[Materiel] = Set()

  /**
   * Ajoute un nouveau matériel fixe
   * @param materiel Le matériel fixe à ajouter
   */
  def addMateriel(materiel: MaterielFixe): Unit = {
    _materiels_fixes += materiel
  }

  /**
   * Supprime un matériel fixe
   * @param materiel Le matériel fixe à supprimer
   */
  def popMateriel(materiel: MaterielFixe) : Unit = {
    _materiels_fixes -= materiel
  }

  /**
   * Méthode renvoyant le tarif de la salle
   * @return Le tarif de la salle
   */
  def calculerTarif() : Double = {
    _materiels_fixes.foldLeft(0.0) { (acc, materiel) =>
      acc + materiel.calculerTarif()
    }
  }
}
