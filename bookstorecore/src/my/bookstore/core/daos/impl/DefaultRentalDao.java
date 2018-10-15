package my.bookstore.core.daos.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import my.bookstore.core.daos.RentalDao;
import my.bookstore.core.model.BookModel;
import my.bookstore.core.model.RentalModel;


public class DefaultRentalDao extends AbstractItemDao implements RentalDao
{

	@Override
	public List<RentalModel> getActiveRentalsForCustomer(final CustomerModel customer)
	{
		//This could be done using GenericDao but for learning purposes we are using Flexiblesearch
		// TODO exercise 5.3 : write a Flexible Search query that finds all the active rentals of customer
        /*
		 In order to return the rentals for the customer that are active, but not expired, we
		 need to compare the start and end dates of the rental to today's date. However, if
		 we use a java.util.Date object, it will be precise to the millisecond, and that means
		 our FS can't benefit from query caching. To solve this, we want to truncate the date.
		 While we're at it, if a rental starts/ends today, we'll give the customer the benefit
		 of the rest of the day.
		 
		 You will notice that the query strings use static constants in the Model class to refer
		 to the property names. This ensures that any changes to the model in bookstorecore-items.xml
		 will cause a compilation error in when the current class (DefaultRentalDao) is compiled,
		 thereby alerting you to the problem.
		 
		 Unfortunately, it makes the query string harder to read. We have included a comment above
		 each query string showing the query after assembly.
		 */
		
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		final Date dayStart = cal.getTime();
		cal.add(Calendar.DATE, 1);
		final Date dayEnd = cal.getTime();
		
		/* This is what the select statement will look like once assembled.
		final String queryString = "SELECT {rental.pk}"
				+ " FROM {Rental as rental}" 
				+ " WHERE {rental.startDate} <= ?tomorrow" 
				+ " and {rental.endDate} >= ?today" 
				+ " and {rental.customer} = ?customer";
		*/

		final String queryString = "SELECT {rental.pk}" 
                + " FROM {" + RentalModel._TYPECODE + " as rental}" 
                + " WHERE {rental." + RentalModel.STARTDATE + "} <= ?tomorrow" 
                + " and {rental." + RentalModel.ENDDATE + "} >= ?today" 
                + " and {rental." + RentalModel.CUSTOMER + "} = ?customer";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("tomorrow", dayEnd);
		query.addQueryParameter("today", dayStart);
		query.addQueryParameter("customer", customer.getPk());
		return getFlexibleSearchService().<RentalModel> search(query).getResult();
	}

	@Override
	public List<BookModel> getMostRentedBooks(final int numberOfBooks)
	{
		// TODO exercise 5.5: finish query and set query parameters. The query should find top <code>numberOfBooks</code> 
		/* This is what the select statement will look like once assembled.
		final String queryString = "SELECT pk" 
                + " FROM ({{SELECT COUNT(*) as num, {Book.pk} as pk"
                + " FROM {Rental JOIN Book ON {Rental.product} = {Book.pk}}" 
                + " GROUP BY {Rental.product}, {Book.pk}"
                + " ORDER BY num DESC LIMIT ?limit}})";
		*/
		
		final String queryString = "SELECT pk"
                + " FROM ({{SELECT COUNT(*) AS num, {Book." + BookModel.PK + "} AS pk" 
                + " FROM {" + RentalModel._TYPECODE + " JOIN " + BookModel._TYPECODE 
                + " ON {Rental." + RentalModel.PRODUCT + "}={Book." + BookModel.PK + "}}" 
                + " GROUP BY {Rental." + RentalModel.PRODUCT + "}, {Book." + BookModel.PK + "}" 
                + " ORDER BY num DESC LIMIT ?limit}})";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("limit", numberOfBooks);
		final SearchResult<BookModel> books = getFlexibleSearchService().search(query);
		return books.getResult();
	}

}
