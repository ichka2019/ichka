package Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CommonClass.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameController {
	private static ClientModel model;
	private KartenCheck kCheck;
	private List <Button> stapel;
	private List<String> players= new ArrayList<>();
	private String name;
	private List<Label> spieler1Data=new ArrayList<>();
	private List<Label> spieler2Data=new ArrayList<>();
	private List<Label> spieler3Data=new ArrayList<>();
	private List<List<Label>> resourcen=new ArrayList<>();
	private List<String> gezogeneKarten=new ArrayList<>();
	private CardInfo cardInfo;
	private List<Label> cards=new ArrayList<>();
	private List<Message> messages=null;
	private List<String> nextCards;
	private String gewaehlteKarte;
	private int num=0;
	private int runde=0;
	@FXML
	private Label welcome;
	@FXML
	public Label text;

	@FXML
	private Button ok;
	@FXML
	private Label board;
	@FXML
	private Button stapelCard1;

	@FXML
	private Button stapelCard2;

	@FXML
	private Button stapelCard3;

	@FXML
	private Button stapelCard4;

	@FXML
	private Button stapelCard5;

	@FXML
	private Button stapelCard6;

	@FXML
	private Button stapelCard7;
	@FXML
	private Label spielerName;
	@FXML
	private Label spieler1;

	@FXML
	private Label spieler2;

	@FXML
	private Label spieler3;

	@FXML
	private Label cards1;

	@FXML
	private Label cards2;

	@FXML
	private Label cards3;

	@FXML
	private Label cards4;

	@FXML
	private Label cards5;

	@FXML
	private Label cards6;

	@FXML
	private Label holz1;

	@FXML
	private Label holz2;

	@FXML
	private Label holz3;

	@FXML
	private Label erz1;

	@FXML
	private Label erz2;

	@FXML
	private Label erz3;

	@FXML
	private Label stein1;

	@FXML
	private Label stein2;

	@FXML
	private Label stein3;

	@FXML
	private Label ziegel1;

	@FXML
	private Label ziegel2;

	@FXML
	private Label ziegel3;

	@FXML
	private Label glas1;

	@FXML
	private Label glas2;

	@FXML
	private Label glas3;

	@FXML
	private Label papyrus1;

	@FXML
	private Label papyrus2;

	@FXML
	private Label papyrus3;

	@FXML
	private Label stoff1;

	@FXML
	private Label stoff2;

	@FXML
	private Label stoff3;

	@FXML
	private Label board1;

	@FXML
	private Label board2;

	@FXML
	private Label board3;
	@FXML
	private Label muenze1;

	@FXML
	private Label muenze2;

	@FXML
	private Label muenze3;

	@FXML
	private Button ja;

	@FXML
	private Button nein;

	@FXML
	void spielBeginnen(ActionEvent event) throws Exception {
		Button button=(Button) event.getSource();
		button.setDisable(true);
		this.kCheck=new KartenCheck(model);
		setStapelKarten();
		setGewaehlteKartenLabel1();
		setResourcenLabels();
		setPlayers();
		setGewaehlteKartenLabel1();
		kartenSetzen();
	}
	@FXML
	void checkCard(ActionEvent event) {
		Button button= (Button) event.getSource();
		button.setDisable(true);
		this.nein.setDisable(false);
		this.gewaehlteKarte= button.getText();

	}
	@FXML
	void boardCard(ActionEvent event) {
		if(this.num<3) {
			this.name=model.getName();
			if(this.name.equals(this.players.get(0)))
				this.board1.setText(Integer.toString(Integer.parseInt(this.board1.getText())+1));
			if(this.name.equals(this.players.get(1)))
				this.board2.setText(Integer.toString(Integer.parseInt(this.board2.getText())+1));
			if(this.name.equals(this.players.get(0)))
				this.board3.setText(Integer.toString(Integer.parseInt(this.board3.getText())+1));

			this.num++;
		}else {
			this.ja.setDisable(true);
			this.nein.setDisable(true);

		}
	}
	@FXML
	void keinBoardCard(ActionEvent event) {
		Button button=(Button) event.getSource();

		this.cardInfo=kCheck.resourceCheck(this.gewaehlteKarte, this.resourcen);
		//		if(!this.cardInfo.getB()) {
		//			this.text.setText("Wählen Sie eine andere Karte!");
		//
		//		} else {
		List<Integer> resourcenZahlen=new ArrayList<>();
		List<Label> list=new ArrayList<>();
		for(int i=0; i<this.players.size(); i++) {
			if(model.getName().equals(this.players.get(i))) {
				list= this.cardInfo.getResourcen().get(i);
				this.cards.get(i).setText(this.cards.get(i).getText()+this.gewaehlteKarte+"\n");
			}
		}
		for(Label l: list) {
			Integer in=Integer.parseInt(l.getText());
			resourcenZahlen.add(in);
		}
		for(Button b: this.stapel)
			b.setDisable(true);
		this.gezogeneKarten.add(this.gewaehlteKarte);
		model.sendMessage(model.getName(), this.gewaehlteKarte, resourcenZahlen);
		setDaten();
	}
	//	}
	public void setDaten() {
		model.getMessage();
		System.out.println(model.getMsg().getMessage());
		this.messages=model.getMessages();
		gegnerKartenSetzen();
		if(this.runde<5) {
			msgKartenSetzen();
			for(Button b: this.stapel)
				b.setDisable(false);
			this.runde++;
		}else if(model.getMsg().getMessage().equals("Zeitalter2")){
			this.runde=0;
			setStapelKarten();
			setGewaehlteKartenLabel2();
			kartenSetzen();
		}else{
			spielEnden();
		}

	}
	private void spielEnden() {
		System.out.println(model.getSieger());
		this.welcome.setText("Der Sieger ist:  "+ model.getSieger());
		this.welcome.setFont(new Font("Copperplate", 40));
		this.welcome.setTextFill(Color.web("#e40163"));
		this.nein.setVisible(false);
		this.ja.setVisible(false);
		this.ok.setVisible(false);
		this.board.setVisible(false);

		this.spielerName.setVisible(false);
		this.text.setVisible(false);

		for(Button b: this.stapel) {
			b.setVisible(false);
		}

	}
	private void gegnerKartenSetzen() {
		for(int i=0; i<this.messages.size(); i++) {
			Message m=this.messages.get(i);
			if(!model.getName().equals(m.getName())){
				for(int k=0; k<this.players.size(); k++) {
					if(this.players.get(k).equals(m.getName())) {
						this.cards.get(k).setText(this.cards.get(k).getText()+m.getGewaehlteKarte()+"\n");
						List<Label> labels= this.resourcen.get(k);
						for(int j=0; j<labels.size(); j++) {
							labels.get(j).setText(Integer.toString(m.getResourcen().get(j)));
						}
					}
				}
			}		
		}
	}
	public void setPlayers() {
		this.players= model.getPlayers();
		spielerName.setText(model.getName());
		Label[] names= {spieler1, spieler2, spieler3};
		for(int i=0; i<names.length; i++) {
			names[i].setText(this.players.get(i));
		}
	}
	private void msgKartenSetzen() {
		for(int i=0; i<this.messages.size(); i++) {
			Message m=this.messages.get(i);
			if(model.getName().equals(m.getName())){
				this.nextCards=m.getNextCards();
				this.stapel.get(this.stapel.size()-1).setVisible(false);
				this.stapel.remove((this.stapel.size()-1));
				for(int t=0; t<this.stapel.size(); t++) {
					this.stapel.get(t).setText(this.nextCards.get(t));
				}
				this.text.setText("Bitte Karte wählen!");
				this.nein.setDisable(false);
				this.ja.setDisable(false);
			}
		}
	}
	private void setResourcenLabels() {
		Label[] spieler1Ressourcen= {holz1, erz1, stein1, ziegel1, glas1, papyrus1, stoff1, board1, muenze1};
		Label[] spieler2Ressourcen= {holz2, erz2, stein2, ziegel2, glas2, papyrus2, stoff2, board2, muenze2};
		Label[] spieler3Ressourcen= {holz3, erz3, stein3, ziegel3, glas3, papyrus3, stoff3, board3, muenze3};
		this.spieler1Data=(Arrays.asList(spieler1Ressourcen));
		this.spieler2Data=(Arrays.asList(spieler2Ressourcen));
		this.spieler3Data=(Arrays.asList(spieler3Ressourcen));
		this.resourcen.add(spieler1Data);
		this.resourcen.add(spieler2Data);
		this.resourcen.add(spieler3Data);
	}
	private void setGewaehlteKartenLabel1() {
		Label [] labs= {cards1, cards2, cards3};
		this.cards=Arrays.asList(labs);
	}
	private void setStapelKarten() {

		Button[] st= {stapelCard1,stapelCard2,stapelCard3,stapelCard4,stapelCard5,stapelCard6,stapelCard7};
			this.stapel=new ArrayList<Button>(Arrays.asList(st));
	}

	public void setPlayers(String n) {
		spielerName.setText(n);
		Label[] names= {spieler1, spieler2, spieler3};
		for(int i=0; i<names.length; i++) {
			names[i].setText(this.players.get(i));
		}
	}
	public void kartenSetzen() {
		for(Button b: this.stapel) {
			b.setVisible(true);
			b.setDisable(false);
		}
		for(int i=0; i<this.stapel.size(); i++)
			this.stapel.get(i).setText(model.getZugKarten().get(i));
		this.text.setText(" Karte wählen!");
		this.nein.setDisable(true);
		this.ja.setDisable(true);
	}
	public void setGewaehlteKartenLabel2() {
		Label [] lab= {cards4, cards5, cards6};
		this.cards=Arrays.asList(lab);
	}

	public static void setModel(ClientModel clientModel) {
		model= clientModel;
	}
	
	




}
