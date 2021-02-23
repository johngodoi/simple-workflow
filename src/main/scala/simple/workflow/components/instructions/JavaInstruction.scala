package simple.workflow.components.instructions

import java.util

import simple.workflow.components.Instruction
import com.thoughtworks.xstream.annotations.{XStreamAlias, XStreamImplicit}

class JavaInstruction extends Instruction {
  @XStreamAlias("main-class")
  var clazz:String=_
  @XStreamAlias("file")
  var file:String=_
  @XStreamAlias("java-opts")
  var javaOpts:String=_
  @XStreamAlias("capture-output")
  var captureOutput:String=_
  @XStreamImplicit(itemFieldName = "arg")
  var args=new util.ArrayList[String]()
  override def execute: Boolean = ???
}
