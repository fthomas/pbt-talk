import org.scalacheck._
import org.scalacheck.Prop._

def isEven(i: Int) = i % 2 == 0
def isOdd(i: Int)  = i % 2 != 0

val evenGen = Gen.posNum[Int].filter(isEven)
val oddGen =  Gen.posNum[Int].filter(isOdd)

val p1 = forAll(evenGen, evenGen) {
  (e1: Int, e2: Int) => isEven(e1 + e2)
}

p1.check

val p2 = forAll(oddGen, oddGen) {
  (o1: Int, o2: Int) => isEven(o1 + o2)
}

p2.check

val p3 = forAll(evenGen, oddGen) {
  (e: Int, o: Int) => isOdd(e + o)
}

p3.check