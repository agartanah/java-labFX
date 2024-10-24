package org.example.javalabfx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Shifter {
    private static boolean isForward = true;  // Флаг направления стрелки
    static final TextField textField1 = new TextField();
    static final TextField textField2 = new TextField();

    static final Button switchButton = new Button("→");
    static final Button backButton = new Button("Назад");

    static final BorderPane switchButtonContainer = new BorderPane();

    public static void start(Stage stage, Stage prevStage) {
        switchButtonContainer.setCenter(switchButton);

        switchButton.setRotate(90);

        switchButton.setOnAction(actionEvent -> {
            if (isForward) {
                textField2.setText(textField1.getText());
                textField1.clear();

                switchButton.setText("←");
            } else {
                textField1.setText(textField2.getText());
                textField2.clear();

                switchButton.setText("→");
            }
            // Меняем флаг направления
            isForward = !isForward;
        });

        backButton.setOnAction(actionEvent -> {
            stage.close();
            prevStage.show();
        });

        VBox root = new VBox(10, backButton, textField1, switchButtonContainer, textField2);

        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("Word Switcher");
        stage.setScene(scene);
        stage.show();
    }
}
