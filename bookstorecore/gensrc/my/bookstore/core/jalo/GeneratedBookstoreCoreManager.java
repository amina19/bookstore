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
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.security.Principal;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.OneToManyHandler;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import my.bookstore.core.constants.BookstoreCoreConstants;
import my.bookstore.core.jalo.ApparelProduct;
import my.bookstore.core.jalo.ApparelSizeVariantProduct;
import my.bookstore.core.jalo.ApparelStyleVariantProduct;
import my.bookstore.core.jalo.Book;
import my.bookstore.core.jalo.ElectronicsColorVariantProduct;
import my.bookstore.core.jalo.Rental;
import my.bookstore.core.jalo.RewardStatusLevelConfiguration;

/**
 * Generated class for type <code>BookstoreCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedBookstoreCoreManager extends Extension
{
	/**
	* {@link OneToManyHandler} for handling 1:n RENTALS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<Rental> RENTAL2PRODUCTRELATIONRENTALSHANDLER = new OneToManyHandler<Rental>(
	BookstoreCoreConstants.TC.RENTAL,
	false,
	"product",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	/**
	* {@link OneToManyHandler} for handling 1:n RENTALS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<Rental> RENTAL2CUSTOMERRELATIONRENTALSHANDLER = new OneToManyHandler<Rental>(
	BookstoreCoreConstants.TC.RENTAL,
	false,
	"customer",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	/** Relation ordering override parameter constants for Book2AuthorRelation from ((bookstorecore))*/
	protected static String BOOK2AUTHORRELATION_SRC_ORDERED = "relation.Book2AuthorRelation.source.ordered";
	protected static String BOOK2AUTHORRELATION_TGT_ORDERED = "relation.Book2AuthorRelation.target.ordered";
	/** Relation disable markmodifed parameter constants for Book2AuthorRelation from ((bookstorecore))*/
	protected static String BOOK2AUTHORRELATION_MARKMODIFIED = "relation.Book2AuthorRelation.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("language", AttributeMode.INITIAL);
		tmp.put("ISBN10", AttributeMode.INITIAL);
		tmp.put("ISBN13", AttributeMode.INITIAL);
		tmp.put("publisher", AttributeMode.INITIAL);
		tmp.put("publishedDate", AttributeMode.INITIAL);
		tmp.put("rentable", AttributeMode.INITIAL);
		tmp.put("rewardPoints", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("points", AttributeMode.INITIAL);
		tmp.put("rewardLevelStartDate", AttributeMode.INITIAL);
		tmp.put("expireDate", AttributeMode.INITIAL);
		tmp.put("rewardStatusLevel", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.books</code> attribute.
	 * @return the books
	 */
	public Collection<Book> getBooks(final SessionContext ctx, final User item)
	{
		final List<Book> items = item.getLinkedItems( 
			ctx,
			false,
			BookstoreCoreConstants.Relations.BOOK2AUTHORRELATION,
			"Book",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.books</code> attribute.
	 * @return the books
	 */
	public Collection<Book> getBooks(final User item)
	{
		return getBooks( getSession().getSessionContext(), item );
	}
	
	public long getBooksCount(final SessionContext ctx, final User item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			BookstoreCoreConstants.Relations.BOOK2AUTHORRELATION,
			"Book",
			null
		);
	}
	
	public long getBooksCount(final User item)
	{
		return getBooksCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.books</code> attribute. 
	 * @param value the books
	 */
	public void setBooks(final SessionContext ctx, final User item, final Collection<Book> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			BookstoreCoreConstants.Relations.BOOK2AUTHORRELATION,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(BOOK2AUTHORRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.books</code> attribute. 
	 * @param value the books
	 */
	public void setBooks(final User item, final Collection<Book> value)
	{
		setBooks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to books. 
	 * @param value the item to add to books
	 */
	public void addToBooks(final SessionContext ctx, final User item, final Book value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			BookstoreCoreConstants.Relations.BOOK2AUTHORRELATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(BOOK2AUTHORRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to books. 
	 * @param value the item to add to books
	 */
	public void addToBooks(final User item, final Book value)
	{
		addToBooks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from books. 
	 * @param value the item to remove from books
	 */
	public void removeFromBooks(final SessionContext ctx, final User item, final Book value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			BookstoreCoreConstants.Relations.BOOK2AUTHORRELATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(BOOK2AUTHORRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from books. 
	 * @param value the item to remove from books
	 */
	public void removeFromBooks(final User item, final Book value)
	{
		removeFromBooks( getSession().getSessionContext(), item, value );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Book createBook(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.BOOK );
			return (Book)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Book : "+e.getMessage(), 0 );
		}
	}
	
	public Book createBook(final Map attributeValues)
	{
		return createBook( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Rental createRental(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.RENTAL );
			return (Rental)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Rental : "+e.getMessage(), 0 );
		}
	}
	
	public Rental createRental(final Map attributeValues)
	{
		return createRental( getSession().getSessionContext(), attributeValues );
	}
	
	public RewardStatusLevelConfiguration createRewardStatusLevelConfiguration(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BookstoreCoreConstants.TC.REWARDSTATUSLEVELCONFIGURATION );
			return (RewardStatusLevelConfiguration)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating RewardStatusLevelConfiguration : "+e.getMessage(), 0 );
		}
	}
	
	public RewardStatusLevelConfiguration createRewardStatusLevelConfiguration(final Map attributeValues)
	{
		return createRewardStatusLevelConfiguration( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.expireDate</code> attribute.
	 * @return the expireDate - Date when user account will expire
	 */
	public Date getExpireDate(final SessionContext ctx, final Customer item)
	{
		return (Date)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Customer.EXPIREDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.expireDate</code> attribute.
	 * @return the expireDate - Date when user account will expire
	 */
	public Date getExpireDate(final Customer item)
	{
		return getExpireDate( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.expireDate</code> attribute. 
	 * @param value the expireDate - Date when user account will expire
	 */
	public void setExpireDate(final SessionContext ctx, final Customer item, final Date value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Customer.EXPIREDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.expireDate</code> attribute. 
	 * @param value the expireDate - Date when user account will expire
	 */
	public void setExpireDate(final Customer item, final Date value)
	{
		setExpireDate( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return BookstoreCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ISBN10</code> attribute.
	 * @return the ISBN10 - International Standard Book Number with 10 digits
	 */
	public String getISBN10(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.ISBN10);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ISBN10</code> attribute.
	 * @return the ISBN10 - International Standard Book Number with 10 digits
	 */
	public String getISBN10(final Product item)
	{
		return getISBN10( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ISBN10</code> attribute. 
	 * @param value the ISBN10 - International Standard Book Number with 10 digits
	 */
	public void setISBN10(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.ISBN10,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ISBN10</code> attribute. 
	 * @param value the ISBN10 - International Standard Book Number with 10 digits
	 */
	public void setISBN10(final Product item, final String value)
	{
		setISBN10( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ISBN13</code> attribute.
	 * @return the ISBN13 - International Standard Book Number with 13 digits
	 */
	public String getISBN13(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.ISBN13);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ISBN13</code> attribute.
	 * @return the ISBN13 - International Standard Book Number with 13 digits
	 */
	public String getISBN13(final Product item)
	{
		return getISBN13( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ISBN13</code> attribute. 
	 * @param value the ISBN13 - International Standard Book Number with 13 digits
	 */
	public void setISBN13(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.ISBN13,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ISBN13</code> attribute. 
	 * @param value the ISBN13 - International Standard Book Number with 13 digits
	 */
	public void setISBN13(final Product item, final String value)
	{
		setISBN13( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.language</code> attribute.
	 * @return the language - Language
	 */
	public String getLanguage(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.language</code> attribute.
	 * @return the language - Language
	 */
	public String getLanguage(final Product item)
	{
		return getLanguage( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.language</code> attribute. 
	 * @param value the language - Language
	 */
	public void setLanguage(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.LANGUAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.language</code> attribute. 
	 * @param value the language - Language
	 */
	public void setLanguage(final Product item, final String value)
	{
		setLanguage( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.points</code> attribute.
	 * @return the points - Number of collected points
	 */
	public Integer getPoints(final SessionContext ctx, final Customer item)
	{
		return (Integer)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Customer.POINTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.points</code> attribute.
	 * @return the points - Number of collected points
	 */
	public Integer getPoints(final Customer item)
	{
		return getPoints( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.points</code> attribute. 
	 * @return the points - Number of collected points
	 */
	public int getPointsAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Integer value = getPoints( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.points</code> attribute. 
	 * @return the points - Number of collected points
	 */
	public int getPointsAsPrimitive(final Customer item)
	{
		return getPointsAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.points</code> attribute. 
	 * @param value the points - Number of collected points
	 */
	public void setPoints(final SessionContext ctx, final Customer item, final Integer value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Customer.POINTS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.points</code> attribute. 
	 * @param value the points - Number of collected points
	 */
	public void setPoints(final Customer item, final Integer value)
	{
		setPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.points</code> attribute. 
	 * @param value the points - Number of collected points
	 */
	public void setPoints(final SessionContext ctx, final Customer item, final int value)
	{
		setPoints( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.points</code> attribute. 
	 * @param value the points - Number of collected points
	 */
	public void setPoints(final Customer item, final int value)
	{
		setPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.publishedDate</code> attribute.
	 * @return the publishedDate - Publisher of the book/magazine/newspaper
	 */
	public Date getPublishedDate(final SessionContext ctx, final Product item)
	{
		return (Date)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.PUBLISHEDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.publishedDate</code> attribute.
	 * @return the publishedDate - Publisher of the book/magazine/newspaper
	 */
	public Date getPublishedDate(final Product item)
	{
		return getPublishedDate( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.publishedDate</code> attribute. 
	 * @param value the publishedDate - Publisher of the book/magazine/newspaper
	 */
	public void setPublishedDate(final SessionContext ctx, final Product item, final Date value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.PUBLISHEDDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.publishedDate</code> attribute. 
	 * @param value the publishedDate - Publisher of the book/magazine/newspaper
	 */
	public void setPublishedDate(final Product item, final Date value)
	{
		setPublishedDate( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.publisher</code> attribute.
	 * @return the publisher - Publisher of the book/magazine/newspaper
	 */
	public String getPublisher(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.PUBLISHER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.publisher</code> attribute.
	 * @return the publisher - Publisher of the book/magazine/newspaper
	 */
	public String getPublisher(final Product item)
	{
		return getPublisher( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.publisher</code> attribute. 
	 * @param value the publisher - Publisher of the book/magazine/newspaper
	 */
	public void setPublisher(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.PUBLISHER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.publisher</code> attribute. 
	 * @param value the publisher - Publisher of the book/magazine/newspaper
	 */
	public void setPublisher(final Product item, final String value)
	{
		setPublisher( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rentable</code> attribute.
	 * @return the rentable - Check if the product is rentable
	 */
	public Boolean isRentable(final SessionContext ctx, final Product item)
	{
		return (Boolean)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.RENTABLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rentable</code> attribute.
	 * @return the rentable - Check if the product is rentable
	 */
	public Boolean isRentable(final Product item)
	{
		return isRentable( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rentable</code> attribute. 
	 * @return the rentable - Check if the product is rentable
	 */
	public boolean isRentableAsPrimitive(final SessionContext ctx, final Product item)
	{
		Boolean value = isRentable( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rentable</code> attribute. 
	 * @return the rentable - Check if the product is rentable
	 */
	public boolean isRentableAsPrimitive(final Product item)
	{
		return isRentableAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rentable</code> attribute. 
	 * @param value the rentable - Check if the product is rentable
	 */
	public void setRentable(final SessionContext ctx, final Product item, final Boolean value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.RENTABLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rentable</code> attribute. 
	 * @param value the rentable - Check if the product is rentable
	 */
	public void setRentable(final Product item, final Boolean value)
	{
		setRentable( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rentable</code> attribute. 
	 * @param value the rentable - Check if the product is rentable
	 */
	public void setRentable(final SessionContext ctx, final Product item, final boolean value)
	{
		setRentable( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rentable</code> attribute. 
	 * @param value the rentable - Check if the product is rentable
	 */
	public void setRentable(final Product item, final boolean value)
	{
		setRentable( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rentals</code> attribute.
	 * @return the rentals
	 */
	public Collection<Rental> getRentals(final SessionContext ctx, final Product item)
	{
		return RENTAL2PRODUCTRELATIONRENTALSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rentals</code> attribute.
	 * @return the rentals
	 */
	public Collection<Rental> getRentals(final Product item)
	{
		return getRentals( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rentals</code> attribute. 
	 * @param value the rentals
	 */
	public void setRentals(final SessionContext ctx, final Product item, final Collection<Rental> value)
	{
		RENTAL2PRODUCTRELATIONRENTALSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rentals</code> attribute. 
	 * @param value the rentals
	 */
	public void setRentals(final Product item, final Collection<Rental> value)
	{
		setRentals( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to rentals. 
	 * @param value the item to add to rentals
	 */
	public void addToRentals(final SessionContext ctx, final Product item, final Rental value)
	{
		RENTAL2PRODUCTRELATIONRENTALSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to rentals. 
	 * @param value the item to add to rentals
	 */
	public void addToRentals(final Product item, final Rental value)
	{
		addToRentals( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from rentals. 
	 * @param value the item to remove from rentals
	 */
	public void removeFromRentals(final SessionContext ctx, final Product item, final Rental value)
	{
		RENTAL2PRODUCTRELATIONRENTALSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from rentals. 
	 * @param value the item to remove from rentals
	 */
	public void removeFromRentals(final Product item, final Rental value)
	{
		removeFromRentals( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.rentals</code> attribute.
	 * @return the rentals
	 */
	public Collection<Rental> getRentals(final SessionContext ctx, final Customer item)
	{
		return RENTAL2CUSTOMERRELATIONRENTALSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.rentals</code> attribute.
	 * @return the rentals
	 */
	public Collection<Rental> getRentals(final Customer item)
	{
		return getRentals( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.rentals</code> attribute. 
	 * @param value the rentals
	 */
	public void setRentals(final SessionContext ctx, final Customer item, final Collection<Rental> value)
	{
		RENTAL2CUSTOMERRELATIONRENTALSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.rentals</code> attribute. 
	 * @param value the rentals
	 */
	public void setRentals(final Customer item, final Collection<Rental> value)
	{
		setRentals( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to rentals. 
	 * @param value the item to add to rentals
	 */
	public void addToRentals(final SessionContext ctx, final Customer item, final Rental value)
	{
		RENTAL2CUSTOMERRELATIONRENTALSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to rentals. 
	 * @param value the item to add to rentals
	 */
	public void addToRentals(final Customer item, final Rental value)
	{
		addToRentals( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from rentals. 
	 * @param value the item to remove from rentals
	 */
	public void removeFromRentals(final SessionContext ctx, final Customer item, final Rental value)
	{
		RENTAL2CUSTOMERRELATIONRENTALSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from rentals. 
	 * @param value the item to remove from rentals
	 */
	public void removeFromRentals(final Customer item, final Rental value)
	{
		removeFromRentals( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.rewardLevelStartDate</code> attribute.
	 * @return the rewardLevelStartDate
	 */
	public Date getRewardLevelStartDate(final SessionContext ctx, final Customer item)
	{
		return (Date)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Customer.REWARDLEVELSTARTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.rewardLevelStartDate</code> attribute.
	 * @return the rewardLevelStartDate
	 */
	public Date getRewardLevelStartDate(final Customer item)
	{
		return getRewardLevelStartDate( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.rewardLevelStartDate</code> attribute. 
	 * @param value the rewardLevelStartDate
	 */
	public void setRewardLevelStartDate(final SessionContext ctx, final Customer item, final Date value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Customer.REWARDLEVELSTARTDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.rewardLevelStartDate</code> attribute. 
	 * @param value the rewardLevelStartDate
	 */
	public void setRewardLevelStartDate(final Customer item, final Date value)
	{
		setRewardLevelStartDate( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rewardPoints</code> attribute.
	 * @return the rewardPoints - Number of points that every product brings
	 */
	public Integer getRewardPoints(final SessionContext ctx, final Product item)
	{
		return (Integer)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Product.REWARDPOINTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rewardPoints</code> attribute.
	 * @return the rewardPoints - Number of points that every product brings
	 */
	public Integer getRewardPoints(final Product item)
	{
		return getRewardPoints( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rewardPoints</code> attribute. 
	 * @return the rewardPoints - Number of points that every product brings
	 */
	public int getRewardPointsAsPrimitive(final SessionContext ctx, final Product item)
	{
		Integer value = getRewardPoints( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.rewardPoints</code> attribute. 
	 * @return the rewardPoints - Number of points that every product brings
	 */
	public int getRewardPointsAsPrimitive(final Product item)
	{
		return getRewardPointsAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rewardPoints</code> attribute. 
	 * @param value the rewardPoints - Number of points that every product brings
	 */
	public void setRewardPoints(final SessionContext ctx, final Product item, final Integer value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Product.REWARDPOINTS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rewardPoints</code> attribute. 
	 * @param value the rewardPoints - Number of points that every product brings
	 */
	public void setRewardPoints(final Product item, final Integer value)
	{
		setRewardPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rewardPoints</code> attribute. 
	 * @param value the rewardPoints - Number of points that every product brings
	 */
	public void setRewardPoints(final SessionContext ctx, final Product item, final int value)
	{
		setRewardPoints( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.rewardPoints</code> attribute. 
	 * @param value the rewardPoints - Number of points that every product brings
	 */
	public void setRewardPoints(final Product item, final int value)
	{
		setRewardPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.rewardStatusLevel</code> attribute.
	 * @return the rewardStatusLevel - Status level for user
	 */
	public EnumerationValue getRewardStatusLevel(final SessionContext ctx, final Customer item)
	{
		return (EnumerationValue)item.getProperty( ctx, BookstoreCoreConstants.Attributes.Customer.REWARDSTATUSLEVEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.rewardStatusLevel</code> attribute.
	 * @return the rewardStatusLevel - Status level for user
	 */
	public EnumerationValue getRewardStatusLevel(final Customer item)
	{
		return getRewardStatusLevel( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.rewardStatusLevel</code> attribute. 
	 * @param value the rewardStatusLevel - Status level for user
	 */
	public void setRewardStatusLevel(final SessionContext ctx, final Customer item, final EnumerationValue value)
	{
		item.setProperty(ctx, BookstoreCoreConstants.Attributes.Customer.REWARDSTATUSLEVEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.rewardStatusLevel</code> attribute. 
	 * @param value the rewardStatusLevel - Status level for user
	 */
	public void setRewardStatusLevel(final Customer item, final EnumerationValue value)
	{
		setRewardStatusLevel( getSession().getSessionContext(), item, value );
	}
	
}
