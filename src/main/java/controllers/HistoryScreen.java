package controllers;

/* Developer: Philip Churchill
** Date: 2015.11.05
** Configuration Version: 1.0.0
*/

/**
 * This class is the controller for the history screen. It will present
 * the user with a history of weigh-ins and daily calorie totals. Other
 * functionality will allow the user to remove daily and weigh-in entries
 * from the local database.
 */

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
    private ObservableList<Day> dayList;
    private ObservableList<WeighIn> weighInList;

    @FXML
    private Label messageLabel;

    @FXML
    private TableView<Day> dayTable;

    @FXML
    private TableColumn<Day, String> dDate, dCal;

    @FXML
    private TableView<WeighIn> weighInTable;

    @FXML
    private TableColumn<WeighIn, String> wDate, wWeight;

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
        //Checks for a selection first
        if(weighInTable.getSelectionModel().getSelectedItem() != null){
            WeighIn selectedWeighIn = weighInTable.getSelectionModel().getSelectedItem();
            weighInData.deleteWeighIn(selectedWeighIn.getWeighId());
            setTables();
        }
    }

    @FXML
    public void handleDeleteDayButton(ActionEvent event){
        Day selectedDay = dayTable.getSelectionModel().getSelectedItem();
        //Checks for selection
        if(selectedDay != null){
            //if selected day is not the current day.
            if(!selectedDay.equals(sessionManager.getCurrentDay())){
                //delete current day
                dayData.deleteDay(selectedDay.getUserId());
            }else {
                //Selected day is same as current day.
                messageLabel.setText("Cannot delete current day.");
                //Time to erase message after 2 seconds needed a thread.
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
            //reset the tables.
            setTables();
        }
    }

    public void setTables(){
        //Get observable list from database
        dayList = dayData.getDayList(sessionManager.getUser().getUserId());
        weighInList = weighInData.getListOfWeighIns(sessionManager.getUser().getUserId());
        //set column values for weight table.
        wDate.setCellValueFactory(new PropertyValueFactory<WeighIn, String>("date"));
        wWeight.setCellValueFactory(new PropertyValueFactory<WeighIn, String>("weight"));
        //set column values for day table
        dDate.setCellValueFactory(new PropertyValueFactory<Day, String>("date"));
        dCal.setCellValueFactory(new PropertyValueFactory<Day, String>("totalCal"));
        //set list to the tableViews

        /**
         * User can view history of daily calorie totals and their dates
         * (Requirement 5.4.0)
         */
        weighInTable.getItems().clear();
        weighInTable.setItems(weighInList);

        /**
         * User can view history of weigh-in events and their dates
         * (Requirement 4.4.0)
         */
        dayTable.getItems().clear();
        dayTable.setItems(dayList);
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}