/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 8, 2017 12:11:18 PM                     ---
 * ----------------------------------------------------------------
 */
package my.bookstore.core.constants;

/**
 * @deprecated use constants in Model classes instead
 */
@Deprecated
@SuppressWarnings({"unused","cast","PMD"})
public class GeneratedBookstoreCoreConstants
{
	public static final String EXTENSIONNAME = "bookstorecore";
	public static class TC
	{
		public static final String APPARELPRODUCT = "ApparelProduct".intern();
		public static final String APPARELSIZEVARIANTPRODUCT = "ApparelSizeVariantProduct".intern();
		public static final String APPARELSTYLEVARIANTPRODUCT = "ApparelStyleVariantProduct".intern();
		public static final String BOOK = "Book".intern();
		public static final String ELECTRONICSCOLORVARIANTPRODUCT = "ElectronicsColorVariantProduct".intern();
		public static final String RENTAL = "Rental".intern();
		public static final String REWARDSTATUSLEVEL = "RewardStatusLevel".intern();
		public static final String REWARDSTATUSLEVELCONFIGURATION = "RewardStatusLevelConfiguration".intern();
		public static final String SWATCHCOLORENUM = "SwatchColorEnum".intern();
	}
	public static class Attributes
	{
		public static class Customer
		{
			public static final String EXPIREDATE = "expireDate".intern();
			public static final String POINTS = "points".intern();
			public static final String POINTTONEXTLEVEL = "pointToNextLevel".intern();
			public static final String RENTALS = "rentals".intern();
			public static final String REWARDLEVELSTARTDATE = "rewardLevelStartDate".intern();
			public static final String REWARDSTATUSLEVEL = "rewardStatusLevel".intern();
		}
		public static class Product
		{
			public static final String ISBN10 = "ISBN10".intern();
			public static final String ISBN13 = "ISBN13".intern();
			public static final String LANGUAGE = "language".intern();
			public static final String PUBLISHEDDATE = "publishedDate".intern();
			public static final String PUBLISHER = "publisher".intern();
			public static final String RENTABLE = "rentable".intern();
			public static final String RENTALS = "rentals".intern();
			public static final String REWARDPOINTS = "rewardPoints".intern();
		}
		public static class User
		{
			public static final String BOOKS = "books".intern();
		}
	}
	public static class Enumerations
	{
		public static class RewardStatusLevel
		{
			public static final String BLUE = "BLUE".intern();
			public static final String SILVER = "SILVER".intern();
			public static final String GOLD = "GOLD".intern();
		}
		public static class SwatchColorEnum
		{
			public static final String BLACK = "BLACK".intern();
			public static final String BLUE = "BLUE".intern();
			public static final String BROWN = "BROWN".intern();
			public static final String GREEN = "GREEN".intern();
			public static final String GREY = "GREY".intern();
			public static final String ORANGE = "ORANGE".intern();
			public static final String PINK = "PINK".intern();
			public static final String PURPLE = "PURPLE".intern();
			public static final String RED = "RED".intern();
			public static final String SILVER = "SILVER".intern();
			public static final String WHITE = "WHITE".intern();
			public static final String YELLOW = "YELLOW".intern();
		}
	}
	public static class Relations
	{
		public static final String BOOK2AUTHORRELATION = "Book2AuthorRelation".intern();
		public static final String RENTAL2CUSTOMERRELATION = "Rental2CustomerRelation".intern();
		public static final String RENTAL2PRODUCTRELATION = "Rental2ProductRelation".intern();
	}
	
	protected GeneratedBookstoreCoreConstants()
	{
		// private constructor
	}
	
	
}
