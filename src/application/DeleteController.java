package application;

import javafx.scene.input.MouseEvent;

public class DeleteController {
    public void yes(MouseEvent e) {
        Queries.delete(Start.getCurrentUser());
        Start.getFromWindowLst(0).exit(e);
        
        SceneController.getWindowController().setCurScene("/LoginScene.fxml");
		SceneController.getWindowController().changeScene();
    }
    public void no(MouseEvent e) {
        Start.getFromWindowLst(0).exit(e);
    }
}
