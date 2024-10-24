package org.example.javalabfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlag {
    public static void start(Stage stage, Stage prevStage) {
        ToggleGroup topStripeGroup = new ToggleGroup();
        ToggleGroup middleStripeGroup = new ToggleGroup();
        ToggleGroup bottomStripeGroup = new ToggleGroup();

        String[] colors = { "Красный", "Зелёный", "Синий", "Жёлтый", "Белый" };

        Label topLabel = new Label("Верхняя полоса:");
        VBox topStripeBox = createColorSelector(colors, topStripeGroup);

        Label middleLabel = new Label("Средняя полоса:");
        VBox middleStripeBox = createColorSelector(colors, middleStripeGroup);

        Label bottomLabel = new Label("Нижняя полоса:");
        VBox bottomStripeBox = createColorSelector(colors, bottomStripeGroup);

        Button drawButton = new Button("Нарисовать");
        Label resultLabel = new Label();

        drawButton.setOnAction(event -> {
            String topColor = getSelectedColor(topStripeGroup);
            String middleColor = getSelectedColor(middleStripeGroup);
            String bottomColor = getSelectedColor(bottomStripeGroup);

            if (topColor != null && middleColor != null && bottomColor != null) {
                resultLabel.setText("Флаг: " + topColor + ", " + middleColor + ", " + bottomColor);
            } else {
                resultLabel.setText("Выберите цвета для всех полос.");
            }
        });

        Button backButton = new Button("Назад");
        backButton.setOnAction(actionEvent -> {
            stage.close();
            prevStage.show();
        });

        VBox root = new VBox(10, backButton, topLabel, topStripeBox, middleLabel, middleStripeBox, bottomLabel, bottomStripeBox, drawButton, resultLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Текстовый флаг");
        stage.setResizable(false);  // отлючает изменение размеров
        stage.show();
    }

    private static VBox createColorSelector(String[] colors, ToggleGroup group) {
        VBox box = new VBox(5);
        for (String color : colors) {
            RadioButton radioButton = new RadioButton(color);
            radioButton.setToggleGroup(group);
            box.getChildren().add(radioButton);
        }

        return box;
    }

    private static String getSelectedColor(ToggleGroup group) {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();

        if (selectedRadioButton != null) {
            return selectedRadioButton.getText();
        }

        return null;  // Если цвет не выбран
    }
}
