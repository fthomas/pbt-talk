/*
Copied from http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html:

1. sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y

2. (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0

3. x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z
 
4. (x.compareTo(y)==0) == (x.equals(y))
*/

import scala.math.signum

import org.scalacheck._
import org.scalacheck.Prop._

class ComparableSpecV3[T <: Comparable[T]: Arbitrary] extends Properties("Comparable") {

  property("antisymmetry") = forAll {
    (x: T, y: T) =>
      signum(x.compareTo(y)) == -signum(y.compareTo(x))
  }

  property("transitivity v1") = forAll {
    (x: T, y: T, z: T) =>
      (x.compareTo(y) > 0 && y.compareTo(z) > 0) ==> (x.compareTo(z) > 0)
  }

  property("transitivity v2") = forAll {
    (x: T, y: T, z: T) =>
      val precondition = x.compareTo(y) > 0 && y.compareTo(z) > 0
      classify(precondition, "fulfilled", "unfulfilled") {
        if (precondition) x.compareTo(z) > 0
        else true
      }
  }

  property("transitivity v3") = forAll {
    (x: T, y: T, z: T) =>
      val precondition1 = x.compareTo(y) > 0 && y.compareTo(z) > 0
      val precondition2 = x.compareTo(y) < 0 && y.compareTo(z) < 0

      classify(precondition1, "+cond1", "-cond1") {
        classify(precondition2, "+cond2", "-cond2") {
          if (precondition1) x.compareTo(z) > 0
          else if (precondition2) x.compareTo(z) < 0
          else true
        }
      }
  }

  property("transitivity 2") = forAll {
    (x: T, y: T, z: T) =>
      val precondition = x.compareTo(y) == 0
      classify(precondition, "fulfilled", "unfulfilled") {
        if (precondition) signum(x.compareTo(z)) == signum(y.compareTo(z))
        else true
      }
  }

  property("consistency with equals") = forAll {
    (x: T, y: T) =>
      classify(x.equals(y), "equal", "not-equal") {
        (x.compareTo(y) == 0) == x.equals(y)
      }
  }

  property("consistency with equals 2") = forAll {
    (x: T) =>
      (x.compareTo(x) == 0) ?= x.equals(x)
  }
}
