package simple.workflow.components.instructions

import org.scalatest.{FlatSpec, Matchers}
import simple.workflow.processors.CommandLineExecutor

import scala.collection.JavaConverters._

class CommandLineExecutorUnitTest extends FlatSpec with Matchers {
  "CommandLineExecutor" should "execute single command line without arguments" in {
    CommandLineExecutor.execute("cmd /c dir")
  }
  "CommandLineExecutor" should "execute single command line with arguments" in {
    CommandLineExecutor.execute("cmd /c dir",0,List("target").asJava)
  }
}
