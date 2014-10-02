import org.scalacheck.Prop._

val p1 = forAll {
  (x: Int, y: Int) =>
    val z = java.lang.Math.max(x, y)
    (z == x || z == y) && (z >= x && z >= y)
}

p1.check
