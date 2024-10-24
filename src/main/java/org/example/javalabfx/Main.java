package org.example.javalabfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private final Button buttonTask1 = new Button("Перекидыватель строк");
    private final Button buttonTask2 = new Button("Аннигиляция виджетов");
    private final Button buttonTask3 = new Button();
    private final Button buttonTask4 = new Button();
    private final Button buttonTask5 = new Button();


    @Override
    public void start(Stage stage) throws IOException {
        VBox taskButtonsContainer = new VBox(10);

        taskButtonsContainer.setAlignment(Pos.CENTER);

        buttonTask1.setOnAction(actionEvent -> {
            Shifter.start(new Stage(), stage);

            stage.close();
        });

        taskButtonsContainer.getChildren().add(buttonTask1);

        Scene scene = new Scene(taskButtonsContainer, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}