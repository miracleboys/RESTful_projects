package restful.api;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.util.Base64.InputStream;

@Path("/monaLisa")
public class MonaLisaDecode {
	// 访问地址：127.0.0.1:8080/monaLisa/uncover.jsp
	@POST
	@Consumes("monaLisa/input")
	@Produces("monaLisa/output")
	@Path("/uncover")
	public BufferedImage uncover(BufferedImage  bmp24bit) throws IOException {
		return bmp24bit;
	}
}
