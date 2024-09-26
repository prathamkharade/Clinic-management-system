package com.example.starttrial;

import com.example.starttrial.util.SpringFXMLLoader;
import com.zaxxer.hikari.HikariDataSource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.starttrial")
@ComponentScan(basePackages = {"com.example.starttrial", "com.example.starttrial.controller", "com.example.starttrial.util"})
public class StarttrialApplication extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Autowired
	private HikariDataSource dataSource;

	public void closeDatabaseConnection() {
		if (dataSource != null) {
			dataSource.close();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		ApplicationContext context = SpringApplication.run(StarttrialApplication.class);
		SpringFXMLLoader fxmlLoader = new SpringFXMLLoader(context);

		FXMLLoader loader = fxmlLoader.load(getClass().getResource("/fxml/Page1-landing.fxml"));
		Scene scene = new Scene(loader.load(), 1072, 720);

		stage.setTitle("Dental Clinic");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				closeDatabaseConnection();
				Platform.exit();
				System.exit(0);
			}
		});
	}

}
