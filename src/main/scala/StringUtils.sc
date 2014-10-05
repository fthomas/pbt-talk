import org.scalacheck.Prop._

// examples

val t1 = pbt.StringUtils.truncate("abc", 5)
assert(t1 == "abc")

val t2 = pbt.StringUtils.truncate("Hello World", 8)
assert(t2 == "Hello Wo...")

// property

val p0 = forAll {
  (s: String, n: Int) =>
    val t = pbt.StringUtils.truncate(s, n)
    t.dropRight(3).length <= s.length
}

p0.check
val p1 = forAll {
  (s: String, n: Int) =>
    val t = pbt.StringUtils.truncate(s, n)
    s.startsWith(t.dropRight(3))
}

p1.check
