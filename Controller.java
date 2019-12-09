package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField input_world;

    @FXML
    private void submit(ActionEvent event){
        System.out.println("submit");
    }

}
