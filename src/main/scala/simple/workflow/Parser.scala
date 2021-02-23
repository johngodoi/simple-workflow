package simple.workflow

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.annotations.XStreamOmitField
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider
import simple.workflow.components.instructions.SparkInstruction
import simple.workflow.components.{Action, WorkflowApp}

import scala.io.Source

class Parser(filename:String) {
  @XStreamOmitField
  var xStream = getXStream()

  def load(): WorkflowApp = {
    val confContent = Source.fromFile(filename).getLines().mkString("\n")
    val confObj = getXStream().fromXML(new String(confContent)).asInstanceOf[WorkflowApp]
    confObj
  }

  private def getXStream(): XStream = {
  if (xStream == null) {
  xStream = new XStream(new PureJavaReflectionProvider())
  xStream.alias("workflow-app", classOf[WorkflowApp])
  xStream.alias("action", classOf[Action])
  xStream.alias("spark", classOf[SparkInstruction])
  xStream.autodetectAnnotations(true)
}
  xStream
}
}
