import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppPreloader extends Preloader {
	ProgressBar bar;
	Stage stage;
	
	private Scene createAppPreloaderScene(){
		bar = new ProgressBar();
		BorderPane bPane = new BorderPane();
		bPane.setCenter(bar);
		return new Scene(bPane, 300, 300);
	}
	
	public  void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setScene(createAppPreloaderScene());
		stage.show();
	}
	@Override
	public void handleProgressNotification(ProgressNotification pn) {
		bar.setProgress(pn.getProgress());
	}
	@Override
	public void handleStateChangeNotification(StateChangeNotification evt) {
		if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
			stage.hide();
		}
	}
	
}