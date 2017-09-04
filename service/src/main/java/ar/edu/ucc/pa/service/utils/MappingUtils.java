package ar.edu.ucc.pa.service.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class MappingUtils {

	private static ModelMapper modelMapper;

	static {
		try {

			modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static <T> T translate(Object source, Class<T> target) {
		return modelMapper.map(source, target);
	}

}
