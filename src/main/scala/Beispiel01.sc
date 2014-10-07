import org.scalacheck.Prop._

val p0 = forAll {
  (a: Int, b: Int) => a + b == b + a
}
//p0.check
//
val p1 = forAll {
  (l1: List[Int], l2: List[Int]) =>
    (l1 ++ l2).length == l1.length + l2.length
}
//p1.check
