package fr.univnantes.vroom.core.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class MaterielDTO(val code: Int,
                       val libelle: String,
                       val tarif: DataTransfertObject) extends DataTransfertObject("Materiel") {

}
