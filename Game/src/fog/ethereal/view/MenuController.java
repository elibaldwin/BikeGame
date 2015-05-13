package fog.ethereal.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import fog.ethereal.world.BikeWorld;
import fog.ethereal.world.Level;
import fog.ethereal.world.World;

public class MenuController {
	@FXML
	private TableView<Level> levelTable;
	
	@FXML
	private TableColumn<Level, Level> levelColumn;
	
	private Level currentLevel;
	
	@FXML
	public void startGame() {
		Stage gameStage = new Stage();
		World world = new BikeWorld();
		world.initialize(gameStage);
	}
	
	@FXML
	private void initialize() {
		levelColumn.setCellFactory(new Callback<TableColumn<Level, Level>, TableCell<Level, Level>>() {
			@Override
			public TableCell<Level, Level> call(TableColumn<Level, Level> param) {
				TableCell<Level, Level> cell = new LevelTableCell();
				return cell;
			}
		});
	}
}
