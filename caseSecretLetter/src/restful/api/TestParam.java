package restful.api;

import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.Form;

import restful.bean.Text;
//开始地址为http://127.0.0.1:8080/caseSecretLetter
@Path("/letter")
public class TestParam {
	// 算法A
    private static int xorA(String strHexX, String strHexY){

        int hexX = Integer.parseInt(strHexX,16);
        int hexY = Integer.parseInt(strHexY,16);


        return hexX ^ hexY;
    }
	
	// 算法B
    private static String xorB(String strHexX, String strHexY){

        int hexX = Integer.parseInt(strHexX,16);
        int hexY = Integer.parseInt(strHexY,16);
        String hexZ = Integer.toHexString(hexX ^ hexY);
       
        return hexZ;
    }

	// 解码李俊的密钥
	@POST
	@Produces("text/html;charset=UTF-8")
	@Path("/getCipherKey")
	public String getCipherKey(@Form Text text) {
		// cipher1
		String cipher1 = text.getCipher1();
		// 数量
		int num = cipher1.length() / 4;

		String[] a = new String[num];
		String[] b = new String[num];
		int[] c = new int[num];
		String key = "";

		// cipher1结构
		for (int i = 0; i < num; i++) {
			a[i] = cipher1.substring(i * 4, i * 4 + 2);
			b[i] = cipher1.substring(i * 4 + 2, i * 4 + 4);
			// key
			c[i] = xorA(a[i], b[i]);
			key += (char)c[i];
		}

		return String.format("%s", key);
	}

	// 创建张华的密钥
	@POST
	@Produces("text/html;charset=UTF-8")
	@Path("/createCipherKey")
	public String createCipherKey(@Form Text text) {
		// 明文，学号，新密钥
		String key = text.getKey();
		String code = text.getCode();
		String newKey = "";

		int num1 = key.length();
		int num2 = code.length();

		String[] a = new String[num1];
		String[] b = new String[num1];
		String[] c = new String[num1];

		Random r = new Random();
		int j = r.nextInt(num2);

		for (int i = 0; i < num1; i++) {
			a[i] = Integer.toHexString((int) key.charAt(i));
			b[i] = String.valueOf(code.charAt(j)+ r.nextInt(30));
			j++;
			if (j == num2) {
				j = 0;
			}
			c[i] = xorB(a[i], b[i]);
			 if(c[i].length() == 1){
				 c[i] = "0" + c[i];
		        }

			newKey += c[i];

		}

		return String.format("%s", newKey);

	}

	// 加密张华的明文
	@POST
	@Produces("text/html;charset=UTF-8")
	@Path("/createCipherText")
	public String createCipherText(@Form Text text) {
		String newKey = text.getNewKey();
		String cipherText = text.getCipherText();
		String cipher2 = "";

		int num1 = newKey.length() / 2;
		int num2 = cipherText.length();
		int j = 0;

		String[] a = new String[num1];
		String[] b = new String[num2];
		String[] c = new String[num2];

		for (int i = 0; i < num1; i++) {
			a[i] = newKey.substring(i * 2, i * 2 + 2);
		}
		for (int i = 0; i < num2; i++) {
			b[i] = Integer.toHexString((int) cipherText.charAt(i));
		}
		for (int i = 0; i < num2; i++) {

			c[i] = xorB(b[i], a[j]);
			 if(c[i].length() == 2){
				 c[i] = "00" + c[i];
		        }
			 else if(c[i].length() == 1) {
		        c[i] = "000" + c[i];
		        }
			cipher2 += c[i];
			j++;
			if (j == num1) {
				j = 0;
			}

		}
		return String.format("%s", cipher2);

	}

	// 解密张华的明文
	@POST
		@Produces("text/html;charset=UTF-8")
		@Path("/decodeCipherText")
		public String decodeCipherText(@Form Text text) {
			
			String cipher2 = text.getCipher2();
			String newKey = text.getNewKey();
			String cipherText = "";
			
			int num1 = cipher2.length()/4;
			int num2 = newKey.length()/2;
			int j =0;
			
			String[] a = new String[num1];
	        String[] b = new String[num2];
	        String[] c = new String[num1];
	        
	        for (int i = 0; i < num1; i++) {
	            a[i] = cipher2.substring(i*4,i*4+4);
	        }
	        for (int i = 0; i < num2; i++) {
	            b[i] = newKey.substring(i*2,i*2+2);
	        }
	        for (int i = 0; i < num1; i++) {
	            
                c[i] = xorB(a[i],b[j]);
                cipherText += (char)Integer.parseInt(c[i],16);
                j++;
                if (j == num2){
                    j = 0;
                    }
	           
	        }
	        return String.format("%s", cipherText);
	          
		}
	        

}
