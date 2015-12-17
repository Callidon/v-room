package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.core.dto.tarifs.TarifSalleDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifSalle
import fr.univnantes.vroom.core.persistable.{Batiment, Persistable, Salle}

/**
  * Classe représentant une salle dans le système
  * @param no_etage Numéro de l'étage de la salle
  * @param no_salle Numéro de la salle
  * @param no_bat Numéro de la salle
  * @param superficie Superficie de la salle en m2
  * @param batiment DTO Batiment de la salle
  * @param tarif DTO Tarif de la salle
  * @param materiel_fixe Set de matériel fixe de la salle
  */
case class SalleDTO(var no_etage: Int,
                    var no_salle: Int,
                    var no_bat: Int,
                    var superficie: Int,
                    var batiment: BatimentDTO,
                    var tarif: TarifSalleDTO,
                    var materiel_fixe: Set[MaterielFixeDTO]) extends DataTransfertObject("Salle") {

  /**
    * Transforme le DTO en objet concret du système
    * @return
    */
  override def toObject: Persistable = new Salle(no_etage,
    no_salle,
    no_bat,
    superficie,
    DTOManager.dtoToObject(batiment.no_bat, batiment).asInstanceOf[Batiment],
    DTOManager.dtoToObject(tarif.code, tarif).asInstanceOf[TarifSalle],
    materiel_fixe.collect { case x: MaterielFixeDTO => x.toObject }
  )


}
