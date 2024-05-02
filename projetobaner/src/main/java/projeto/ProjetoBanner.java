package projeto;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class ProjetoBanner extends Application {

    @FXML
    private StackPane root;

    @FXML
    private StackPane presentationPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Button selectImagesButton;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("projeto_banner.fxml"));
            StackPane root = loader.load();

            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Apresentação de Imagens");
            primaryStage.setScene(scene);
            primaryStage.show();

            File initialImageFile = new File("imagem ufpb.png");
            if (initialImageFile.exists() && !initialImageFile.isDirectory()) {
                Image initialImage = new Image(initialImageFile.toURI().toString());
                imageView.setImage(initialImage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void selectImages() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Selecione o diretório das imagens");
        File selectedDirectory = directoryChooser.showDialog(selectImagesButton.getScene().getWindow());
        if (selectedDirectory != null) {
            File[] imageFiles = selectedDirectory.listFiles((dir, name) ->
                    name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));

            if (imageFiles != null && imageFiles.length > 0) {
                // Iniciar a apresentação de imagens
                ImageSlideShow imageSlideShow = new ImageSlideShow((Stage) presentationPane.getScene().getWindow(), imageFiles);
                imageSlideShow.start();
            } else {
                System.out.println("Nenhuma imagem encontrada no diretório selecionado.");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}