/*
Copied from http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html:

sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y

(x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0

x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z
 
(x.compareTo(y)==0) == (x.equals(y))
*/

import java.lang.Comparable
import scala.math.signum

trait ComparableSpec[T <: Comparable] extends Properties("Comparable") {
  
  property("x < y") = forAll {
    (x: T, y: T) => signum(x.compareTo(y)) == -signum(y.compareTo(x))
  }

  property("transitivity") = forAll {
    (x: T, y: T, z: T) =>
      (x.compareTo(y) > 0 && y.compareTo(z) > 0) ==> x.compareTo(z) > 0
  }

  property("x == y => (x < z) == (y < z)") = forAll {
    (x: T, y: T, z: T) =>
      (x.compareTo(y) == 0) ==> signum(x.compareTo(z)) == signum(y.compareTo(z))
  }

  property("natural ordering is consistent with equals") = forAll {
    (x: T, y: T) =>
      (x.compareTo(y) == 0) ==> x.equals(y)
  }
}
