package my.bookstore.core.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.List;

import my.bookstore.core.daos.RentalDao;
import my.bookstore.core.model.BookModel;
import my.bookstore.core.services.BookstoreEmailService;


public class BookstoreEmailJob extends AbstractJobPerformable<CronJobModel> // TODO exercise 7.1 : extend appropriate class
{

	private BookstoreEmailService bookstoreEmailService;
	private RentalDao rentalDao;

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		// TODO exercise 7.1 : add implementation;
		//use rentalDao to get 5 most rented books;
		//use bookstoreEmailService to send emails;
		//return appropriate PerformResult;
		try
		{
			final List<BookModel> books = rentalDao.getMostRentedBooks(5);
			bookstoreEmailService.sendMostRentedBooks(books);
		}
		catch (final Exception ex)
		{
			return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);
		}
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	/**
	 * @param bookstoreEmailService
	 *           the bookstoreEmailService to set
	 */
	public void setBookstoreEmailService(final BookstoreEmailService bookstoreEmailService)
	{
		this.bookstoreEmailService = bookstoreEmailService;
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
