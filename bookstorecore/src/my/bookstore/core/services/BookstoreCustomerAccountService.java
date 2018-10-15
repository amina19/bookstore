package my.bookstore.core.services;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

import my.bookstore.core.enums.RewardStatusLevel;


public interface BookstoreCustomerAccountService extends CustomerAccountService
{
	void updateRewardStatusLevel(CustomerModel customer, OrderModel o);

	List<CustomerModel> getAllCustomersForLevel(final RewardStatusLevel level);
}
