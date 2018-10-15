import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.catalog.enums.ClassificationAttributeTypeEnum;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

def checkCategories(code, subCatList){
    try{
    	def categoryModels=categoryService.getCategoriesForCode(code);
    	if(categoryModels?.size() > 0){
        	def categoryModel=categoryModels[0] 
        	def userDefinedSubCatModel=[]

            categoryModel.getAllSubcategories().each{catModel ->
                userDefinedSubCatModel.add(catModel.getCode())
            }

       	 	subCatList.each{
            	if(userDefinedSubCatModel.contains(it)){
                	addLog("OK: ${it}")
            	}else{
                	addError("NOT OK: ${it}")
            	}
       	 	}
        }
  
    }catch(UnknownIdentifierException ex){
        addError("Error in verifying ${code}. Make sure this category exists or being created.")
    }
}


def checkClassificationCategories(classCatCode, features){
   
    try{
        def categoryModel=categoryService.getCategoryForCode(classCatCode)
        def classModelSet=defaultClassificationClassesResolverStrategy.resolve(categoryModel)
        def attr=defaultClassificationClassesResolverStrategy.getAllClassAttributeAssignments(classModelSet)
        addLog("Classification Category: $classCatCode.........OK")
        addLog("checking Category features for: $classCatCode")
            
        def createdFeatures=[:]
 
        attr.each{
            createdFeatures.put(it.getClassificationAttribute().getCode(), it.getAttributeType())
        }

        features.keySet.each{ feature ->

            if(createdFeatures.containsKey(feature)){
                if(createdFeatures.get(feature)==features.get(feature)){
                    addLog("Category feature: $feature...........OK")
                }else{
                    addError("Category feature: $feature is wrong type. It should be: ${features.get(feature)}")
                }
            }else {
                addError("Missing Category feature: $feature for category classification: $classCatCode")
            }
           
        }
		
    }catch(UnknownIdentifierException ex){
        addError("Error in verifying $classCatCode. Make sure this classification category exists or being created.")
    }
    
}


def digCatFeatures=
    ["DRM":ClassificationAttributeTypeEnum.STRING,
     "filesize":ClassificationAttributeTypeEnum.NUMBER,
     "deliveryFormat":ClassificationAttributeTypeEnum.ENUM]
checkClassificationCategories('digitalclassification',digCatFeatures)

def dimCatFeatures=["pages":ClassificationAttributeTypeEnum.NUMBER]
checkClassificationCategories('dimensionclassification',dimCatFeatures)

def audioCatFeatures=["length":ClassificationAttributeTypeEnum.STRING]
checkClassificationCategories('audioclassification',audioCatFeatures)

def digitalclassificationCat=["kindle"]
checkCategories('digitalclassification',digitalclassificationCat)

def dimensionclassificationCat=['paperback','hardcover']
checkCategories('dimensionclassification',dimensionclassificationCat)

def audioclassificationCat=['audioCD']
checkCategories('audioclassification',audioclassificationCat)

def fictionSubCat=['drama','crime','fantasy','horror','mystery','romance',
    'sciencefiction','thriller','comedy']
checkCategories('fiction',fictionSubCat)

def nonFictionSubCat=['computerscience','autobiography','dictionary','encyclopedia',
    'history','philosophy','self-help']
checkCategories('non-fiction',nonFictionSubCat)
				 
				 
printOutputLog()