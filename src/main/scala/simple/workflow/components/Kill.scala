package simple.workflow.components

import com.thoughtworks.xstream.annotations.XStreamAsAttribute

class Kill() {
  @XStreamAsAttribute
  var name:String=_
  var message:String=_
}
