import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.util.Random; 
import javafx.animation.*; 
import javafx.event.*; 
import javafx.util.Duration; 
import javafx.scene.layout.HBox; 
import javafx.scene.control.Button; 

public class DisplayClock extends Application {
   public static  Timeline animation ; 
 @Override // Override the start method in the Application class
 
 public void start(Stage primaryStage) {
// Create a clock and a label

/*Random rand = new Random();
int a = rand.nextInt(12);
int b = rand.nextInt(31);*/
 ClockPane clock = new ClockPane( );
 /*String timeString = clock.getHour() + ":" + clock.getMinute()+ ":" + clock.getSecond();
 Label lblCurrentTime = new Label(timeString);
 */
 //creation de la pane des bouton et ajout des bouton 
 HBox btn = new HBox(10); 
 Button  stop = new Button("stop"); 
 Button  start = new Button("start");
btn.setAlignment(Pos.CENTER) ;
 btn.getChildren().addAll(stop, start); 

 
 // Place clock and label in border pane
 BorderPane pane = new BorderPane();
 pane.setCenter(clock);
 pane.setBottom(btn);
 

 //BorderPane.setAlignment(btn, Pos.TOP_CENTER);
 EventHandler<ActionEvent> event = e -> {clock.setCurrentTime(); };
 
 animation = new Timeline( 
 new KeyFrame(Duration.millis(10), event)); 
 animation.setCycleCount(Timeline.INDEFINITE);
 animation.play();
stop.setOnAction(new stopHandler() );
start.setOnAction(new startHandler() );
 // Create a scene and place it in the stage
 Scene scene = new Scene(pane, 250, 250);
 primaryStage.setTitle("DisplayClock"); // Set the stage title
 primaryStage.setScene(scene); // Place the scene in the stage
 primaryStage.show(); }
public static void stap(){ animation.stop();}
public static void start(){animation.play();}
public static void main(String[] args) {
 Application.launch(args);} }
class stopHandler implements EventHandler<ActionEvent>  {
@Override // Override the handlemethod
public void handle(ActionEvent e) {
    DisplayClock.stap(); 

}}
class startHandler implements EventHandler<ActionEvent>  {
@Override // Override the handlemethod
public void handle(ActionEvent e) {
    DisplayClock.start(); 

}}


