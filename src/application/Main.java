package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// El BorderPane con sus dos grupos de elementos
			BorderPane root = new BorderPane();

			Group group1 = new Group();
			Group group2 = new Group();
			Scene scene = new Scene(root, 800, 600);

			// Muestro en la consola dónde estoy en cada click del mouse
			getPosition(scene);

			// Un título (este mismo)
			primaryStage.setTitle("UD1 Caso 1 - Alejandro Gonzalez");

			// Añado los dos grupos al nodo raíz
			root.getChildren().add(group1);
			root.getChildren().add(group2);

			// Primer grupo: tres líneas cambiando su posición, grosor y color
			Line line1 = new Line(0, 0, 400, 600);
			line1.setStroke(Color.DARKRED);
			line1.setStrokeWidth(5);

			Line line2 = new Line(0, 600, 400, 0);
			line2.setStroke(Color.INDIGO);
			line2.setStrokeWidth(5);

			Line line3 = new Line(200, 0, 200, 600);
			line3.setStroke(Color.DARKMAGENTA);
			line3.setStrokeWidth(5);

			group1.getChildren().add(line1);
			group1.getChildren().add(line2);
			group1.getChildren().add(line3);

			// Segundo grupo: un pentágono al que le paso sus cinco puntos, color de relleno
			// y color de contorno
			Polygon pentagon = new Polygon();
			pentagon.getPoints().addAll(550.0, 25.0, 500.0, 125.0, 625.0, 225.0, 750.0, 125.0, 700.0, 25.0);
			pentagon.setFill(Color.AZURE);
			pentagon.setStroke(Color.BROWN);
			// Actualmente queda con la punta hacia abajo: al rotarlo 180 grados, lo dejo
			// con la punta hacia arriba
			pentagon.setRotate(180);

			// Un círculo al que le paso coordenadas del centro, medida del radio, color de
			// relleno y color de contorno
			Circle circle = new Circle();
			circle.setFill(Color.DARKSEAGREEN);
			circle.setStroke(Color.DARKVIOLET);
			circle.setCenterX(400.0);
			circle.setCenterY(300.0);
			circle.setRadius(100);

			// Un rectángulo al que le paso la posición de su esquina superior izquierda,
			// altura, anchura, color de relleno y color de contorno
			Rectangle square = new Rectangle();
			square.setX(500);
			square.setY(450);
			square.setWidth(250);
			square.setHeight(100);
			square.setFill(Color.DARKGREY);
			square.setStroke(Color.CYAN);

			// Añado al segundo grupo los tres nuevos objetos
			group2.getChildren().add(pentagon);
			group2.getChildren().add(circle);
			group2.getChildren().add(square);

			// Pinto la escena
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Este método me saca en la consola las coordenadas de la escena al hacer click
	 * sobre cualquier punto que esté
	 */
	public void getPosition(Scene scene) {
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("(" + event.getSceneX() + ", " + event.getSceneY() + ")");
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
