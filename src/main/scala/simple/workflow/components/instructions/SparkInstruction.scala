package simple.workflow.components.instructions

import java.util

import simple.workflow.components.Instruction
import simple.workflow.processors.CommandLineExecutor
import com.thoughtworks.xstream.annotations.{XStreamAlias, XStreamImplicit}

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class SparkInstruction extends Instruction {
  @XStreamAlias("master")
  var master:String=_
  @XStreamAlias("mode")
  var mode:String=_
  @XStreamAlias("name")
  var name:String=_
  @XStreamAlias("class")
  var clazz:String=_
  @XStreamAlias("jar")
  var jar:String=_
  @XStreamAlias("spark-opts")
  var sparkOpts:String=_
  @XStreamImplicit(itemFieldName = "arg")
  var args=new util.ArrayList[String]()

  override def execute: Boolean = {
    val argList = List(
      notNull(" --class",clazz),
      notNull(" --master",master),
      " "+sparkOpts+" ",
      notNull(" --deploy-mode", mode),
      jar
    )
    try {
      CommandLineExecutor.execute("spark2-submit " + (argList ++ args.toList).mkString(" "), 1, List().asJava)
    } catch {
      case e:Exception => {
        println(e.printStackTrace())
        return false
      }
    }
    true
  }

  def notNull(param:String, arg:String) = if(clazz!=null) param+" "+arg else ""
}
