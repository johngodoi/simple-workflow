package simple.workflow.components

import com.thoughtworks.xstream.annotations.XStreamAlias

trait Instruction {
  @XStreamAlias("job-tracker")
  var jobTracker:String=_
  @XStreamAlias("name-node")
  var nameNode:String=_
  def execute:Boolean
}
