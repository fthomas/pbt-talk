/*
Copied from http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html:

1. sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y

2. (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0

3. x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z
 
4. (x.compareTo(y)==0) == (x.equals(y))
*/

import org.scalacheck.Prop._
import org.scalacheck._

import scala.math.signum

class ComparableSpecV1[T <: Comparable[T]: Arbitrary] extends Properties("Comparable") {

  property("antisymmetry") = forAll {
    (x: T, y: T) =>
      signum(x.compareTo(y)) == -signum(y.compareTo(x))
  }

  property("transitivity") = forAll {
    (x: T, y: T, z: T) =>
      (x.compareTo(y) > 0 && y.compareTo(z) > 0) ==> (x.compareTo(z) > 0)
  }

  property("transitivity 2") = forAll {
    (x: T, y: T, z: T) =>
      (x.compareTo(y) == 0) ==> (signum(x.compareTo(z)) == signum(y.compareTo(z)))
  }

  property("consistency with equals") = forAll {
    (x: T, y: T) =>
      (x.compareTo(y) == 0) == x.equals(y)
  }

}
