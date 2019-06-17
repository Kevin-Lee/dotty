import scala.quoted._
object Test {
  def main(args: Array[String]): Unit = {
    def f[T](x: Expr[T])(implicit t: Type[T]) = '{
      val z: $t = $x
    }
    implicit val toolbox: scala.quoted.Toolbox = scala.quoted.Toolbox.make(getClass.getClassLoader)
    println(show(f('{2})(Type.IntTag)))
  }
}
