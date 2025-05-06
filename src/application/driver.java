package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class driver extends Application{

	
	@Override
	public void start(Stage mainStage) throws Exception {
		

		// Create controller
        Controller controller = new Controller();

        // Get the root from the controller
        Scene scene = new Scene(controller.getRoot(), controller.getWidth(), controller.getHeight());
        controller.setKeys(scene);
        
        // Stage setup
        mainStage.setTitle("Application");
        mainStage.setScene(scene);
        mainStage.show();
        controller.startGameLoop();
        controller.getRoot().requestFocus();
	}
	
	 public static void main(String[] args) {
	        launch(args);
	    }

}