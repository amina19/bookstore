import my.bookstore.core.model.BookModel
import de.hybris.platform.catalog.model.CatalogModel;
import java.util.Locale;
import de.hybris.platform.catalog.model.ProductFeatureModel;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

CatalogModel cm=catalogService.getCatalogForId('bookstoreProductCatalog');
if(cm==null)
addError('bookstoreProductCatalog catalog not found!')
else{
    BookModel book=(BookModel)productService.getProductForCode(cm.getActiveCatalogVersion(),'1013742419')
    if(book==null)
   		addError('Book with code:1013742419 is not found!')
    else{
    	addLog('Book with code:1013742419 found!')
        if(book.getISBN10()==null)
			addError('ISBN10 is missing!')
        if(book.getAuthors()==null)
			addError('Author(s) is/are missing!')
        if(book.getISBN13()==null)
			addError('ISBN13 is missing!')
        if(book.getRentable()==null)
			addError('Rentable is missing!')
        if(book.getName(Locale.ENGLISH)==null)
			addError('Name is missing!')
        if(book.getRewardPoints()==null)
			addError('RewardPoints are missing!')
    }
	List<ProductFeatureModel>features=book.getFeatures();
	if(features==null){
		addError('Book doesn\'t contain any features!')
	}
	def expectedFeatures = [
		'digitalclassification.drm',
		'digitalclassification.filesize',
		'digitalclassification.deliveryformat',
		'audioclassification.length'
	]
	def featuresList = []
	for (pfm in features){
		featuresList.add(pfm.getQualifier().substring(pfm.getQualifier().lastIndexOf('/')+1))
	}
	for (exFeature in expectedFeatures){
		if (!featuresList.contains(exFeature))
			addError("Feature ${exFeature} is missing!")
	}
	def setDif = featuresList.minus(expectedFeatures)
	if (setDif.size() > 0){
		for (feature in setDif)
			addError("Feature ${feature} is not supposed to be assigned to book!")
	}
}


printOutputLog()