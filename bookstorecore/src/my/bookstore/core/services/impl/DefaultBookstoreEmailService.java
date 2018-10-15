package my.bookstore.core.services.impl;

import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;

import java.util.ArrayList;
import java.util.List;

import my.bookstore.core.model.BookModel;
import my.bookstore.core.services.BookstoreEmailService;
import de.hybris.platform.acceleratorservices.email.EmailService;

public class DefaultBookstoreEmailService implements BookstoreEmailService
{

	private EmailService emailService;
	private boolean sendEmails;
	private DefaultGenericDao<CustomerModel> customerDao;

	@Override
	public void sendMostRentedBooks(final List<BookModel> books)
	{
		//write in console
		System.out.println("Top rented books: ");
		for (final BookModel book : books)
		{
			System.out.println(book.getName());

		}
		if (isSendEmails())
		{
			sendEmails(books);
		}

		
	}

	private void sendEmails(final List<BookModel> books)
	{
		final EmailMessageModel emailMessage = new EmailMessageModel();
		final StringBuilder builder = new StringBuilder("Top rented books: ");
		for (final BookModel book : books)
		{
			builder.append(book.getName() + "\n");


		}
		emailMessage.setBody(builder.toString());
		emailMessage.setToAddresses(getCustomerEmailAddresses());
		emailMessage.setSubject("Bookstore top rented books");

		emailService.send(emailMessage);
	}

	private List<EmailAddressModel> getCustomerEmailAddresses()
	{
		final List<EmailAddressModel> addresses = new ArrayList<EmailAddressModel>();
		final List<CustomerModel> customers = customerDao.find();
		for (final CustomerModel customer : customers)
		{
			//avoid sending emails to not valid email addresses
			if (customer.getUid().contains("@"))
			{
				EmailAddressModel email = new EmailAddressModel();
				email.setEmailAddress(customer.getUid());
			}

		}

		return addresses;
	}

	/**
	 * @param emailService
	 *           the emailService to set
	 */
	public void setEmailService(final EmailService emailService)
	{
		this.emailService = emailService;
	}

	/**
	 * @return the sendEmails
	 */
	public boolean isSendEmails()
	{
		return sendEmails;
	}

	/**
	 * @param sendEmails
	 *           the sendEmails to set
	 */
	public void setSendEmails(final boolean sendEmails)
	{
		this.sendEmails = sendEmails;
	}

	/**
	 * @param customerDao the customerDao to set
	 */
	public void setCustomerDao(DefaultGenericDao<CustomerModel> customerDao)
	{
		this.customerDao = customerDao;
	}

}
