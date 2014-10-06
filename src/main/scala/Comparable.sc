val stringSpec = new ComparableSpec[String]
stringSpec.check(_.withMinSuccessfulTests(1000))
//
import org.scalacheck._
import org.scalacheck.Arbitrary._
//
implicit val arbitraryByte =
  Arbitrary(arbitrary[Byte].map(i => new java.lang.Byte(i)))
//
val byteSpec = new ComparableSpec[java.lang.Byte]
byteSpec.check
