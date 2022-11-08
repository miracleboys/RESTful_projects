package restful.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleUploadUtils {
  public static byte[] getSingleFileBytsFromEntity(InputStream inputStream) throws IOException{
	    
	  	byte[] streamBytes = inputStream.readAllBytes();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(streamBytes);
		
		byte[] crfl = {0x0d,0x0a};
		byte[] doubleCrfl = {0x0d,0x0a,0x0d,0x0a};
		
		int mark0d0a = ByteUtils.getByteIndexOf(streamBytes, crfl, 0,streamBytes.length-1);		
		byte[] boundry = new byte[mark0d0a];		
		byteArrayInputStream.read(boundry);
		
		int bmpDataBegin = ByteUtils.getByteIndexOf(streamBytes, doubleCrfl, mark0d0a,streamBytes.length-1)+4;	
		int bmpDataEnd = ByteUtils.getByteIndexOf(streamBytes, boundry, bmpDataBegin,streamBytes.length-1)-2;
		
		byte[] bmpBytes = new byte[bmpDataEnd-bmpDataBegin];
		byteArrayInputStream.skip(bmpDataBegin-mark0d0a);		
		byteArrayInputStream.read(bmpBytes);		
		
		return bmpBytes;
  }
}
