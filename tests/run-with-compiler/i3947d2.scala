
import scala.quoted._

object Test {

  def main(args: Array[String]): Unit = {
    implicit val toolbox: scala.quoted.Toolbox = scala.quoted.Toolbox.make(getClass.getClassLoader)
    def test[T: Type](clazz: java.lang.Class[T]): Unit = run {
      val lclazz = clazz.toExpr
      val name = '{ ($lclazz).getCanonicalName }
      println()
      println(name.show)
      '{ println($name) }
    }

    test(classOf[foo.Foo])
    test(classOf[foo.Foo#Bar])
    test(classOf[foo.Foo.Baz])
  }

}

package foo {
  class Foo {
    class Bar
  }
  object Foo {
    class Baz
  }
}
