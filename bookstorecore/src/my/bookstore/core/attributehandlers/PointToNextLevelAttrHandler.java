package my.bookstore.core.attributehandlers;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.internal.dao.SortParameters;
import de.hybris.platform.servicelayer.internal.dao.SortParameters.SortOrder;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

import java.util.List;

import my.bookstore.core.model.RewardStatusLevelConfigurationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PointToNextLevelAttrHandler extends AbstractDynamicAttributeHandler<Integer, CustomerModel>
{
	@Autowired
	private DefaultGenericDao<RewardStatusLevelConfigurationModel> rewardStatusLevelConfigurationDao;

	@Override
	public Integer get(final CustomerModel model)
	{
		try
		{

			final SortParameters sortParam = new SortParameters();
			sortParam.addSortParameter("threshold", SortOrder.ASCENDING);
			final List<RewardStatusLevelConfigurationModel> allRewarStatusLevel = rewardStatusLevelConfigurationDao.find(sortParam);

			//now this should be sorted list
			for (final RewardStatusLevelConfigurationModel rewardStatusLevel : allRewarStatusLevel)
			{

				if (model.getPoints() != null && model.getPoints() < rewardStatusLevel.getThreshold())
				{
					return rewardStatusLevel.getThreshold() - model.getPoints();
				}
			}

		}
		catch (final IllegalStateException e)
		{
			//log error
		}
		return null;
	}


}
