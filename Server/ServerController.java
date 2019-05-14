package Server;

public class ServerController {

	public ServerController(ServerModel model, ServerView view) {
		view.btnStart.setOnAction(event -> {
			view.btnStart.setDisable(true);
			System.out.println("started");
			model.connect();
		});
		view.getStage().setOnCloseRequest(event->model.stopServer());
	}	
}


