import org.scalacheck.Prop._

val p1 = forAll {
  (s: String, n: Int) =>
    val t = pbt.StringUtils.truncate(s, n)
    s.startsWith(t.dropRight(3))
}

p1.check
