package restful.provider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.apache.commons.codec.binary.Base64;
import restful.utils.SimpleUploadUtils;

@Provider
@Consumes("monaLisa/input")
@Produces("monaLisa/output")
public class Bmp24BitDecodeProvider implements MessageBodyReader<BufferedImage>, MessageBodyWriter<BufferedImage> {

	@Override
	public long getSize(BufferedImage bufferedImage, Class<?> clazz, Type type, Annotation[] annotations,
			MediaType mediaType) {
		System.out.println("--------------- getSize begins ------------------");  
       
        System.out.printf("class:%s\n", clazz.getName());   
        System.out.printf("type:%s\n", type.getTypeName());  
        System.out.printf("number of annotation:%d\n",annotations.length);  
        for(Annotation annotation : annotations) {  
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());  
        }  
        System.out.printf("mediaType:%s\n",mediaType.getType());  
        System.out.println("--------------- getSize ends ------------------");  
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType) {
		System.out.println("--------------- isWriteable begins ------------------");  
        System.out.printf("class:%s\n", clazz.getName());   
        System.out.printf("type:%s\n", type.getTypeName());  
        System.out.printf("number of annotation:%d\n",annotations.length);  
        for(Annotation annotation : annotations) {  
            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());  
        }  
        System.out.printf("mediaType:%s\n",mediaType.getType());  
        System.out.println("--------------- isWriteable ends ------------------");  
		return true;
	}

	@Override
	public void writeTo(BufferedImage bufferedImage, Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> multivaluedMap, OutputStream entityStream)
			throws IOException, WebApplicationException {
			
			byte[] imageBytes = (byte[])bufferedImage.getData().getDataElements(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
			byte[] lowBits = new byte[imageBytes.length];
			for(int i=0;i<imageBytes.length;i++)
			{
				lowBits[i] = (byte)(imageBytes[i] & 0x01);
			}
			String picLen = "";
			for(int i=31;i>=0;i--)
			{
				picLen += lowBits[i];
			}
			int len = Integer.valueOf(picLen, 2);
			byte[] result = new byte[len];
			for(int i=0;i<len;i++)
			{
				String value = "";
				for(int j=i*8+39;j>=i*8+32;j--)
				{
					value += lowBits[j];
				}
				result[i] = Integer.valueOf(value,2).byteValue();
			}
			Base64 base64 = new Base64();
			entityStream.write(base64.encode(result));
	}

	@Override
	public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType) {
		
		 System.out.println("--------------- isReadable begins ------------------");  

	        System.out.printf("class:%s\n", clazz.getName());   

	        System.out.printf("type:%s\n", type.getTypeName());  

	        System.out.printf("number of annotation:%d\n",annotations.length);  

	        for(Annotation annotation : annotations) {  

	            System.out.printf("\t annotation:%s\n", annotation.annotationType().getName());  

	        }  

	        System.out.printf("mediaType:%s\n",mediaType.getType());  

	        System.out.println("--------------- isReadable ends ------------------");  
		return true;
	}

	@Override
	public BufferedImage readFrom(Class<BufferedImage> clazz, Type type, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> multivaluedMap, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(SimpleUploadUtils.getSingleFileBytsFromEntity(entityStream)); 
		BufferedImage bufferedImage =  ImageIO.read(byteArrayInputStream);
		//System.out.println(bufferedImage.getWidth()+","+bufferedImage.getHeight());
		return bufferedImage;
	}

}
