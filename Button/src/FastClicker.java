import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer; 

public class FastClicker{
	private boolean scoring;
	private int score;
	private double timeStep;
	
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Clickerizer!");
        Button btn = new Button();
        Text txt = new Text(10,0,"Click Score");
        btn.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent event) {
        		if(scoring) {
        			score++;
        		}
        		else {
        			score--;
        		}
        	}
        });
        
        timeStep = System.nanoTime() + 1000000000L;
        new AnimationTimer() {
        	public void handle(long now) {
        		if(now > timeStep) {
        			timeStep = now + 1000000000L;
        			scoring = !scoring;
        		}
        		if(!scoring) {
        			btn.setText("Don't Click");
        		}
        		else {
        			btn.setText("Click Me!");
        		}
        		
        		txt.setText("Score:" + Integer.toString(score));
        	}
        }.start();
        StackPane root = new StackPane();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btn.txt);
    }
}