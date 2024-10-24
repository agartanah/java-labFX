package org.example.javalabfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.javalabfx.restaurant.RestaurantOrder;

import java.io.IOException;

public class Main extends Application {
    final Button buttonTask1 = new Button("Перекидыватель строк");
    final Button buttonTask2 = new Button("Аннигиляторная пушка");
    final Button buttonTask3 = new Button("Сделать заказ в ресторане");
    final Button buttonTask4 = new Button("КАЛькулятор");
    final Button buttonTask5 = new Button("Текстовый флаг");
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

        buttonTask3.setOnAction(actionEvent -> {
            RestaurantOrder.start(new Stage(), stage);

            stage.close();
        });

        buttonTask4.setOnAction(actionEvent -> {
            Calculator.start(new Stage(), stage);

            stage.close();
        });

        buttonTask5.setOnAction(actionEvent -> {
            TextFlag.start(new Stage(), stage);

            stage.close();
        });

        taskButtonsContainer.getChildren().add(buttonTask1);
        taskButtonsContainer.getChildren().add(buttonTask2);
        taskButtonsContainer.getChildren().add(buttonTask3);
        taskButtonsContainer.getChildren().add(buttonTask4);
        taskButtonsContainer.getChildren().add(buttonTask5);

        Scene scene = new Scene(taskButtonsContainer, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}