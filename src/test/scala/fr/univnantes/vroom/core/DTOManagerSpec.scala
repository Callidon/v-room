package fr.univnantes.vroom.core

import fr.univnantes.vroom.core.dto.AdresseDTO
import fr.univnantes.vroom.core.persistable.Adresse
import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, FunSpec}

/**
  * Classe représentant les jeux de tests pour la singleton DTOManager
  */
class DTOManagerSpec extends FunSpec with Matchers with MockFactory {

  describe("DTOManager") {

    val adresse = new Adresse(166, "6 avenue des lutins bleus", "44200", "Nantes")
    val adresseDTO = new AdresseDTO(166, "6 avenue des lutins bleus", "44200", "Nantes")

    describe("#objectToDTO") {
      it("can transform an object to a DTO") {
        val dto = DTOManager.objectToDTO(adresse)

        dto should be (adresseDTO)
      }
    }

    describe("dtoToObject") {
      it("can transform a DTO to an object") {
        val objet = DTOManager.dtoToObject(adresseDTO.numero, adresseDTO)

        objet should be (adresse)
      }

      it("doesn't duplicate the result of similar transformation") {
        val objet = DTOManager.dtoToObject(adresseDTO.numero, adresseDTO)
        val other_object = DTOManager.dtoToObject(adresseDTO.numero, adresseDTO)

        other_object should be theSameInstanceAs (objet)
      }
    }
  }
}
