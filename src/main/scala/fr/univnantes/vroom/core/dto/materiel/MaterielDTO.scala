package fr.univnantes.vroom.core.dto.materiel

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
 * Projet : Default (Template) Project
 * Créé par E122371M le 07/12/15 à 23:01.
 *
 */
abstract case class MaterielDTO(  var code: Int,
                                  var libelle: String,
                                  var tarif: DataTransfertObject) extends DataTransfertObject("Materiel") {

}
