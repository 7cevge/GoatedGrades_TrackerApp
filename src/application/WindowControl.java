package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class WindowControl {
	@FXML
	private Button minimizeB, maximizeB;

	@FXML
	private AnchorPane titleBar;

	@FXML
	private Rectangle Trs, Rrs, Brs, Lrs;

	private double newX = -1, newY = -1;

	/* The 3 window buttons */
	public void minimize(ActionEvent e) {
		Stage stage = (Stage) minimizeB.getScene().getWindow();
		stage.setIconified(true);
	}

	public void maximize(ActionEvent e) {
		Stage stage = (Stage) maximizeB.getScene().getWindow();
		if (stage.isMaximized()) {
			stage.setMaximized(false);
		} else {
			stage.setMaximized(true);
		}
	}

	public void close(ActionEvent e) {
		Platform.exit();
	}

	/* Moving the window around the screen */
	public void moveWindow1(MouseEvent e) {
		String target = e.getTarget().toString();
		if (target.contains("Rectangle")) {
		} else {
			newX = e.getSceneX();
			newY = e.getSceneY();
		}
	}

	public void moveWindow2(MouseEvent e) {
		String target = e.getTarget().toString();
		Stage stage = (Stage) titleBar.getScene().getWindow();
		if (target.contains("Rectangle")) {
		} else if (newX != -1 && newY != -1) {
			stage.setX(e.getScreenX() - newX);
			stage.setY(e.getScreenY() - newY);
		} else {
			System.err.println("invalid newX and or newY");
		}
	}

	/* Resizing the window */
	public void resizeWindow1(MouseEvent e) {
		String target = e.getTarget().toString();
		if (target.contains("id=TLrs") || target.contains("id=Trs") || target.contains("TRrs")
				|| target.contains("id=SRrs") || target.contains("id=Rrs") || target.contains("id=BRrs")
				|| target.contains("id=Brs") || target.contains("id=BLrs") || target.contains("id=Lrs")
				|| target.contains("id=SLrs")) {
			newX = e.getScreenX();
			newY = e.getScreenY();
		}
	}

	public void resizeWindow2(MouseEvent e) {
		Stage stage = (Stage) titleBar.getScene().getWindow();
		if (newX != -1 && newY != -1) {
			switch (e.getTarget().toString().substring(10, 17)) {
			case "id=TLrs":
				resize(stage, e, 'T');
				resize(stage, e, 'L');
				break;
			case "id=Trs,":
				resize(stage, e, 'T');
				break;
			case "id=TRrs":
				resize(stage, e, 'T');
				resize(stage, e, 'R');
				break;
			case "id=SRrs":
				resize(stage, e, 'R');
				break;
			case "id=Rrs,":
				resize(stage, e, 'R');
				break;
			case "id=BRrs":
				resize(stage, e, 'B');
				resize(stage, e, 'R');
				break;
			case "id=Brs,":
				resize(stage, e, 'B');
				break;
			case "id=BLrs":
				resize(stage, e, 'B');
				resize(stage, e, 'L');
				break;
			case "id=Lrs,":
				resize(stage, e, 'L');
				break;
			case "id=SLrs":
				resize(stage, e, 'L');
				break;
			default:
				System.err.println("not resize bar");
			}
		} else {
			System.err.println("invalid newX and or newY");
		}
	}

	private void resize(Stage stage, MouseEvent e, char loc) {
		switch (loc) {
		case 'T':
			if (stage.getHeight() + (stage.getY() - e.getScreenY()) < stage.getMinHeight()) {
			} else {
				stage.setHeight(stage.getHeight() + (stage.getY() - e.getScreenY()));
				stage.setY(e.getScreenY());
				Rrs.setHeight(stage.getHeight() + (stage.getY() - e.getScreenY()) - 28);
				Lrs.setHeight(stage.getHeight() + (stage.getY() - e.getScreenY()) - 28);
			}
			break;
		case 'R':
			if (e.getScreenX() - stage.getX() < stage.getMinWidth()) {
			} else {
				stage.setWidth(e.getScreenX() - stage.getX());
				Trs.setWidth(e.getScreenX() - stage.getX() - 8);
				Brs.setWidth(e.getScreenX() - stage.getX() - 8);
			}
			break;
		case 'B':
			if (e.getScreenY() - stage.getY() < stage.getMinHeight()) {
			} else {
				stage.setHeight(e.getScreenY() - stage.getY());
				Rrs.setHeight(e.getScreenY() - stage.getY() - 28);
				Lrs.setHeight(e.getScreenY() - stage.getY() - 28);
			}
			break;
		case 'L':
			if (stage.getWidth() + (stage.getX() - e.getScreenX()) < stage.getMinWidth()) {
			} else {
				stage.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()));
				stage.setX(e.getScreenX());
				Trs.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()) - 8);
				Brs.setWidth(stage.getWidth() + (stage.getX() - e.getScreenX()) - 8);
			}
			break;
		default:
			System.err.println("invalid loc");
		}
	}
}
