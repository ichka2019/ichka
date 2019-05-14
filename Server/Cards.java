package Server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cards {

	private List<String> stapelKarten;
	private List<String> spielKarten1=new ArrayList<>();
	private List<String> spielKarten2=new ArrayList<>();
	private List<String> spielKarten3=new ArrayList<>();
	private List<List<String>> spielerKarten=new ArrayList<>();
	private HashMap<String, Integer> punkteKarten=new HashMap<>();
	HashMap<String, Integer> spieler1Punkte= new HashMap<>();
	HashMap<String, Integer> spieler2Punkte= new HashMap<>();
	HashMap<String, Integer> spieler3Punkte= new HashMap<>();


	public void setZeitalterCards() {
		String[] zeitalterCards= {"befestigungsanlage", "kaserne", "wachturm", "theater", "altar", "baeder", "apotheke", "skriptorum", "werkstatt", "markt", 
				"kontorOst", "kontorWest", "ziegelei", "erzbergwerk", "holzplatz", "tongrube", "forstwirtschaft", "steinbruch", "webstuhl", "presse",
				"glashuette", "schiessplatz", "mauern", "staelle", "aquaedukt", "tempel", "statue", "gericht", "schule", "arzneiausgabe", "laboratorium", "bibliothek", "forum",
				"weinberg", "karawanserei", "saegewerk", "ziegelbrennerei", "bildhauerei", "giesserei", "webstuhl2", "presse2", "glashuette2"};
		Integer[] punkte= {1, 2, 4, 3, 5, 2, 7, 8, 5, 4, 2, 1, 2, 3, 2, 2, 5, 6, 4, 3, 2, 1, 2, 3, 4, 7, 6, 9, 4, 2, 1, 2, 5, 4, 3, 2, 2, 1, 9, 1, 2, 6};
		for(int i=0; i<punkte.length; i++)
			this.punkteKarten.put(zeitalterCards[i], punkte[i]);
	}
	public void zeitalter1Cards() {
		String[] list1= { "befestigungsanlage", "kaserne", "wachturm", "theater", "altar", "baeder", "apotheke", "skriptorum", "werkstatt", "markt", 
				"kontorOst", "kontorWest", "ziegelei", "erzbergwerk", "holzplatz", "tongrube", "forstwirtschaft", "steinbruch", "webstuhl", "presse",
		"glashuette"};
		kartenSetzen(list1);
	}
	public void zeitalter2Cards() {
		String[] list2= {"schiessplatz", "mauern", "staelle", "aquaedukt", "tempel", "statue", "gericht", "schule", "arzneiausgabe", "laboratorium", "bibliothek", "forum",
				"weinberg", "karawanserei", "saegewerk", "ziegelbrennerei", "bildhauerei", "giesserei", "webstuhl2", "presse2", "glashuette2"};
		this.spielKarten1.clear();
		this.spielKarten2.clear();
		this.spielKarten3.clear();
		kartenSetzen(list2);
	}
	private void kartenSetzen(String[] list) {
		this.stapelKarten=Arrays.asList(list);

		Collections.shuffle(this.stapelKarten);
		for(int i=0; i<7; i++) {
			this.spielKarten1.add(this.stapelKarten.get(i)); 
		}
		for(int j=7; j<14; j++) {
			this.spielKarten2.add(this.stapelKarten.get(j)); 
		}
		for(int k=14; k<21; k++) {
			this.spielKarten3.add(this.stapelKarten.get(k)); 
		}
		this.spielerKarten.add(this.spielKarten1);
		this.spielerKarten.add(this.spielKarten2);
		this.spielerKarten.add(this.spielKarten3);		
	}
	public List<List<String>> getSpielerKarten() {
		return this.spielerKarten;
	}
	public void nextZug1() {
		List<List<String>> list= new ArrayList<>();
		list.add(this.spielerKarten.get(2));
		list.add(this.spielerKarten.get(0));
		list.add(this.spielerKarten.get(1
				));
		this.spielerKarten=list;
	}
	public void nextZug2() {
		List<List<String>> list= new ArrayList<>();
		list.add(this.spielerKarten.get(1));
		list.add(this.spielerKarten.get(2));
		list.add(this.spielerKarten.get(0));
		this.spielerKarten=list;
	}
	
	public Integer punkteErmitteln(String card) {
		int p=0;
		setZeitalterCards();
		for(Map.Entry<String, Integer> e: this.punkteKarten.entrySet()) {
			if(card.equals(e.getKey())) {
				p=e.getValue();
			}
		}
		return p;
	}


}
