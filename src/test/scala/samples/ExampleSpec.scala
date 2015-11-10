package samples

/*
ScalaTest also supports the behavior-driven development style, in which you
combine tests with text that specifies the behavior being tested. Here's
an example whose text output when run looks like:

A Map
- should only contain keys and values that were added to it
- should report its size as the number of key/value pairs it contains
*/
import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}
import org.scalatest.prop.TableDrivenPropertyChecks._
import scala.collection.mutable.Stack

class ExampleSpec extends FunSpec with Matchers with BeforeAndAfter {

  describe("A Stack") {

    describe("#getFoo") {

      val table = Table(
        ("colname_1", "colname_2"),
        (1,1)
      )

      // Exemple de test avec des resources paramétrées
      it("should be able to make a dummy test with parametrized resources") {
        forAll(table) { (colname_1: Int, colname_2: Int) =>
          (colname_1) should be (colname_2)
        }
      }
    }


  describe("#stack") {
    val stack = new Stack[Int]

    before {
      stack.clear()
      stack.push(1)
      stack.push(2)
    }

    it("should pop values in last-in-first-out order") {
      stack.pop() should be (2)
      stack.pop() should be (1)
    }

    it("should throw NoSuchElementException if an empty stack is popped") {
      stack.pop()
      stack.pop()
      an [NoSuchElementException] should be thrownBy stack.pop()
    }
  }

  }
}
