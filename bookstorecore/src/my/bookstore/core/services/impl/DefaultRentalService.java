package my.bookstore.core.services.impl;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

import my.bookstore.core.daos.RentalDao;
import my.bookstore.core.model.RentalModel;
import my.bookstore.core.services.RentalService;


public class DefaultRentalService implements RentalService
{

	private RentalDao rentalDao;

	@Override
	public List<RentalModel> getActiveRentalsForCustomer(final CustomerModel customer)
	{
		// TODO exercise 6.3: add implementation
		return rentalDao.getActiveRentalsForCustomer(customer);
	}

	/**
	 * @param rentalDao
	 *           the rentalDao to set
	 */
	public void setRentalDao(final RentalDao rentalDao)
	{
		this.rentalDao = rentalDao;
	}



}
