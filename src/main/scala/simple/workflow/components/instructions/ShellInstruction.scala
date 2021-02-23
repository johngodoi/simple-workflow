package simple.workflow.components.instructions

import java.util

import simple.workflow.components.Instruction
import simple.workflow.processors.CommandLineExecutor
import com.thoughtworks.xstream.annotations.{XStreamAlias, XStreamImplicit}

class ShellInstruction extends Instruction {
  var exec:String=_
  @XStreamImplicit(itemFieldName = "argument")
  var arguments=new util.ArrayList[String]()
  @XStreamAlias("file")
  var file:String=_
  override def execute: Boolean = {
    CommandLineExecutor.execute(exec,args = arguments)
    true
  }

}
