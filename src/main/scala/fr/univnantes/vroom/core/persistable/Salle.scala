package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.{BatimentDTO, DataTransfertObject, SalleDTO}
import fr.univnantes.vroom.core.persistable.materiel.{Materiel, MaterielFixe}
import fr.univnantes.vroom.core.persistable.tarifs.TarifSalle

/**
 * Classe représentant une salle
 *
 * @constructor Crée une nouvelle salle
 * @param no_etage Le numéro de l'étage où se situe la salle
 * @param no_salle Le numéro de la salle
 * @param no_bat Le numéro du bâtiment où se situe la salle
 * @param superficie La superficie de la salle
 * @param batiment Le bâtiment dans lequel se situe la salle
 * @param tarif Le tarif lié au type de la salle
 */
case class Salle( var no_etage: Int,
                  var no_salle: Int,
                  var no_bat: Int,
                  var superficie: Int,
                  var batiment: Batiment,
                  var tarif : TarifSalle) extends Persistable {

  override def toDTO() = new SalleDTO(no_etage, no_salle, no_bat, superficie, batiment.toDTO(), tarif.toDTO())

  // Ensemble des matériels fixes liés à la salle
  private var _materiels_fixes : Set[Materiel] = Set()

  /**
    * Affiche récursivement les informations de la salle
    * @return
    */
  override def toString : String = " - Salle : \n  | Numerobatiment : "+ no_bat +
    " \n  | " + batiment +
    " \n  | Numero Etage : " + no_etage +
    " \n  | Numero Salle : " + no_salle +
    " \n  | Superficie : " + superficie +
    " \n  | " + _materiels_fixes

  /**
   * Ajoute un nouveau matériel fixe
   * @param materiel Le matériel fixe à ajouter
   */
  def addMateriel(materiel: MaterielFixe): Unit = _materiels_fixes += materiel

  /**
   * Supprime un matériel fixe
   * @param materiel Le matériel fixe à supprimer
   */
  def popMateriel(materiel: MaterielFixe) : Unit = _materiels_fixes -= materiel

  /**
   * Méthode renvoyant le tarif de la salle
   * @return Le tarif de la salle
   */
  def calculerTarif() : Double = {
    val tarif_materiels = _materiels_fixes.foldLeft(0.0) { (acc, materiel) =>
      acc + materiel.calculerTarif()
    }

    tarif.tarif + tarif_materiels
  }
}
