package simple.workflow.components

import com.thoughtworks.xstream.annotations.XStreamAsAttribute

class Start() {
  @XStreamAsAttribute
  var to:String=_
}
