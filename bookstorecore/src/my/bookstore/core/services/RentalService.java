package my.bookstore.core.services;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

import my.bookstore.core.model.RentalModel;


public interface RentalService
{
	List<RentalModel> getActiveRentalsForCustomer(CustomerModel customer);
}
