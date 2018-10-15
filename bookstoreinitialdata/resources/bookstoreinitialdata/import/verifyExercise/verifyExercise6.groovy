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
    customers=bookstoreCustomerAccountService.getAllCustomersForLevel(RewardStatusLevel.BLUE);
    addLog('bookstoreCustomerAccountService and method getAllCustomersForLevel(RewardStatusLevel)   .....OK')
}catch(groovy.lang.MissingPropertyException e){
    addError('bookstoreCustomerAccountService is not defined!')
}catch(groovy.lang.MissingMethodException e){
    addError('Method getAllCustomersForLevel(RewardStatusLevel) doesnt exist! Check if you defined bookstoreCustomerAccountService properly!')
}


if(customers==null || customers.size()==0){
  addError('Couldnt find customer. Cannot test rentalDao.getActiveRentalsForCustomer(customer) method')
}
else{
try{
    List<RentalModel>rentals= rentalService.getActiveRentalsForCustomer(customers.get(0));
    addLog('rentalService and method getActiveRentalsForCustomer(customer)   .....OK')
    if(rentals==null || rentals.size()==0)
    addError('Couldnt find active rentals. Check if your rentals were imported and if your flexible query is correct!')
}catch(groovy.lang.MissingPropertyException e){
    addError('rentalService is not defined!')
}catch(groovy.lang.MissingMethodException e){
    addError('Method getActiveRentalsForCustomer(customer) doesnt exist! Check if you defined rentalService properly!')
}catch(de.hybris.platform.servicelayer.search.exceptions.FlexibleSearchException e){
    addError('There is error in your flexible search query in method: rentalService.getActiveRentalsForCustomer(customer)!')
    addError(e)
}
}

printOutputLog()

