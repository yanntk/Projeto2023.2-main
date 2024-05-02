package projeto;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class ImageSlideShow {
    private final Stage stage;
    private final File[] imageFiles;
    private int currentIndex = 0;
    private final ImageView imageView = new ImageView();

    public ImageSlideShow(Stage stage, File[] imageFiles) {
        this.stage = stage;
        this.imageFiles = imageFiles;
    }

    public void start() {
        stage.setFullScreen(true);
        stage.setFullScreenExitHint(""); // Remover a mensagem de saída do modo tela cheia

        // Configurar o botão de saída do modo tela cheia
        Button exitFullScreenButton = new Button("Sair do Modo Tela Cheia");
        exitFullScreenButton.setOnAction(event -> stage.setFullScreen(false));

        // Layout para a tela cheia
        StackPane fullScreenPane = new StackPane();
        fullScreenPane.getChildren().add(imageView);
        StackPane.setAlignment(exitFullScreenButton, javafx.geometry.Pos.BOTTOM_CENTER);
        fullScreenPane.getChildren().add(exitFullScreenButton);

        // Ajustar a posição do botão
        exitFullScreenButton.layoutYProperty().bind(stage.heightProperty().subtract(exitFullScreenButton.heightProperty()).subtract(10));
        exitFullScreenButton.layoutXProperty().bind(stage.widthProperty().subtract(exitFullScreenButton.widthProperty()).divide(2));

        // Criar a cena em tela cheia
        Scene fullScreenScene = new Scene(fullScreenPane);

        // Adicionar a cena em tela cheia ao palco
        stage.setScene(fullScreenScene);

        // Exibir as imagens em loop
        showNextImage();
    }

    private void showNextImage() {
        if (currentIndex >= imageFiles.length) {
            currentIndex = 0; // Voltar ao início do loop
        }
        File imageFile = imageFiles[currentIndex];
        Image image = new Image(imageFile.toURI().toString());
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(stage.getWidth());
        imageView.setFitHeight(stage.getHeight());
        imageView.setLayoutX((stage.getWidth() - imageView.getBoundsInParent().getWidth()) / 2);
        imageView.setLayoutY((stage.getHeight() - imageView.getBoundsInParent().getHeight()) / 2);

        // Atualizar o índice para a próxima imagem
        currentIndex++;

        // Agendar a exibição da próxima imagem após 5 segundos (5000 milissegundos)
        javafx.animation.KeyFrame keyFrame = new javafx.animation.KeyFrame(javafx.util.Duration.seconds(5), event -> showNextImage());
        javafx.animation.Timeline timeline = new javafx.animation.Timeline(keyFrame);
        timeline.play();
    }
}
