import org.scalacheck._
import pbt.Bandwidth

implicit val arbitraryBandwidth: Arbitrary[Bandwidth] =
  Arbitrary {
    for {
      up <- Gen.posNum[Int]
      down <- Gen.posNum[Int]
    } yield new Bandwidth(up, down)
  }

arbitraryBandwidth.arbitrary.sample

val bandwidthSpec = new ComparableSpecV3[Bandwidth]
bandwidthSpec.check
