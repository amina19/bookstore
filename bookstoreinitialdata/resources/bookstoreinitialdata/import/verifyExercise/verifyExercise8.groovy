import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.type.SearchRestrictionModel;
import java.util.ArrayList;
import java.util.Collection;

def script = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( '../../Logger.groovy' ) //for this to work, Logger.groovy should've already been put inside platform directory
}
this.metaClass.mixin script

final Collection<ComposedTypeModel> types = new ArrayList<ComposedTypeModel>();
final ComposedTypeModel composedTypeModel = typeService.getComposedTypeForClass(CustomerModel.class);
types.add(composedTypeModel);
final UserGroupModel groups = userService.getUserGroupForUID("blueManagerGroup");
def found=false;
final Collection<SearchRestrictionModel> foundRestrictions = searchRestrictionService.getActiveSearchRestrictions(
    groups, false, types);
for (final SearchRestrictionModel restriction : foundRestrictions)
{
    if("blueManagerRestriction".equalsIgnoreCase(restriction.getCode())) {
        found=true
        break
    }
}
if(found)
	addLog('blueManagerRestriction restriction found!')
else{
    addError('blueManagerRestriction not found!')
}


printOutputLog()