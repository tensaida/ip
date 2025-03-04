package drake.gui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A JavaFX component displaying a chat message.
 */
public class ChatMessage extends VBox {
    @FXML
    private Label name;

    @FXML
    private Label message;

    @FXML
    private ImageView profilePicture;

    @FXML
    private HBox header;

    private ChatMessage(String name, String text, Image img, boolean isWhiteBackground) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Window.class.getResource("/view/ChatMessage.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.name.setText(name);
        message.setText(text);
        profilePicture.setImage(img);
        if (isWhiteBackground) {
            message.setStyle("-fx-text-fill : #000000; -fx-background-color: white;");
        }
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(header.getChildren());
        Collections.reverse(tmp);
        header.getChildren().setAll(tmp);
        header.setAlignment(Pos.TOP_LEFT);
        this.setAlignment(Pos.TOP_LEFT);
    }

    public static ChatMessage getUserDialog(String text, Image img) {
        return new ChatMessage("Lost Soul", text, img, true);
    }

    public static ChatMessage getDrakeDialog(String text, Image img) {
        var db = new ChatMessage("Drake", text, img, false);
        db.flip();
        return db;
    }

}
