
import de.hybris.platform.workflow.model.WorkflowDecisionTemplateModel;
import de.hybris.platform.workflow.model.WorkflowActionTemplateModel;
import java.util.List;
import de.hybris.platform.core.model.link.LinkModel;
import java.util.Collection;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

try{
    WorkflowActionTemplateModel pricing=workflowTemplateService.getWorkflowActionTemplateForCode("BookPricing");

    if(!"BookCreation".equals(pricing.getWorkflow().getCode())){
        addError('BookPricing workflow action template doesn\'t belong to BookCreation workflow template')
    }
    Collection<WorkflowDecisionTemplateModel> incomingTemplates=pricing.getIncomingTemplateDecisions();
    boolean incomingFound=false;
    for(WorkflowDecisionTemplateModel template:incomingTemplates){
        if("BookPricingRejected".equals(template.getCode()) && "BookApproval".equals(template.getActionTemplate().getCode())){
            incomingFound=true;
            break;
        }
    }
    if(!incomingFound){
        addError('BookPricingRejected is not properly defined!')
    }
  else{
  		addLog('BookPricingRejected....OK')
  }

    Collection<WorkflowDecisionTemplateModel> templates=pricing.getDecisionTemplates()
    boolean templateFound=false;
    for(WorkflowDecisionTemplateModel template:templates){
        if("BookPricingDone".equals(template.getCode()) && "BookPricing".equals(template.getActionTemplate().getCode())){
            templateFound=true;
            break;
        }
    }
    if(!templateFound){
        addError('BookPricingDone is not properly defined!')
    }
  else{
	  addLog('BookPricingDone....OK')
  }

}catch(de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException ex){
    addError('BookPricing workflow action template doesn\'t exist!')
}

printOutputLog()