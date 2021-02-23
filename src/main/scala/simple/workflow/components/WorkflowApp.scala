package simple.workflow.components

import java.util

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.annotations.XStreamImplicit
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider
class WorkflowApp {
  @XStreamImplicit(keyFieldName = "name")
  val actions = new util.HashMap[String,Action]()
  var start = new Start()
  var end = new Ending()
  var kill = new Kill()

  def process() = {
    println(this)
    var currentState = start.to
    while (!List(end.name,kill.name).contains(currentState)) {
      val currentAction = actions.get(currentState)
      val result = selectInstruction(currentAction).execute
      if (result) {
        currentState = currentAction.ok.to
      } else {
        currentState = currentAction.error.to
      }
    }
    if(currentState==kill.name){
      println(kill.message)
    }
  }

  private def selectInstruction(currentAction: Action) = {
    List(currentAction.spark, currentAction.java, currentAction.shell).filter(e => e != null)(0)
  }

  override def toString: String = (new XStream(new PureJavaReflectionProvider())).toXML(this)

}
