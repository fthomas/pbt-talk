val stringSpec = new ComparableSpec[String]
stringSpec.check(_.withMinSuccessfulTests(1000))
//
import org.scalacheck._
import org.scalacheck.Arbitrary._
//
implicit val arbitraryInteger =
  Arbitrary(arbitrary[Int].map(i => new Integer(i)))
//
val integerSpec = new ComparableSpec[java.lang.Integer]
integerSpec.check

