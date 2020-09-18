package neu.util;

public class GenerateCode {

	private static final String CODE="0123456789";
	
	public static String getCode() {
		String code="";
		for(int i=0;i<4;i++) {
			int r=(int) (Math.random()*CODE.length());
			code+=CODE.charAt(r);
		}
		return code;
	}
}
