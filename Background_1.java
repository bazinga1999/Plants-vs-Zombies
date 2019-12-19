package application;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

import javafx.geometry.*;
import javafx.scene.Group;



public class Background_1 extends Application {

	Scene pause_menue;
	Scene playground;
	Scene level1_scene;
	Scene level2_scene;
	Scene level3_scene;
	
	private int count = 0;
	Label timer = new Label(Integer.toString(count));


	Scene scene;

	public void start(Stage stage) {



		try {

			make_menue(stage);

			stage.show();
		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	private void make_menue(Stage stage) throws IOException {



		
		// set title for the stage
		stage.setTitle("Plants vs Zombies");

		
//making pause menue

		//making save button
		Button save_game_button = new Button();
		save_game_button.setText("Save Game");
		save_game_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Game Saved");
			}
		});
		save_game_button.setTranslateX(0);
		save_game_button.setTranslateY(180);

		
		
		//making exit button
		Button exit_game_button = new Button();
		exit_game_button.setText("Exit Game");
		exit_game_button.setOnMouseClicked((e) -> {
			try {
				count = 0;
				make_menue(stage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		exit_game_button.setTranslateX(0);
		exit_game_button.setTranslateY(180);

		
		
		//making continue button
		Button continue_button = new Button();
		continue_button.setText("Continue");
		continue_button.setAlignment(Pos.CENTER);
		continue_button.setTranslateX(0);
		continue_button.setTranslateY(230);

		continue_button.setOnMouseClicked((e) -> {
			try {
				make_playground(stage, pause_menue);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		
		
		//adding images and adding to boxes
		HBox button_box = new HBox(save_game_button, exit_game_button);
		button_box.setSpacing(30);
		button_box.setAlignment(Pos.CENTER);
		StackPane pane = new StackPane();
		pause_menue = new Scene(pane, 450, 675);

		FileInputStream input_menu = new FileInputStream("C:\\Users\\pruty\\Desktop\\AP projec\\menu.jpg");
		Image image_menu = new Image(input_menu);
		BackgroundImage menu_backgroundimage = new BackgroundImage(image_menu, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		Background background_pause_menu = new Background(menu_backgroundimage);
		pane.setBackground(background_pause_menu);

		input_menu.close();
		input_menu = new FileInputStream("C:\\Users\\pruty\\Desktop\\AP projec\\zombie2.png");
		Image zombie = new Image(input_menu);
		ImageView img_zombie = new ImageView(zombie);

		HBox zomb_box = new HBox();
		zomb_box.getChildren().add(img_zombie);
		zomb_box.setAlignment(Pos.CENTER);

		pane.getChildren().add(zomb_box);
		pane.getChildren().add(button_box);
		pane.getChildren().add(continue_button);

		
		
		

// making main menue
		
		Image button_image = new Image("http://icons.iconarchive.com/icons/icons8/halloween/512/zombie-icon.png");
		Image button_image1 = new Image("http://icons.iconarchive.com/icons/icons8/halloween/512/zombie-icon.png");
		Image button_image2 = new Image("http://icons.iconarchive.com/icons/icons8/halloween/512/zombie-icon.png");
		Image button_image3 = new Image("http://icons.iconarchive.com/icons/icons8/halloween/512/zombie-icon.png");

		ImageView imageView = new ImageView(button_image);
		ImageView imageviewplant = new ImageView(button_image1);
		ImageView imageView1 = new ImageView(button_image2);
		ImageView imageviewplant1 = new ImageView(button_image3);

		imageView.setFitWidth(60);
		imageView.setFitHeight(40);
		imageviewplant.setFitWidth(60);
		imageviewplant.setFitHeight(40);
		imageView1.setFitWidth(60);
		imageView1.setFitHeight(40);
		imageviewplant1.setFitWidth(60);
		imageviewplant1.setFitHeight(40);
		
		
		// new_game_button
		Button new_game_button = new Button();
		new_game_button.setText("New Game");
		new_game_button.setGraphic(imageView);
		new_game_button.setOnMouseClicked((e) -> {
			try {
				count = 0;
				make_playground(stage, pause_menue);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		new_game_button.setStyle("-fx-background-color: #ff1111");
		new_game_button.setTranslateX(300);
		new_game_button.setTranslateY(320);
		new_game_button.setMaxSize(300, 50);

		
		
		// load_game_button
		Button load_game_button = new Button();
		load_game_button.setText("Load Game");
		load_game_button.setGraphic(imageviewplant);
		load_game_button.setOnMouseClicked((e) -> {
			try {
				count = 0;
				make_playground(stage, pause_menue);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		load_game_button.setStyle("-fx-background-color: #808080");
		load_game_button.setTranslateX(300);
		load_game_button.setTranslateY(270);
		load_game_button.setMaxSize(300, 50);

		
		
		// Choose_level_button
		Button choose_level_button = new Button();
		choose_level_button.setText("Choose Level");
		choose_level_button.setGraphic(imageView1);
		choose_level_button.setOnMouseClicked((e) -> {
			try {
				make_choose_level(stage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		choose_level_button.setStyle("-fx-background-color: #ff1111");
		choose_level_button.setTranslateX(300);
		choose_level_button.setTranslateY(220);
		choose_level_button.setMaxSize(300, 50);

		
		
		// exit_button
		Button exit_button = new Button();
		exit_button.setText("Exit Game");
		exit_button.setGraphic(imageviewplant1);
		exit_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Exit Game");
			}
		});
		exit_button.setTranslateX(300);
		exit_button.setTranslateY(170);
		exit_button.setMaxSize(300, 50);
		exit_button.setStyle("-fx-background-color: #808080");
		exit_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(1);
			}
		});

		
		//making background
		VBox vbox = new VBox(new_game_button, load_game_button, choose_level_button, exit_button);
		vbox.setSpacing(100);
		vbox.setAlignment(Pos.CENTER);

		FileInputStream input = new FileInputStream("C:\\Users\\pruty\\Desktop\\AP projec\\background.jpg");
		Image image = new Image(input);
		BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundimage);
		vbox.setBackground(background);

		scene = new Scene(vbox, 1270, 950);
		stage.setScene(scene);

	}

	private void make_choose_level(Stage stage) throws FileNotFoundException {



		
		/// level 1
		FileInputStream level_input = new FileInputStream(
				"C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\level1.jpg");
		StackPane first = new StackPane();
		Image level1_image = new Image(level_input);
		BackgroundImage level1_backgroundimage = new BackgroundImage(level1_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Background level1 = new Background(level1_backgroundimage);
		first.setBackground(level1);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\right.png");
		Image right_image = new Image(level_input);
		BackgroundImage right_background = new BackgroundImage(right_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background right_back = new Background(right_background);
		Button right_button = new Button();
		right_button.setOnAction(e -> stage.setScene(level2_scene));
		right_button.setBackground(right_back);
		right_button.setMinSize(80, 80);
		right_button.setTranslateX(110);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\left.png");
		Image left_image = new Image(level_input);
		BackgroundImage left_background = new BackgroundImage(left_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background left_back = new Background(left_background);
		Button left_button = new Button();
		left_button.setBackground(left_back);
		left_button.setMinSize(80, 80);
		left_button.setTranslateX(-110);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\level1_name.png");
		Image level1_name_image = new Image(level_input);
		BackgroundImage level1_background = new BackgroundImage(level1_name_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background level1_back = new Background(level1_background);
		Button level1_button = new Button();
		level1_button.setOnMouseClicked((e) -> {
			try {
				make_playground(stage, pause_menue);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		level1_button.setBackground(level1_back);
		level1_button.setMinSize(100, 100);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\back.png");
		Image back_image1 = new Image(level_input);
		BackgroundImage back_background1 = new BackgroundImage(back_image1, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background back_back1 = new Background(back_background1);
		Button back_button1 = new Button();
		back_button1.setOnAction(e -> stage.setScene(scene));
		back_button1.setBackground(back_back1);
		back_button1.setMinSize(100, 100);
		back_button1.setTranslateX(-170);
		back_button1.setTranslateY(-310);

		HBox arrow_box1 = new HBox();
		arrow_box1.getChildren().add(left_button);
		arrow_box1.getChildren().add(level1_button);
		arrow_box1.getChildren().add(right_button);
		arrow_box1.setAlignment(Pos.CENTER);

		first.getChildren().add(arrow_box1);
		first.getChildren().add(back_button1);

		level1_scene = new Scene(first, 450, 750);
		stage.setScene(level1_scene);

		
		
		/// level2
		level_input = new FileInputStream(
				"C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\pruty\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\AP projec\\\\\\\\level2.jpg");
		StackPane second = new StackPane();
		Image level2_image = new Image(level_input);
		BackgroundImage level2_backgroundimage = new BackgroundImage(level2_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Background level2 = new Background(level2_backgroundimage);
		second.setBackground(level2);

		level_input = new FileInputStream(
				"C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\pruty\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\AP projec\\\\\\\\right.png");
		Image right_image2 = new Image(level_input);
		BackgroundImage right_background2 = new BackgroundImage(right_image2, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background right_back2 = new Background(right_background2);
		Button right_button2 = new Button();
		right_button2.setOnAction(e -> stage.setScene(level3_scene));
		right_button2.setBackground(right_back2);
		right_button2.setMinSize(80, 80);
		right_button2.setTranslateX(110);

		level_input = new FileInputStream(
				"C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\pruty\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\AP projec\\\\\\\\left.png");
		Image left_image2 = new Image(level_input);
		BackgroundImage left_background2 = new BackgroundImage(left_image2, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background left_back2 = new Background(left_background2);
		Button left_button2 = new Button();
		left_button2.setOnAction(e -> stage.setScene(level1_scene));
		left_button2.setBackground(left_back2);
		left_button2.setMinSize(80, 80);
		left_button2.setTranslateX(-110);

		level_input = new FileInputStream(
				"C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\pruty\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\AP projec\\\\\\\\level2_name.png");
		Image level2_name_image = new Image(level_input);
		BackgroundImage level2_background = new BackgroundImage(level2_name_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background level2_back = new Background(level2_background);
		Button level2_button = new Button();
		level2_button.setOnMouseClicked((e) -> {
			try {
				make_playground(stage, pause_menue);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		level2_button.setBackground(level2_back);
		level2_button.setMinSize(100, 100);

		level_input = new FileInputStream(
				"C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\pruty\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\AP projec\\\\\\\\back.png");
		Image back_image2 = new Image(level_input);
		BackgroundImage back_background2 = new BackgroundImage(back_image2, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background back_back2 = new Background(back_background2);
		Button back_button2 = new Button();
		back_button2.setOnAction(e -> stage.setScene(scene));
		back_button2.setBackground(back_back2);
		back_button2.setMinSize(100, 100);
		back_button2.setTranslateX(-170);
		back_button2.setTranslateY(-310);

		HBox arrow_box2 = new HBox();
		arrow_box2.getChildren().add(left_button2);
		arrow_box2.getChildren().add(level2_button);
		arrow_box2.getChildren().add(right_button2);
		arrow_box2.setAlignment(Pos.CENTER);

		second.getChildren().add(arrow_box2);
		second.getChildren().add(back_button2);

		level2_scene = new Scene(second, 450, 750);

		
		
		// level 3
		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\level3.png");
		StackPane third = new StackPane();
		Image level3_image = new Image(level_input);
		BackgroundImage level3_backgroundimage = new BackgroundImage(level3_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		Background level3 = new Background(level3_backgroundimage);
		third.setBackground(level3);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\right.png");
		Image right_image3 = new Image(level_input);
		BackgroundImage right_background3 = new BackgroundImage(right_image3, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background right_back3 = new Background(right_background3);
		Button right_button3 = new Button();
		right_button3.setOnAction(e -> stage.setScene(level3_scene));
		right_button3.setBackground(right_back3);
		right_button3.setMinSize(80, 80);
		right_button3.setTranslateX(110);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\left.png");
		Image left_image3 = new Image(level_input);
		BackgroundImage left_background3 = new BackgroundImage(left_image3, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background left_back3 = new Background(left_background3);
		Button left_button3 = new Button();
		left_button3.setOnAction(e -> stage.setScene(level2_scene));
		left_button3.setBackground(left_back3);
		left_button3.setMinSize(80, 80);
		left_button3.setTranslateX(-110);

		level_input = new FileInputStream(
				"C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\level3_name.png");
		Image level3_name_image = new Image(level_input);
		BackgroundImage level3_background = new BackgroundImage(level3_name_image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background level3_back = new Background(level3_background);
		Button level3_button = new Button();
		level3_button.setOnMouseClicked((e) -> {
			try {
				make_playground(stage, pause_menue);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		level3_button.setBackground(level3_back);
		level3_button.setMinSize(100, 100);

		level_input = new FileInputStream("C:\\\\\\\\Users\\\\\\\\pruty\\\\\\\\Desktop\\\\\\\\AP projec\\\\back.png");
		Image back_image3 = new Image(level_input);
		BackgroundImage back_background3 = new BackgroundImage(back_image3, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background back_back3 = new Background(back_background3);
		Button back_button3 = new Button();
		back_button3.setOnAction(e -> stage.setScene(scene));
		back_button3.setBackground(back_back3);
		back_button3.setMinSize(100, 100);
		back_button3.setTranslateX(-170);
		back_button3.setTranslateY(-310);

		HBox arrow_box3 = new HBox();
		arrow_box3.getChildren().add(left_button3);
		arrow_box3.getChildren().add(level3_button);
		arrow_box3.getChildren().add(right_button3);
		arrow_box3.setAlignment(Pos.CENTER);

		third.getChildren().add(arrow_box3);
		third.getChildren().add(back_button3);

		level3_scene = new Scene(third, 450, 750);

	}

	private void make_playground(Stage stage, Scene pause_menue) throws IOException {



		//importing images
		FileInputStream input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\pea_selection.png");
		Image peashooter = new Image(input);
		BackgroundImage pea_background = new BackgroundImage(peashooter, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background pea_back = new Background(pea_background);

		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\snowpea_selection.png");
		Image snowpea = new Image(input);
		BackgroundImage snowpea_background = new BackgroundImage(snowpea, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background snowpea_back = new Background(snowpea_background);

		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\repeater_selection.png");
		Image repeater = new Image(input);
		BackgroundImage repeater_background = new BackgroundImage(repeater, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background repeater_back = new Background(repeater_background);

		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\cherry_selection.png");
		Image cherrybomb = new Image(input);
		BackgroundImage cherry_background = new BackgroundImage(cherrybomb, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background cherry_back = new Background(cherry_background);

		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\mine_selection.png");
		Image potatomine = new Image(input);
		BackgroundImage potato_background = new BackgroundImage(potatomine, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background potato_back = new Background(potato_background);

		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\sunflower_selection.png");
		Image sunflower = new Image(input);
		BackgroundImage sunflower_background = new BackgroundImage(sunflower, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background sunflower_back = new Background(sunflower_background);

		
		
		//making peashooter side button
		Button pea_button = new Button();
		pea_button.setOnMouseClicked((e) -> {
			System.out.println("Pea shooter selected");
		});
		pea_button.setMinSize(80, 49);
		pea_button.setBackground(pea_back);

		
		
		//making snow peashooter side button
		Button snowpea_button = new Button();
		snowpea_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Snow Pea selected");
			}
		});
		snowpea_button.setMinSize(80, 49);
		snowpea_button.setBackground(snowpea_back);

		
		
		//making repeater side button
		Button repeater_button = new Button();
		repeater_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Repeater selected");
			}
		});
		repeater_button.setMinSize(80, 52);
		repeater_button.setBackground(repeater_back);

		
		
		//making cherry bomb side button
		Button cherry_button = new Button();
		cherry_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Cherry Bomb selected");
			}
		});
		cherry_button.setMinSize(80, 54);
		cherry_button.setBackground(cherry_back);

		
		
		
		//making potato side button
		Button potato_button = new Button();
		potato_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Potato Mine selected");
			}
		});
		potato_button.setMinSize(80, 54);
		potato_button.setBackground(potato_back);

		
		
		
		// making sunflower button
		Button sunflower_button = new Button();
		sunflower_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Sunflower selected");
			}
		});
		sunflower_button.setMinSize(80, 52);
		sunflower_button.setBackground(sunflower_back);

		
		//adding to boxes
		VBox plants_box = new VBox(pea_button, snowpea_button, repeater_button, cherry_button, potato_button,sunflower_button);
		plants_box.setAlignment(Pos.TOP_LEFT);
		plants_box.setTranslateY(-70);

		
		

		//making timer
		Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        incrementCount();
                    }

					private void incrementCount() {
					        count++;
					        timer.setText(Integer.toString(count));
					    						
					}
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
		
        thread.setDaemon(true);
        thread.start();
		
        timer.setStyle("-fx-background-color: #ffffff");
		timer.setMinSize(100, 10);
		timer.setFont(new Font(30));
		timer.setTranslateX(200);
		timer.setTranslateY(-20);

		
		
		
		//making sun count
		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\sun.png");
		Image sun_image = new Image(input);
		ImageView sun = new ImageView(sun_image);
		sun.setTranslateX(10);
		sun.setTranslateY(-20);
		Label sun_no = new Label("0");
		sun_no.setStyle("-fx-background-color: #ffffff");
		sun_no.setMinSize(60, 10);
		sun_no.setFont(new Font(30));
		sun_no.setTranslateX(10);
		sun_no.setTranslateY(-20);

		
		
		
		//adding to boxes
		HBox sun_box = new HBox(sun, sun_no, timer);
		sun_box.setAlignment(Pos.TOP_LEFT);
		sun_box.setTranslateX(10);
		sun_box.setTranslateY(-460);

		
		
//making animations
		
		//zombie animation
		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\Zombieidle.gif");
		Image zombie_image = new Image(input);
		ImageView zombie = new ImageView(zombie_image);
		zombie.setFitHeight(150);
		zombie.setFitWidth(150);
		zombie.setTranslateX(350);
		zombie.setTranslateY(180);
		zombie.setPreserveRatio(true);

		TranslateTransition translate_zombie = new TranslateTransition();
		translate_zombie.setByX(-650);
		translate_zombie.setDuration(Duration.millis(25000));
		translate_zombie.setCycleCount(1);
		translate_zombie.setAutoReverse(false);
		translate_zombie.setNode(zombie);
		translate_zombie.play();

		
		//peashooter animation
		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\peashooter.gif");
		Image peashooter_image = new Image(input);
		ImageView peashooter_view = new ImageView(peashooter_image);
		peashooter_view.setFitHeight(100);
		peashooter_view.setFitWidth(100);
		peashooter_view.setTranslateX(-320);
		peashooter_view.setTranslateY(15);
		peashooter_view.setPreserveRatio(true);

		input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\pea.png");
		Image pea_image = new Image(input);
		ImageView pea_view = new ImageView(pea_image);
		TranslateTransition translate_pea = new TranslateTransition();
		pea_view.setTranslateX(-340);
		pea_view.setTranslateY(7);
		translate_pea.setByX(600);
		translate_pea.setDuration(Duration.millis(5000));
		translate_pea.setCycleCount(20);
		translate_pea.setAutoReverse(false);
		translate_pea.setNode(pea_view);
		translate_pea.play();

		input.close();

		
		
		
		
		//adding to boxes
		HBox box = new HBox();
		box.getChildren().add(zombie);
		box.getChildren().add(peashooter_view);
		box.getChildren().add(pea_view);

		box.setAlignment(Pos.CENTER);

		
		
		
		
		//making pause button
		Button pause_button = new Button();
		pause_button.setTranslateX(-20);
		pause_button.setTranslateY(10);
		pause_button.setOnAction(e -> stage.setScene(pause_menue));
		Image pause_button_img = new Image("http://icons.iconarchive.com/icons/iconsmind/outline/512/Pause-icon.png");
		ImageView pause_button_view = new ImageView(pause_button_img);
		pause_button_view.setFitWidth(30);
		pause_button_view.setFitHeight(30);
		pause_button.setGraphic(pause_button_view);
		pause_button.setStyle("-fx-background-color: #ddd8df");

		VBox vboxx = new VBox(pause_button);
		vboxx.setAlignment(Pos.TOP_RIGHT);

		box.setTranslateX(205);
		box.setTranslateY(112);

		FileInputStream playground_input = new FileInputStream("C:\\\\Users\\\\pruty\\\\Desktop\\\\AP projec\\lawn2.jpg");


		
		
		//making background of the page
		Image yard = new Image(playground_input);
		BackgroundImage playground_backgroundimage = new BackgroundImage(yard, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background playground_background = new Background(playground_backgroundimage);
		vboxx.setBackground(playground_background);
		vboxx.getChildren().add(box);
		vboxx.getChildren().add(plants_box);
		vboxx.getChildren().add(sun_box);
		Scene p = new Scene(vboxx, 938, 635);
		stage.setScene(p);
	}

	public static void main(String args[]) {

		launch(args);
	}
}