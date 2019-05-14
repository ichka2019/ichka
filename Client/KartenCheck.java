package Client;

import java.util.List;

import javafx.scene.control.Label;

public class KartenCheck {
	private ClientModel model;
	boolean a;
	private String name;
	private List<String> players;

	public KartenCheck(ClientModel mod) {
		this.model=mod;
	}
	public CardInfo resourceCheck(String card, List<List<Label>> resourcen) {
		this.players=model.getPlayers();
		this.name=model.getName();
		CardInfo info = null;

		if(card.equals("befestigungsanlage")) {
			info=befestigungsanlage(resourcen);
		}
		if(card.equals("kaserne")) {
			info=kaserne(resourcen);
		}
		if(card.equals("wachturm")) {
			info=wachturm(resourcen);
		}
		if(card.equals("baeder")){
			info=baeder(resourcen);
		}
		if(card.equals("altar")){
			info=altar(resourcen);
		}
		if(card.equals("theater")){
			info=theater(resourcen);
		}
		if(card.equals("apotheke")){
			info=apotheke(resourcen);
		}
		if(card.equals("skriptorum")){
			info=skriptorum(resourcen);
		}
		if(card.equals("werkstatt")){
			info=werkstatt(resourcen);
		}
		if(card.equals("markt")){
			info=markt(resourcen);
		}
		if(card.equals("kontorOst")){
			info=kontorOst(resourcen);
		}
		if(card.equals("kontorWest")){
			info=kontorWest(resourcen);
		}
		if(card.equals("tongrube")){
			info=tongrube(resourcen);
		}

		if(card.equals("holzplatz")){
			info=holzplatz(resourcen);
		}
		if(card.equals("ziegelei")){
			info=ziegelei(resourcen);
		}
		if(card.equals("erzbergwerk")){
			info=erzbergwerk(resourcen);
		}
		if(card.equals("forstwirtschaft")){
			info=forstwirtschaft(resourcen);
		}
		if(card.equals("steinbruch")){
			info=steinbruch(resourcen);
		}
		if(card.equals("webstuhl")){
			info=webstuhl(resourcen);
		}
		if(card.equals("presse")){
			info=presse(resourcen);
		}
		if(card.equals("glashuette")){
			info=glashuette(resourcen);
		}
		
		if(card.equals("schiessplatz")){
			info=glashuette(resourcen);
		}if(card.equals("mauern")){
			info=glashuette(resourcen);
		}if(card.equals("staelle")){
			info=glashuette(resourcen);
		}if(card.equals("aquaedukt")){
			info=glashuette(resourcen);
		}if(card.equals("tempel")){
			info=glashuette(resourcen);
		}if(card.equals("statue")){
			info=glashuette(resourcen);
		}if(card.equals("gericht")){
			info=glashuette(resourcen);
		}if(card.equals("schule")){
			info=glashuette(resourcen);
		}if(card.equals("arzneiausgabe")){
			info=glashuette(resourcen);
		}if(card.equals("laboratorium")){
			info=glashuette(resourcen);
		}if(card.equals("bibliothek")){
			info=glashuette(resourcen);
		}if(card.equals("forum")){
			info=glashuette(resourcen);
		}if(card.equals("weinberg")){
			info=glashuette(resourcen);
		}if(card.equals("karawanserei")){
			info=glashuette(resourcen);
		}if(card.equals("saegewerk")){
			info=glashuette(resourcen);
		}if(card.equals("ziegelbrennerei")){
			info=glashuette(resourcen);
		}if(card.equals("bildhauerei")){
			info=glashuette(resourcen);
		}if(card.equals("giesserei")){
			info=glashuette(resourcen);
		}if(card.equals("webstuhl2")){
			info=glashuette(resourcen);
		}if(card.equals("presse2")){
			info=glashuette(resourcen);
		}if(card.equals("glashuette2")){
			info=glashuette(resourcen);
		}

		return info;
	}


	private CardInfo presse(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int papyrus = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(5);
				papyrus= Integer.parseInt(l.getText());
				papyrus++;
				l.setText(Integer.toString(papyrus));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo glashuette(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int glas = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(4);
				glas= Integer.parseInt(l.getText());
				glas++;
				l.setText(Integer.toString(glas));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}
	private CardInfo wachturm(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int ziegel = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(3);
				ziegel= Integer.parseInt(l.getText());
			}
			if(ziegel>=1) {
				ziegel--;
				l.setText(Integer.toString(ziegel));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;

	}

	private CardInfo kaserne(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int erz = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(1);
				erz= Integer.parseInt(l.getText());
			}
			if(erz>=1) {
				erz--;
				l.setText(Integer.toString(erz));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;

	}
	private CardInfo theater(List<List<Label>> resourcen) {
		boolean b=false;
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo altar(List<List<Label>> resourcen) {
		boolean b=false;
		CardInfo info=new CardInfo(b, resourcen);
		return info;	}

	private CardInfo baeder(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int stein = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(2);
				stein= Integer.parseInt(l.getText());
			}
			if(stein>=1) {
				l.setText(Integer.toString(Integer.parseInt(l.getText())-1));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo werkstatt(List<List<Label>> resourcen) {	
		boolean b=false;
		Label l=null;
		int glas = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(4);
				glas= Integer.parseInt(l.getText());
			}
			if(glas>=1) {
				l.setText(Integer.toString(Integer.parseInt(l.getText())-1));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo skriptorum(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int papyrus = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(5);
				papyrus= Integer.parseInt(l.getText());
			}
			if(papyrus>=1) {
				l.setText(Integer.toString(Integer.parseInt(l.getText())-1));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo apotheke(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int stoff = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(6);
				stoff= Integer.parseInt(l.getText());
			}
			if(stoff>=1) {
				l.setText(Integer.toString(Integer.parseInt(l.getText())-1));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo kontorWest(List<List<Label>> resourcen) {
		boolean b=true;
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo kontorOst(List<List<Label>> resourcen) {
		boolean b=true;
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo markt(List<List<Label>> resourcen) {
		boolean b=true;
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo steinbruch(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int stein = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(2);
				stein= Integer.parseInt(l.getText());
				stein++;
				l.setText(Integer.toString(stein));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}
	private CardInfo forstwirtschaft(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int muenze = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(8);
				muenze= Integer.parseInt(l.getText());
			}
			if(muenze>=1) {
//				l.setText(Integer.toString(Integer.parseInt(l.getText())-1));
//				l=(Label) resourcen.get(i).get(0);
//				l.setText(Double.toString(Double.parseDouble(l.getText())+0.5));
//				l=(Label) resourcen.get(i).get(2);
//				l.setText(Double.toString(Double.parseDouble(l.getText())+0.5));
				b=true;
			}
		}

		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}
	private CardInfo erzbergwerk(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int erz = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(1);
				erz= Integer.parseInt(l.getText());
				erz++;
				l.setText(Integer.toString(erz));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo ziegelei(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int ziegel = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(3);
				ziegel= Integer.parseInt(l.getText());
				ziegel++;
				l.setText(Integer.toString(ziegel));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo holzplatz(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int holz = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(0);
				holz= Integer.parseInt(l.getText());
				holz++;
				l.setText(Integer.toString(holz));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo webstuhl(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int stoff = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(6);
				stoff= Integer.parseInt(l.getText());
				stoff++;
				l.setText(Integer.toString(stoff));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo tongrube(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int muenze = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(8);
				muenze= Integer.parseInt(l.getText());
			}
			if(muenze>=1) {
				l.setText(Integer.toString(Integer.parseInt(l.getText())-1));
				l=(Label) resourcen.get(i).get(1);
				l.setText(Integer.toString(Integer.parseInt(l.getText())+0,5));
				l=(Label) resourcen.get(i).get(3);
				l.setText(Integer.toString(Integer.parseInt(l.getText())+0,5));
				b=true;
			}
		}

		CardInfo info=new CardInfo(b, resourcen);
		return info;
	}

	private CardInfo befestigungsanlage(List<List<Label>> resourcen) {
		boolean b=false;
		Label l=null;
		int holz = 0;
		for(int i=0; i<this.players.size(); i++) {
			if(this.name.equals(this.players.get(i))) {
				l=(Label) resourcen.get(i).get(0);
				holz= Integer.parseInt(l.getText());
			}
			if(holz>=1) {
				holz--;
				l.setText(Integer.toString(holz));
				b=true;
			}
		}
		CardInfo info=new CardInfo(b, resourcen);
		return info;

	}

}
