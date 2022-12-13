

 package cr.ac.ucenfotec;

 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;


 public class Main extends Application {

 public void start(Stage primaryStage) throws Exception{
 Parent root = FXMLLoader.load(getClass().getResource("ui/InicioBienvenida.fxml"));
 primaryStage.setTitle("Mundialito Cenfotec");
 primaryStage.setScene(new Scene(root, 430, 380));
 //primaryStage.setScene(new Scene(root, 1300, 800));
 primaryStage.show();
 }

 public static void main(String[] args) {
 launch(args);
 }
 }


//MAIN PARA IMPRIMIR EN CONSOLA

/**
package cr.ac.ucenfotec;

import cr.ac.ucenfotec.tl.Controller;

public class Main {

    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        controller.start();
    }
}

 */
