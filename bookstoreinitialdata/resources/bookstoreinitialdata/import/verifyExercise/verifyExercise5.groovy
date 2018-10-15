import my.bookstore.core.model.BookModel;
import java.util.HashMap;
import my.bookstore.core.enums.RewardStatusLevel;
import java.util.Map;
import de.hybris.platform.core.model.user.CustomerModel;
import my.bookstore.core.model.RentalModel;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

List<CustomerModel> customers;
try{
    final Map<String, RewardStatusLevel> params = new HashMap<String, RewardStatusLevel>();
    params.put(CustomerModel.REWARDSTATUSLEVEL, RewardStatusLevel.BLUE);
    customers=customerDao.find(params);
	addLog('customerDao and method find(params)   .....OK')
}catch(groovy.lang.MissingPropertyException e){
	addError('customerDao is not defined!')
}catch(groovy.lang.MissingMethodException e){
    addError('Method find(param) doesnt exist! Check if you defined customerDao properly!')
}

try{
    List<BookModel>books= rentalDao.getMostRentedBooks(5);
    addLog('rentalDao and method getMostRentedBooks(int)   .....OK')
    if(books==null || books.size()==0)
    	addError('Check if your rentals were imported!')
}catch(groovy.lang.MissingPropertyException e){
    addError('rentalDao is not defined!')
}catch(groovy.lang.MissingMethodException e){
    addError('Method getMostRentedBooks(int) doesnt exist! Check if you defined rentalDao properly!')
}catch(de.hybris.platform.servicelayer.search.exceptions.FlexibleSearchException e){
    addError('There is error in your flexible search query in method: rentalDao.getMostRentedBooks(int)!')
    addError(e)
}

if(customers==null || customers.size()==0){
  addError('Couldnt find customer. Cannot test rentalDao.getActiveRentalsForCustomer(customer) method')
}
else{
try{
    List<RentalModel>rentals= rentalDao.getActiveRentalsForCustomer(customers.get(0));
    addLog('rentalDao and method getActiveRentalsForCustomer(customer)   .....OK')
    if(rentals==null || rentals.size()==0)
    addError('Couldnt find active rentals. Check if your rentals were imported and if your flexible query is correct!')
}catch(groovy.lang.MissingPropertyException e){
    addError('rentalDao is not defined!')
}catch(groovy.lang.MissingMethodException e){
    addError('Method getActiveRentalsForCustomer(customer) doesnt exist! Check if you defined rentalDao properly!')
}catch(de.hybris.platform.servicelayer.search.exceptions.FlexibleSearchException e){
    addError('There is error in your flexible search query in method: rentalDao.getActiveRentalsForCustomer(customer)!')
    addError(e)
}
}

printOutputLog()
