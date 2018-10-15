import my.bookstore.core.model.BookModel
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.validation.exceptions.ValidationViolationException;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

def checkISBN10Validation(){
    try{
        CatalogModel cm=catalogService.getCatalogForId('bookstoreProductCatalog');
        BookModel book=(BookModel)productService.getProductForCode(cm.getActiveCatalogVersion(),'8942944779')
        if(book==null)
        addError('Book with code:8942944779 is not found!')
        else{
            book.setISBN10('1234567890');
            modelService.save(book)
            addError('ISBN10 format validation not found!')
        }
    }catch(ModelSavingException ex){
             
        if(ValidationViolationException.class.equals(ex.getCause().getClass())){
            addLog('ISBN10 format validation found!')
        }else{
            addError('ISBN10 format validation not found!')
        }
    }
}

def checkISBN13Validation(){
    try{
        CatalogModel cm=catalogService.getCatalogForId('bookstoreProductCatalog');
        BookModel book=(BookModel)productService.getProductForCode(cm.getActiveCatalogVersion(),'8942944779')
        if(book==null)
        println 'Book with code:8942944779 is not found!'
        else{
			book.setISBN10('2234567890');
            book.setISBN13('1234567890');
            modelService.save(book)
            addError('ISBN13 format validation not found!')
        }
    }catch(ModelSavingException ex){
             
        if(ValidationViolationException.class.equals(ex.getCause().getClass())){
            addLog('ISBN13 format validation found!')
        }else{
            addError('ISBN13 format validation not found!')
        }
    }
}

checkISBN10Validation()
checkISBN13Validation()
	
printOutputLog()