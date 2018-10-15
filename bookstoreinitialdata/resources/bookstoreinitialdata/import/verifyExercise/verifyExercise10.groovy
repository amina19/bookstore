import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

def checkLocalExtensionXml(String... extNames){
    def fis =null;
    try{
        def xpath = XPathFactory.newInstance().newXPath()
        def builder     = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        fis = new FileInputStream(new File(System.getProperty("HYBRIS_CONFIG_DIR"),"localextensions.xml"))	
        def localextensionsXml     = builder.parse(fis).documentElement
  	
        for(def extName:extNames){
            if('true'.equals(xpath.evaluate("/hybrisconfig/extensions/extension/@name=\'"+extName+"\'", localextensionsXml))  || xpath.evaluate("/hybrisconfig/extensions/extension[contains(@dir,'"+extName+"')]", localextensionsXml,XPathConstants.NODE)!=null){
                addLog("checking extension name ${extName} .....OK")
            }else{
                addError("Please add <extension name=\"${extName}\"/> in your localextensions.xml and restart the server)")
            }
        }
  	
    }finally{
        if(fis!=null)
        fis.close()
    }	
}
checkLocalExtensionXml("bookstorebackoffice")
	
printOutputLog()