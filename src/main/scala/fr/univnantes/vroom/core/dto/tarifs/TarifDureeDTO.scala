package fr.univnantes.vroom.core.dto.tarifs

import fr.univnantes.vroom.core.persistable.Persistable
import fr.univnantes.vroom.core.persistable.tarifs.TarifDuree

/**
  * Classe représentant un tarif Durée
  * @param code Int, Code tu tarif
  * @param libelle String, Libellé du tarif
  * @param tarif Double, Valeur du tarifif
  */
class TarifDureeDTO(code: Int,
                    libelle: String,
                    tarif: Double) extends TarifDTO(code, libelle, tarif) {
  /**
    * Méthode transformant le DTO en Objet pour le système
    * @return Retourne un objet concret du système
    */
  override def toObject(): Persistable = new TarifDuree(code, libelle, tarif)
}
