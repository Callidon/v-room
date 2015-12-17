package fr.univnantes.vroom.core.persistable.materiel

import fr.univnantes.vroom.core.persistable.Persistable
import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel

/**
  * Classe abstraite représentant un matériel
  *
  * @constructor Crée un nouveau matériel
  * @param code Un code unique représentant le matériel
  * @param libelle le nom du matériel
  * @param tarif Le tarif correspondant à ce matériel
  */
abstract class Materiel(var code: Int,
                        var libelle: String,
                        var tarif: TarifMateriel) extends Persistable {

  /**
    * Méthode renvoyant le tarif du matériel
    * @return Le tarif du matériel
    */
  def calculerTarif(): Double = tarif.tarif

  /**
    * Affiche les informations relatives au tarif
    * @return
    */
  override def toString: String = " Type de matériel : " +
    " \n  | Code :" + code +
    " \n  | Libelle :" + libelle +
    " \n  | Tarif :" + tarif
}
