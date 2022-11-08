package restful.utils;

public class ByteUtils {

	public static int getByteIndexOf(byte[] sources, byte[] src, int startIndex, int endIndex) {

		if (sources == null || src == null || sources.length == 0 || src.length == 0) {
			return -1;
		}

		if (endIndex > sources.length) {
			endIndex = sources.length;
		}

		int index, subIndex;

		for (index = startIndex; index < endIndex; index++) {
			if (sources[index] == src[0] && index + src.length < endIndex) {
				for (subIndex = 1; subIndex < src.length; subIndex++) {
					if (sources[index + subIndex] != src[subIndex]) {
						break;
					}
				}

				if (subIndex == src.length) {
					return index;
				}
			}
		}
		return -1;
	}	
}
