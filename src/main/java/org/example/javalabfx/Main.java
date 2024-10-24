package org.example.javalabfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    final Button buttonTask1 = new Button("Перекидыватель строк");
    final Button buttonTask2 = new Button("Аннигиляторная пушка");
    final Button buttonTask3 = new Button();
    final Button buttonTask4 = new Button();
    final Button buttonTask5 = new Button();
    final VBox taskButtonsContainer = new VBox(10);

    @Override
    public void start(Stage stage) throws IOException {
        taskButtonsContainer.setAlignment(Pos.CENTER);

        buttonTask1.setOnAction(actionEvent -> {
            Shifter.start(new Stage(), stage);

            stage.close();
        });

        buttonTask2.setOnAction(actionEvent -> {
            DestroyWidgets.start(new Stage(), stage);

            stage.close();
        });

        taskButtonsContainer.getChildren().add(buttonTask1);
        taskButtonsContainer.getChildren().add(buttonTask2);

        Scene scene = new Scene(taskButtonsContainer, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}