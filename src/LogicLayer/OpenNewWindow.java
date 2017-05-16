package LogicLayer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Thomas on 11-05-2017.
 */
public class OpenNewWindow {


     void newWindow(String windowName)
    {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/UILayer/" + windowName));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Second window");
            stage.setScene(new Scene(root1));
            stage.show();


        }catch (Exception e) {
            System.out.println("Cant load window");
        }
    }
}
