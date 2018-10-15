/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 8, 2017 12:11:18 PM                     ---
 * ----------------------------------------------------------------
 */
package my.bookstore.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import my.bookstore.core.constants.BookstoreCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem RewardStatusLevelConfiguration}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedRewardStatusLevelConfiguration extends GenericItem
{
	/** Qualifier of the <code>RewardStatusLevelConfiguration.configId</code> attribute **/
	public static final String CONFIGID = "configId";
	/** Qualifier of the <code>RewardStatusLevelConfiguration.threshold</code> attribute **/
	public static final String THRESHOLD = "threshold";
	/** Qualifier of the <code>RewardStatusLevelConfiguration.image</code> attribute **/
	public static final String IMAGE = "image";
	/** Qualifier of the <code>RewardStatusLevelConfiguration.rewardStatusLevel</code> attribute **/
	public static final String REWARDSTATUSLEVEL = "rewardStatusLevel";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CONFIGID, AttributeMode.INITIAL);
		tmp.put(THRESHOLD, AttributeMode.INITIAL);
		tmp.put(IMAGE, AttributeMode.INITIAL);
		tmp.put(REWARDSTATUSLEVEL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.configId</code> attribute.
	 * @return the configId
	 */
	public String getConfigId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONFIGID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.configId</code> attribute.
	 * @return the configId
	 */
	public String getConfigId()
	{
		return getConfigId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.configId</code> attribute. 
	 * @param value the configId
	 */
	public void setConfigId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONFIGID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.configId</code> attribute. 
	 * @param value the configId
	 */
	public void setConfigId(final String value)
	{
		setConfigId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.image</code> attribute.
	 * @return the image
	 */
	public Media getImage(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, IMAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.image</code> attribute.
	 * @return the image
	 */
	public Media getImage()
	{
		return getImage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.image</code> attribute. 
	 * @param value the image
	 */
	public void setImage(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, IMAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.image</code> attribute. 
	 * @param value the image
	 */
	public void setImage(final Media value)
	{
		setImage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.rewardStatusLevel</code> attribute.
	 * @return the rewardStatusLevel - Status level for user
	 */
	public EnumerationValue getRewardStatusLevel(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, REWARDSTATUSLEVEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.rewardStatusLevel</code> attribute.
	 * @return the rewardStatusLevel - Status level for user
	 */
	public EnumerationValue getRewardStatusLevel()
	{
		return getRewardStatusLevel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.rewardStatusLevel</code> attribute. 
	 * @param value the rewardStatusLevel - Status level for user
	 */
	public void setRewardStatusLevel(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, REWARDSTATUSLEVEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.rewardStatusLevel</code> attribute. 
	 * @param value the rewardStatusLevel - Status level for user
	 */
	public void setRewardStatusLevel(final EnumerationValue value)
	{
		setRewardStatusLevel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute.
	 * @return the threshold
	 */
	public Integer getThreshold(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, THRESHOLD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute.
	 * @return the threshold
	 */
	public Integer getThreshold()
	{
		return getThreshold( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute. 
	 * @return the threshold
	 */
	public int getThresholdAsPrimitive(final SessionContext ctx)
	{
		Integer value = getThreshold( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute. 
	 * @return the threshold
	 */
	public int getThresholdAsPrimitive()
	{
		return getThresholdAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute. 
	 * @param value the threshold
	 */
	public void setThreshold(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, THRESHOLD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute. 
	 * @param value the threshold
	 */
	public void setThreshold(final Integer value)
	{
		setThreshold( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute. 
	 * @param value the threshold
	 */
	public void setThreshold(final SessionContext ctx, final int value)
	{
		setThreshold( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RewardStatusLevelConfiguration.threshold</code> attribute. 
	 * @param value the threshold
	 */
	public void setThreshold(final int value)
	{
		setThreshold( getSession().getSessionContext(), value );
	}
	
}
