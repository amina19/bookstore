import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

try{
    CronJobModel cronJob=cronJobService.getCronJob("bookstoreEmailCronJob")
    if(cronJob!=null){
        JobModel job=cronJob.getJob();
        if(spring.getBean(job.getCode()).metaClass.pickMethod('perform',CronJobModel.class)==null){
            addError('Couldnt find method perform(CronJobModel) for cronJob bean:'+job.getCode())
        }else{
            addLog('Cron job found!')
        }
        if(cronJob.getTriggers()==null || cronJob.getTriggers().size()==0){
            addError('Couldnt find any triggers for cronJob: bookstoreEmailCronJob')
        }
    }
}catch(de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException e){
    addError('Couldnt find cronJob bookstoreEmailCronJob')
}catch(org.springframework.beans.factory.NoSuchBeanDefinitionException e){
    addError('Couldnt find cron job bean defined in *spring.xml file!')
}

printOutputLog()