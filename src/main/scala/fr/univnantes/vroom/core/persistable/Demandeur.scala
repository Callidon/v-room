package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.core.persistable.tarifs.{TarifOrigine, TarifTitre}

/**
  * Classe représentant un démandeur, qui cherche à réserver une salle
  *
  * @constructor Crée un nouveau demandeur
  * @param no_dem Un numéro unique qui représente le demandeur
  * @param nom Le nom du demandeur
  * @param adresse L'adresse du demandeur
  * @param origine Le tarif lié à l'origine du demandeur
  * @param titre Le tarif lié au titre du demandeur
  */
case class Demandeur(var no_dem: Int,
                     var nom: String,
                     var adresse: Adresse,
                     var origine: TarifOrigine,
                     var titre: TarifTitre) extends Persistable {
  /**
    * Transforme un objet en son DTO
    * @return
    */
  override def toDTO = new DemandeurDTO(no_dem, nom, adresse.toDTO, origine.toDTO, titre.toDTO)

  /**
    * Affiche récursivement les informations du demandeur
    * @return
    */
  override def toString: String = " Demandeur : " +
    " \n  | Numero du demandeur :" + no_dem +
    " \n  | Nom :" + nom +
    " \n  | " + adresse.toString() +
    " \n  | " + origine.toString() +
    " \n  | " + titre.toString()

  /**
    * Méthode renvoyant le tarif lié au demandeur
    * @return Le tarif lié au demandeur
    */
  def calculerTarif(): Double = origine.tarif + titre.tarif
}
