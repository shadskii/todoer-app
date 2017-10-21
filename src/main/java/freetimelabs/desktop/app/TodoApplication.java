package freetimelabs.desktop.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodoApplication extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void init() throws Exception
    {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/MainScreen.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Todoer");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
    }
}
