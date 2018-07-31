
public class ChkLoadJdbc {
	public static void main(String[] args) throws
	InstantiationException,
	IllegalAccessException  {

String msg = "";
		// TODO 自動生成されたメソッド・スタブ
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			msg = "ドライバのロードに成功しました";
		}catch (ClassNotFoundException e){
			msg = "ドライバのロードに失敗しました";
		}
		System.out.println(msg);

	}
}




