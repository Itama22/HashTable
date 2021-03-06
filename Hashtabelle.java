import java.util.Hashtable;
import java.util.LinkedList;

public class Hashtabelle {

	private static Hashtable<Integer, LinkedList<String>> hashtable = null;
	private static LinkedList<String> value = null;

	public static void main(String[] args) {

		hashtable = new Hashtable<Integer, LinkedList<String>>();
		
		// Einf�gen von Key-Values und Tests
		
		putMethode(1, "eins");
		putMethode(2, "zwei");
		putMethode(3, "drei");
		putMethode(4, "vier");
		System.out.println(hashtable.get(2));
		putMethode(2, "zweizwei");
		System.out.println(hashtable.get(2));
		putMethode(2, "zweizweizwei");
		System.out.println(hashtable.get(2));
		putMethode(4, "vier");
		System.out.println(hashtable.get(4));
		putMethode(2, "zweizwei");
		System.out.println(hashtable.get(2));
		remove(2, 1);
		System.out.println(hashtable.get(2));
		removeALL(2);
		System.out.println(hashtable.get(2));
		
	}

	/**
	 * Put-Methode fuegt Key-Value Paare in die Hashtable
	 * @param key ist schluessel
	 * @param value ist wert
	 * @return falls es schon einen Wert mit Schluessel key in der Map gab,
	 *   wird der alte Wert entfernt und zurueckgegeben; sonst wird null zurueckgegeben.
	 */
	
	public static Hashtable putMethode(int schluessel, String wert) {

		if (hashtable.containsKey(schluessel)) {

			LinkedList<String> valuetest = hashtable.get(schluessel);
			int valuetestsize = valuetest.size();
			boolean test = false;
			for (int i = 0; i < valuetestsize; i++) {
				String valuetoken = valuetest.get(i);

				if (!wert.equals(valuetoken)) {
					test = true;
					continue;
				} else if (wert.equals(valuetoken)) {
					System.out.println("Key-Value already exists");
					return null;
				}
			}
			if (test = true) {

				value = new LinkedList<String>();
				value.addAll(hashtable.get(schluessel));
				value.add(wert);
				hashtable.put(schluessel, value);
			}

		} else {

			value = new LinkedList<String>();
			value.add(wert);
			hashtable.put(schluessel, value);
		}
		return hashtable;
	}

	/**
	 * bestimmt den Wert zu einem Schluessel in der Map
	 * @param key der Schluessel
	 * @return den Wert zum Schluessel key, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 */
	
	public static LinkedList<String> get(int key) {
		if (hashtable.containsKey(key)) {
			value = hashtable.get(key);
			return value;
		} else {
			return null;
		}
	}

	/**
	 * entfernt ein Schluessel-Wert-Paar aus der Map. Mit der get-Methode erfaehrt man, welche Paare an der Position
	 * exisitieren und kann dann mit dieser remove Methode ein spezielles Paar loeschen.
	 * @param key der Schluessel
	 * @param position der LinkedList ist position
	 * @return der Wert zu dem Schluessel, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 */
	
	public static Hashtable remove(int key, int position) {
		if (hashtable.containsKey(key)) {
			value = new LinkedList<String>();
			value = hashtable.get(key);
			value.remove(position);
			hashtable.put(key, value);

			return hashtable;
		} else {
			return null;
		}
	}
	
	/**
	 * entfernt ein Schluessel komplett aus der Map
	 * @param key der Schluessel
	 * @return der Wert zu dem Schluessel, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 */
	
	public static Hashtable removeALL(int key) {
		if (hashtable.containsKey(key)) {
			hashtable.remove(key);

			return hashtable;
		} else {
			return null;
		}
	}
}
