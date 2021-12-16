package encoding;

public class BaseSecret {
	private String secret;
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public static String toBinaryString(int num) {
		StringBuilder builder = new StringBuilder();
		do {
			int rem = num%2;
			num/=2;
			builder.insert(0, rem);
		}while(num!=0);
		return builder.toString();
	}
	public static String toDecimalString(int num) {
		StringBuilder builder = new StringBuilder();
		do {
			int rem = num%10;
			num/=10;
			builder.insert(0, rem);
		}while(num!=0);
		return builder.toString();
	}
	public static int parseIntBinary(String binaryStr) {
		int res = 0;
		int length = binaryStr.length();
		for(int i=0;i<length;i++) {
			res=res*2+(binaryStr.charAt(i)-'0');
		}
		return res;
	}
	public static int parseIntDecimal(String decString) {
		int res = 0;
		int length = decString.length();
		for(int i=0;i<length;i++) {
			res=res*10+(decString.charAt(i)-'0');
		}
		return res;
	}
	public String toSecretString(int num) {
		StringBuilder builder = new StringBuilder();
		int length = this.secret.length();
		do {
			int rem = num%length;
			num/=length;
			builder.insert(0, this.secret.toCharArray()[rem]);
		}while(num!=0);
		
		return builder.toString();
	}
	public boolean matches(String code, String decString) {
		StringBuilder builder = new StringBuilder();
		int num = parseIntDecimal(decString);
		int length = this.secret.length();
		do {
			int rem = num%length;
			num/=length;
			builder.insert(0, this.secret.toCharArray()[rem]);
		}while(num!=0);
		System.out.println(code);
		if(builder.toString().equals(code)) {
			return true;
		};
		return false;
	}
}
