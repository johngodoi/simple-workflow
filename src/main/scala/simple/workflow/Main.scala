package simple.workflow

import simple.workflow.components.WorkflowApp

object Main extends App {
  private val workflowApp: WorkflowApp = new Parser(args(0)).load()
  workflowApp.process()
}
