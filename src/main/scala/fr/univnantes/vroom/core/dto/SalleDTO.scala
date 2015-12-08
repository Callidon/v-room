package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO
import fr.univnantes.vroom.core.dto.tarifs.TarifSalleDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifSalle
import fr.univnantes.vroom.core.persistable.{Batiment, Persistable, Salle}

/**
 * Created by E122371M on 07/12/15.
 */
case class SalleDTO(var no_etage: Int,
                    var no_salle: Int,
                    var no_bat: Int,
                    var superficie: Int,
                    var batiment: BatimentDTO,
                    var tarif : TarifSalleDTO,
                    var materiel_fixe : Set[MaterielFixeDTO]) extends DataTransfertObject("Salle") {


  override def toObject(): Persistable = new Salle( no_etage,
                                                    no_salle,
                                                    no_bat,
                                                    superficie,
                                                    DTOManager.dtoToObject(batiment.no_bat, batiment).asInstanceOf[Batiment],
                                                    DTOManager.dtoToObject(tarif.code, tarif).asInstanceOf[TarifSalle],
                                                    materiel_fixe.collect{case x:MaterielFixeDTO => x.toObject()}
                                                  )


}
