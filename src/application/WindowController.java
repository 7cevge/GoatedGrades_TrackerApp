package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class WindowController {
	@FXML
	private Button maxBtn;
	
	// T = top, R = right, B = bottom, L = left, S = small, rh = resize handle
	// Named this way to make later functions with switch case easier to use
	@FXML
	private Rectangle rhT1, rhB1, rhR1, rhL1, moveHandle,
						rhTR1, rhTR2, rhTL1, rhTL2, rhBR1, rhBR2, rhBL1, rhBL2;

	private static final String LOGINSCENE = "/LoginScene.fxml";

	private double newX = -1, newY = -1;
	private String currentScene = LOGINSCENE;

	// -------------------------------------------------------------------------- For currentScene
	public String getCurScene() {
		return currentScene;
	}

	public void setCurScene(String newScene) {
		currentScene = newScene;
		if (currentScene.equals(LOGINSCENE)) {
			disableWindow(true);
		} else {
			disableWindow(false);
		}
	}

	// ---------------------------------------------------------------------- The 3 window buttons
	public void minimize(MouseEvent e) {
		Stage stage = (Stage) maxBtn.getScene().getWindow();
		stage.setIconified(true);
	}

	public void maximize(MouseEvent e) {
		Stage stage = (Stage) maxBtn.getScene().getWindow();
		if (currentScene.equals(LOGINSCENE)) {

		} else if (stage.isMaximized() && !maxBtn.getStyleClass().contains("maxMode")) {
			stage.setMaximized(false);
			maxBtn.getStyleClass().remove("restoreMode");
			maxBtn.getStyleClass().add("maxMode");
			disableWindow(false);
		} else {
			stage.setMaximized(true);
			maxBtn.getStyleClass().remove("maxMode");
			maxBtn.getStyleClass().add("restoreMode");
			disableWindow(true);
		}
	}

	private void disableWindow(boolean disable) {
		moveHandle.setDisable(disable);
		rhT1.setDisable(disable);
		rhB1.setDisable(disable);
		rhL1.setDisable(disable);
		rhR1.setDisable(disable);
		rhTL1.setDisable(disable);
		rhTL2.setDisable(disable);
		rhTR1.setDisable(disable);
		rhTR2.setDisable(disable);
		rhBL1.setDisable(disable);
		rhBL2.setDisable(disable);
		rhBR1.setDisable(disable);
		rhBR2.setDisable(disable);
	}

	public void exit(MouseEvent e) {
		Stage stage = (Stage) maxBtn.getScene().getWindow();
		stage.close();
	}

	// ------------------------------------------------------- Moving the window around the screen
	public void moveWindow1(MouseEvent e) {
		String target = e.getTarget().toString();
		if (!target.contains("id=moveHandle")) {
		} else {
			newX = e.getSceneX();
			newY = e.getSceneY();
		}
	}

	public void moveWindow2(MouseEvent e) {
		String target = e.getTarget().toString();
		Stage stage = (Stage) maxBtn.getScene().getWindow();
		if (!target.contains("id=moveHandle")) {
		} else if (newX != -1 && newY != -1) {
			stage.setX(e.getScreenX() - newX);
			stage.setY(e.getScreenY() - newY);
		} else {
			System.err.println("Invalid newX and or newY");
		}
	}

	// ----------------------------------------------------------------------- Resizing the window
	public void resizeWindow1(MouseEvent e) {
		String target = e.getTarget().toString();
		if (target.contains("id=rhT") || target.contains("id=rhR") || 
			target.contains("id=rhB") || target.contains("id=rhL")) {
			newX = e.getScreenX();
			newY = e.getScreenY();
		}
	}

	public void resizeWindow2(MouseEvent e) {
		Stage stage = (Stage) maxBtn.getScene().getWindow();
		if (newX != -1 && newY != -1) {
			switch (e.getTarget().toString().substring(10, 17)) {
			case "id=rhT1":
				resize(stage, e, 'T');
				break;
			case "id=rhB1":
				resize(stage, e, 'B');
				break;
			case "id=rhL1":
				resize(stage, e, 'L');
				break;
			case "id=rhR1":
				resize(stage, e, 'R');
				break;
			case "id=rhTL":
				resize(stage, e, 'T');
				resize(stage, e, 'L');
				break;
			case "id=rhTR":
				resize(stage, e, 'T');
				resize(stage, e, 'R');
				break;
			case "id=rhBL":
				resize(stage, e, 'B');
				resize(stage, e, 'L');
				break;
			case "id=rhBR":
				resize(stage, e, 'B');
				resize(stage, e, 'R');
				break;
			default:
				System.err.println("Not resize bar");
			}
		} else {
			System.err.println("Invalid newX and or newY");
		}
	}

	private void resize(Stage stage, MouseEvent e, char location) {
		switch (location) {
		case 'T':
			if (stage.getHeight() + (stage.getY() - e.getScreenY()) < stage.getMinHeight()) {
			} else {
				stage.setHeight(stage.getHeight() + (stage.getY() - e.getScreenY()));
				stage.setY(e.getScreenY());
				rhR1.setHeight(stage.getHeight() + (stage.getY() - e.getScreenY()) - 28);
				rhL1.setHeight(stage.getHeight() + (stage.getY() - e.getScreenY()) - 28);
			}
			break;
		case 'R':
			if (e.getScreenX() - stage.getX() < stage.getMinWidth()) {
			} else {
				stage.setWidth(e.getScreenX() - stage.getX());
				rhT1.setWidth(e.getScreenX() - stage.getX() - 16);
				rhB1.setWidth(e.getScreenX() - stage.getX() - 16);
				moveHandle.setWidth(e.getScreenX() - stage.getX());
			}
			break;
		case 'B':
			if (e.getScreenY() - stage.getY() < stage.getMinHeight()) {
			} else {
				stage.setHeight(e.getScreenY() - stage.getY());
				rhR1.setHeight(e.getScreenY() - stage.getY() - 28);
				rhL1.setHeight(e.getScreenY() - stage.getY() - 28);
			}
			break;
		case 'L':
			if (stage.getWidth() + (stage.getX() - e.getScreenX()) < stage.getMinWidth()) {
			} else {
				stage.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()));
				stage.setX(e.getScreenX());
				rhT1.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()) - 16);
				rhB1.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()) - 16);
				moveHandle.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()));
			}
			break;
		default:
			System.err.println("Invalid location");
		}
	}

	// --------------------------------------------------------------------------- Changing scenes
	@FXML
	public AnchorPane scene, content;

	public void changeScene() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(currentScene));
			AnchorPane newScene = loader.load();

			scene.getChildren().clear();
			scene.getChildren().add(newScene);

			AnchorPane.setTopAnchor(newScene, 0.0);
            AnchorPane.setBottomAnchor(newScene, 0.0);
            AnchorPane.setLeftAnchor(newScene, 0.0);
            AnchorPane.setRightAnchor(newScene, 0.0);
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
