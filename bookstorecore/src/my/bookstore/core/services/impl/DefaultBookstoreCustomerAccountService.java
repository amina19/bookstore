package my.bookstore.core.services.impl;

import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import my.bookstore.core.enums.RewardStatusLevel;
import my.bookstore.core.model.BookModel;
import my.bookstore.core.services.BookstoreCustomerAccountService;


public class DefaultBookstoreCustomerAccountService extends DefaultCustomerAccountService implements
		BookstoreCustomerAccountService
{

	private DefaultGenericDao<CustomerModel> customerDao;

	@Override
	public void updateRewardStatusLevel(final CustomerModel customer, final OrderModel order)
	{
		int total = 0; //represent total number of point that Customer will get for this order
		for (final AbstractOrderEntryModel entry : order.getEntries())
		{
			final Object product = entry.getProduct();
			if (product instanceof BookModel) {
				total += ((BookModel) product).getRewardPoints() * entry.getQuantity();
			}
		}
		// TODO exercise 6.2 : update customer points
		customer.setPoints(customer.getPoints() + total);
		getModelService().save(customer);
	}

	public List<CustomerModel> getAllCustomersForLevel(final RewardStatusLevel level)
	{
		// TODO exercise 6.2 : find customers using customerDao defined in exercise 5
		final Map<String, RewardStatusLevel> params = new HashMap<String, RewardStatusLevel>();
		params.put(CustomerModel.REWARDSTATUSLEVEL, level);
		return getCustomerDao().find(params);
	}


	/**
	 * @return the customerDao
	 */
	public DefaultGenericDao<CustomerModel> getCustomerDao()
	{
		return customerDao;
	}

	/**
	 * @param customerDao - the customerDao to set
	 */
	public void setCustomerDao(DefaultGenericDao<CustomerModel> customerDao)
	{
		this.customerDao = customerDao;
	}


}
