package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import CommonClass.Message;

public class ServerModel {
	protected List<ClientThread> clients= new ArrayList<>();
	protected List<String> players= new ArrayList<String>();
	protected ServerSocket serverSocket;
	protected List<Socket> sockets= new ArrayList<Socket>();
	private Cards cards= new Cards();
	private HashMap<String, Integer> listDaten=new HashMap<>();
	Integer portNumber = 8080;
	private Message msgIn=new Message();
	private int num=0;
	private Socket clientSocket;
	private boolean stop;
	private int zugNumber=0;
	private List<Message> messages=new ArrayList<>();
	String sieger;
	private int runde=0;

	public void connect() {
		try {
			serverSocket=new ServerSocket(portNumber);
			Runnable r= new Runnable() {
				@Override
				public void run() {
					while(!stop) {
						try {
							clientSocket = serverSocket.accept();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						msgIn =(Message) Message.receive(clientSocket);
						getMessage();
					}
				}
			};
			Thread t=new Thread(r);
			t.start();
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}

	private void getMessage() {
		if(this.num<3&&this.msgIn.getMessage().equals("anmelden")) {
			sockets.add(clientSocket);
			players.add(msgIn.getName());
		}
		if(this.num==2) {
			startSpiel();
		}else if(this.num>2&&msgIn.getMessage().equals("anmelden")){
			Message msgOut= new Message();
			msgOut.setMessage("Sorry");
			msgOut.send(clientSocket);
			try {
				if(clientSocket!=null) 
					clientSocket.close();
			} catch( Exception e) {
				e.toString();
			}
		}
		this.num++;
	}

	private void startSpiel() {
		for(String player: players) {
			listDaten.put(player, 0);
		}
		cards.zeitalter1Cards();
		Message msgOut=new Message();
		msgOut.setPlayers(players);
		msgOut.setMessage("StartSpiel");

		for(int i=0; i<sockets.size(); i++) {
			msgOut.setNextCards(cards.getSpielerKarten().get(i));
			msgOut.send(sockets.get(i));
			ClientThread c=new ClientThread(ServerModel.this, sockets.get(i));
			clients.add(c);
			c.start();
		}
	}
	public void stopServer() {
		for(ClientThread c: clients) c.stopClient();
		stop=true;
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// Uninteresting
			}
		}
	}
	public void broadcast(Message msg) {
		for(ClientThread c: clients) {
			c.send(msg);
		}
	}
	public void messageIn(Message msg) {
		this.messages.add(msg);
		gewaehlteKarten(msg);
		if(this.messages.size()==3) {
			Message msgOut=new Message();
			if(this.zugNumber<11) {
				msgOut.setMessage("NextZug");
				this.zugNumber++;
				if(this.runde<5) {
					this.messages= Arrays.asList(kartenAktualisieren());
					if(this.zugNumber<6) {
						cards.nextZug1();
					}else {
						cards.nextZug2();
					}
					for(int i=0; i<cards.getSpielerKarten().size(); i++) {
						this.messages.get(i).setNextCards(cards.getSpielerKarten().get(i));
					}
					msgOut.setMessages(this.messages);
					broadcast(msgOut);
					this.runde++;
				}else {
					cards.zeitalter2Cards();
					msgOut.setMessages(this.messages);
					msgOut.setMessage("Zeitalter2");
					for(int i=0; i<clients.size(); i++) {
						msgOut.setNextCards(cards.getSpielerKarten().get(i));
						clients.get(i).send(msgOut);
					}
					this.runde=0;
				}
				this.messages=new ArrayList<>();
			}else {
				msgOut.setMessage("SpielEnde");
				siegerErmitteln();
				msgOut.setSieger(this.sieger);
				broadcast(msgOut);
			}
		}
	}

	private void siegerErmitteln() {
		int t=0;
		for(Map.Entry<String, Integer> e: this.listDaten.entrySet()) {
			if(e.getValue()>t) {
				this.sieger=e.getKey();
				t=e.getValue();
			}
		}
	}
	private void gewaehlteKarten(Message msg) {
		String s= msg.getGewaehlteKarte();
		String n=msg.getName();
		Integer punkte=cards.punkteErmitteln(s);
		for(Map.Entry<String, Integer> e: this.listDaten.entrySet()) {
			if(n.equals(e.getKey())) {
				e.setValue(e.getValue()+punkte);
			}
		}
	}
	private Message[] kartenAktualisieren() {
		Message[] listOut=new Message[3];
		for(int i=0; i<this.players.size(); i++) {
			String n=this.players.get(i);
			for(Message m: this.messages) {
				if(m.getName().equals(n)){
					cards.getSpielerKarten().get(i).remove(m.getGewaehlteKarte());
					listOut[i]=m;
				}
			}
		}
		return listOut;		
	}

}











