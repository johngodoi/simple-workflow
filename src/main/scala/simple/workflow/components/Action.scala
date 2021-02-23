package simple.workflow.components

import simple.workflow.components.instructions.{JavaInstruction, ShellInstruction, SparkInstruction}
import com.thoughtworks.xstream.annotations.{XStreamAlias, XStreamAsAttribute}

class Action {
  @XStreamAlias("spark")
  var spark:SparkInstruction = _
  @XStreamAlias("java")
  var java:JavaInstruction = _
  @XStreamAlias("shell")
  var shell:ShellInstruction=_
  @XStreamAsAttribute
  var name:String = _
  var ok:OK=_
  var error:Error=_
}
