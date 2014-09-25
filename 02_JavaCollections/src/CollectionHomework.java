import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionHomework {
	public static void main(String[] args) {
		fillMap();
	}
	
	private static void fillMap() {
		final Map<String, Integer> m = new HashMap<String, Integer>();
		
		m.put("Bulgaria", 7);
		m.put("Germany", 80);
		m.put("Serbia", 4);
		m.put("USA", 300);
		m.put("China", 1400);
		for (Entry<String, Integer> next : m.entrySet()) {
			if(next.getValue()>=10) {
				System.out.printf("The population of %s is %d M\n", next.getKey(), next.getValue());
			}
		}
	}
}