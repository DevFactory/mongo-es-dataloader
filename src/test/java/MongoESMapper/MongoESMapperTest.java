package MongoESMapper;

import java.util.List;

import com.threegear.common.MongoESMapper;
import com.threegear.model.IndexConfigModel;

public class MongoESMapperTest
{
	public static void main( String[] args )
	{
		List<IndexConfigModel> configs = MongoESMapper.INSTANCE.getConfiguration();

		System.out.println( configs );
	}
}
