import java.util.HashMap;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put(null, "null 1");
		map.put(null, "null2");
		map.put("null", null);
		map.put("null2", null);
		
		System.out.println(map);
	}
}
