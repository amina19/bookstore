/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 8, 2017 12:11:18 PM                     ---
 * ----------------------------------------------------------------
 */
package my.bookstore.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import my.bookstore.core.constants.BookstoreCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Rental}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedRental extends GenericItem
{
	/** Qualifier of the <code>Rental.rentalId</code> attribute **/
	public static final String RENTALID = "rentalId";
	/** Qualifier of the <code>Rental.startDate</code> attribute **/
	public static final String STARTDATE = "startDate";
	/** Qualifier of the <code>Rental.endDate</code> attribute **/
	public static final String ENDDATE = "endDate";
	/** Qualifier of the <code>Rental.customer</code> attribute **/
	public static final String CUSTOMER = "customer";
	/** Qualifier of the <code>Rental.product</code> attribute **/
	public static final String PRODUCT = "product";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n CUSTOMER's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedRental> CUSTOMERHANDLER = new BidirectionalOneToManyHandler<GeneratedRental>(
	BookstoreCoreConstants.TC.RENTAL,
	false,
	"customer",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n PRODUCT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedRental> PRODUCTHANDLER = new BidirectionalOneToManyHandler<GeneratedRental>(
	BookstoreCoreConstants.TC.RENTAL,
	false,
	"product",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(RENTALID, AttributeMode.INITIAL);
		tmp.put(STARTDATE, AttributeMode.INITIAL);
		tmp.put(ENDDATE, AttributeMode.INITIAL);
		tmp.put(CUSTOMER, AttributeMode.INITIAL);
		tmp.put(PRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		CUSTOMERHANDLER.newInstance(ctx, allAttributes);
		PRODUCTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.customer</code> attribute.
	 * @return the customer
	 */
	public Customer getCustomer(final SessionContext ctx)
	{
		return (Customer)getProperty( ctx, CUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.customer</code> attribute.
	 * @return the customer
	 */
	public Customer getCustomer()
	{
		return getCustomer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.customer</code> attribute. 
	 * @param value the customer
	 */
	public void setCustomer(final SessionContext ctx, final Customer value)
	{
		CUSTOMERHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.customer</code> attribute. 
	 * @param value the customer
	 */
	public void setCustomer(final Customer value)
	{
		setCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.endDate</code> attribute.
	 * @return the endDate - end date of rental
	 */
	public Date getEndDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, ENDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.endDate</code> attribute.
	 * @return the endDate - end date of rental
	 */
	public Date getEndDate()
	{
		return getEndDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.endDate</code> attribute. 
	 * @param value the endDate - end date of rental
	 */
	public void setEndDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, ENDDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.endDate</code> attribute. 
	 * @param value the endDate - end date of rental
	 */
	public void setEndDate(final Date value)
	{
		setEndDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct(final SessionContext ctx)
	{
		return (Product)getProperty( ctx, PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct()
	{
		return getProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final SessionContext ctx, final Product value)
	{
		PRODUCTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final Product value)
	{
		setProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.rentalId</code> attribute.
	 * @return the rentalId - Unique identifier
	 */
	public Integer getRentalId(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, RENTALID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.rentalId</code> attribute.
	 * @return the rentalId - Unique identifier
	 */
	public Integer getRentalId()
	{
		return getRentalId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.rentalId</code> attribute. 
	 * @return the rentalId - Unique identifier
	 */
	public int getRentalIdAsPrimitive(final SessionContext ctx)
	{
		Integer value = getRentalId( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.rentalId</code> attribute. 
	 * @return the rentalId - Unique identifier
	 */
	public int getRentalIdAsPrimitive()
	{
		return getRentalIdAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.rentalId</code> attribute. 
	 * @param value the rentalId - Unique identifier
	 */
	public void setRentalId(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, RENTALID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.rentalId</code> attribute. 
	 * @param value the rentalId - Unique identifier
	 */
	public void setRentalId(final Integer value)
	{
		setRentalId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.rentalId</code> attribute. 
	 * @param value the rentalId - Unique identifier
	 */
	public void setRentalId(final SessionContext ctx, final int value)
	{
		setRentalId( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.rentalId</code> attribute. 
	 * @param value the rentalId - Unique identifier
	 */
	public void setRentalId(final int value)
	{
		setRentalId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.startDate</code> attribute.
	 * @return the startDate - start date of rental
	 */
	public Date getStartDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STARTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Rental.startDate</code> attribute.
	 * @return the startDate - start date of rental
	 */
	public Date getStartDate()
	{
		return getStartDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.startDate</code> attribute. 
	 * @param value the startDate - start date of rental
	 */
	public void setStartDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STARTDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Rental.startDate</code> attribute. 
	 * @param value the startDate - start date of rental
	 */
	public void setStartDate(final Date value)
	{
		setStartDate( getSession().getSessionContext(), value );
	}
	
}
