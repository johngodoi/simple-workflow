package simple.workflow.processors

import java.util

import org.apache.commons.exec.{CommandLine, DefaultExecutor}

import scala.collection.JavaConversions._

object CommandLineExecutor {
  def execute(commandLine: String, expectedExit:Int=0, args:util.List[String]=new util.ArrayList[String]()) = {
    println(commandLine+" "+args.toList.mkString(" "))
    val cmdLine = CommandLine.parse(commandLine)
    args.toList.foreach(arg=>cmdLine.addArgument(arg))
    val executor = new DefaultExecutor
    executor.setExitValue(expectedExit)
    val exitValue = executor.execute(cmdLine)
  }
}
