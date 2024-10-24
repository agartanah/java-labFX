package org.example.javalabfx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator {
    public static void start(Stage stage, Stage prevStage) {
        TextField numField1 = new TextField();
        TextField numField2 = new TextField();

        Label resultLabel = new Label("Результат: ");

        Button addButton = new Button("+");
        addButton.setPrefSize(50, 50);
        addButton.setStyle("-fx-font-size: 20px;");

        Button subtractButton = new Button("-");
        subtractButton.setPrefSize(50, 50);
        subtractButton.setStyle("-fx-font-size: 20px;");

        Button multiplyButton = new Button("*");
        multiplyButton.setPrefSize(50, 50);
        multiplyButton.setStyle("-fx-font-size: 20px;");

        Button divideButton = new Button("/");
        divideButton.setPrefSize(50, 50);
        divideButton.setStyle("-fx-font-size: 20px;");

        Button backButton = new Button("Назад");
        backButton.setOnAction(actionEvent -> {
            stage.close();
            prevStage.show();
        });

        addButton.setOnAction(event -> {
            double num1 = getNumberFromField(numField1);
            double num2 = getNumberFromField(numField2);
            double result = num1 + num2;
            resultLabel.setText("Результат: " + result);
        });

        subtractButton.setOnAction(event -> {
            double num1 = getNumberFromField(numField1);
            double num2 = getNumberFromField(numField2);
            double result = num1 - num2;
            resultLabel.setText("Результат: " + result);
        });

        multiplyButton.setOnAction(event -> {
            double num1 = getNumberFromField(numField1);
            double num2 = getNumberFromField(numField2);
            double result = num1 * num2;
            resultLabel.setText("Результат: " + result);
        });

        divideButton.setOnAction(event -> {
            double num1 = getNumberFromField(numField1);
            double num2 = getNumberFromField(numField2);
            if (num2 == 0) {
                showError("Ошибка", "Деление на 0 невозможно!");
            } else {
                double result = num1 / num2;
                resultLabel.setText("Результат: " + result);
            }
        });

        HBox number1 = new HBox(20, new Label("Число 1:"), numField1);
        HBox number2 = new HBox(20, new Label("Число 2:"), numField2);

        HBox addAndSubtract = new HBox(20, addButton, subtractButton);
        addAndSubtract.setAlignment(Pos.CENTER);

        HBox multiplyAndDivide= new HBox(20, multiplyButton, divideButton);
        multiplyAndDivide.setAlignment(Pos.CENTER);

        HBox result = new HBox(20, resultLabel);

        VBox mainContainer = new VBox(20, backButton, number1, number2, addAndSubtract, multiplyAndDivide, result);
        mainContainer.setStyle("-fx-padding: 20px;");
        mainContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainContainer, 270, 250);
        stage.setScene(scene);
        stage.setTitle("КАЛькулятор");
        stage.show();
    }

    private static double getNumberFromField(TextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            showError("Ошибка ввода", "Пожалуйста, введите корректное число.");
            return 0;
        }
    }

    private static void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
