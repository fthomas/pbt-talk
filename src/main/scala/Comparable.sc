/*
Copied from http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html:

sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y

(x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0

x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z
 
(x.compareTo(y)==0) == (x.equals(y))
*/

trait ComparableSpec[T <: java.lang.Comparable] extends Properties("Comparable") {

  property("") = forAll {
    (x: T, y: T) => 
  }

}
