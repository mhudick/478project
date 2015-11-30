/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Day;
import models.WeighIn;
import util.database.DayData;
import util.database.DayDataImpl;
import util.database.WeighInData;
import util.database.WeighInImpl;



public class HistoryScreen extends VBox implements SessionControl {

    private SessionManager sessionManager;

    private WeighInData weighInData = new WeighInImpl();
    private DayData dayData = new DayDataImpl();

    @FXML
    private Label messageLabel;

    private ObservableList<Day> dayList;

    @FXML
    private TableView<Day> dayTable;

    @FXML
    private TableColumn<Day, String> dDate, dCal;

    @FXML
    private TableView<WeighIn> weighInTable;

    @FXML
    private TableColumn<WeighIn, String> wDate, wWeight;

    private ObservableList<WeighIn> weighInList;


    public HistoryScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/history_screen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }



    @FXML
    public void handleDeleteWeightButton(ActionEvent event){
        if(weighInTable.getSelectionModel().getSelectedItem() != null){
            WeighIn selectedWeighIn = weighInTable.getSelectionModel().getSelectedItem();
            weighInData.deleteWeighIn(selectedWeighIn.getWeighId());
            setTables();
        }
    }

    @FXML
    public void handleDeleteDayButton(ActionEvent event){
        if(dayTable.getSelectionModel().getSelectedItem() != null){
            Day selectedDay = dayTable.getSelectionModel().getSelectedItem();
            if(!selectedDay.equals(sessionManager.getCurrentDay())){
                dayData.deleteDay(selectedDay.getId());
            }else {
                messageLabel.setText("Cannot delete current day.");
                Task<Void> sleeper = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                        return null;
                    }
                };
                sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        messageLabel.setText("");
                    }
                });
                new Thread(sleeper).start();
            }
            setTables();
        }
    }

    public void setTables(){
        dayList = dayData.getDayList(sessionManager.getUser().getUserId());
        weighInList = weighInData.getListOfWeighIns(sessionManager.getUser().getUserId());

        wDate.setCellValueFactory(new PropertyValueFactory<WeighIn, String>("date"));
        wWeight.setCellValueFactory(new PropertyValueFactory<WeighIn, String>("weight"));
        weighInTable.setItems(weighInList);

        dDate.setCellValueFactory(new PropertyValueFactory<Day, String>("date"));
        dCal.setCellValueFactory(new PropertyValueFactory<Day, String>("totalCal"));
        dayTable.setItems(dayList);
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        System.out.println(sessionManager.getCurrentDay().getDate());
    }
}