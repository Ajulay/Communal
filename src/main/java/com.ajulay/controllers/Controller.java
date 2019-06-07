package com.ajulay.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * @author Ajulay
 * @version 1.0
 *
 * */
public class Controller {
// for data before
    @FXML
    private TextField tfECnt1Before;
    @FXML
    private TextField tfECnt2Before;
    @FXML
    private TextField tfCntCldWtrBefore;
    @FXML
    private TextField tfCntHtWtrBefore;
// for data now
    @FXML
    private TextField tfECnt1Now;
    @FXML
    private TextField tfECnt2Now;
    @FXML
    private TextField tfCntCldWtrNow;
    @FXML
    private TextField tfCntHtWtrNow;
// for data showing cost per one
    @FXML
    private TextField tfECnt1OneItm;
    @FXML
    private TextField tfECnt2OneItm;
    @FXML
    private TextField tfCntCldWtrOneItm;
    @FXML
    private TextField tfCntHtWtrOneItm;
    @FXML
    private TextField tfWOItm;
    @FXML
    private TextField tfWarm;
// for results
    @FXML
    private Label lblECnt1Res;
    @FXML
    private Label lblECnt2Res;
    @FXML
    private Label lblCntCldWtrRes;
    @FXML
    private Label lblCntHtWtrRes;
    @FXML
    private Label lblCntOverlRes;
    @FXML
    private Label lblwtOt;

    @FXML
    private Button bnCompute;
    @FXML
    private Button bnCancel;

public void initialize(){
lblCntCldWtrRes.setText("");
lblCntHtWtrRes.setText("");
lblECnt1Res.setText("");
lblECnt2Res.setText("");
lblCntOverlRes.setText("");
lblwtOt.setText("");

tfECnt1OneItm.setText("4.41");
tfECnt2OneItm.setText("1.58");
tfCntHtWtrOneItm.setText("180.55");
tfCntCldWtrOneItm.setText("36.64");
tfECnt1Now.setText("11526");
tfECnt2Now.setText("3096");
tfECnt1Before.setText("10770");
tfECnt2Before.setText("2580");
tfCntCldWtrBefore.setText("556.8");
tfCntHtWtrBefore.setText("454");
tfCntCldWtrNow.setText("601");
tfCntHtWtrNow.setText("480");
tfWOItm.setText("36.67");
tfWarm.setText("0");




}
    @FXML
public void compute(){
    double el1bf = Double.parseDouble(tfECnt1Before.getText());
    double el2bf = Double.parseDouble(tfECnt2Before.getText());
    double cdwtbf = Double.parseDouble(tfCntCldWtrBefore.getText());//cold water before
    double hwtbf = Double.parseDouble(tfCntHtWtrBefore.getText());//hot water before

    double el1n = Double.parseDouble(tfECnt1Now.getText());
    double el2n = Double.parseDouble(tfECnt2Now.getText());
    double cdwtn = Double.parseDouble(tfCntCldWtrNow.getText());//cold water now
    double hwtn = Double.parseDouble(tfCntHtWtrNow.getText());//hot water now

    double el1i = Double.parseDouble(tfECnt1OneItm.getText());
    double el2i = Double.parseDouble(tfECnt2OneItm.getText());
    double cdwi = Double.parseDouble(tfCntCldWtrOneItm.getText());//cold water per one item
    double hwti = Double.parseDouble(tfCntHtWtrOneItm.getText());//hot water per one item
    double woi = Double.parseDouble(tfWOItm.getText());

    double resEl1 = count(el1bf, el1n, el1i);
    double resEl2 = count(el2bf, el2n, el2i);
    double resCW = count(cdwtbf, cdwtn, cdwi);
    double resHW = count(hwtbf, hwtn, hwti);
    double resWO = count((cdwtbf+hwtbf),(cdwtn+hwtn),woi);
    double resWarm = Double.parseDouble(tfWarm.getText());

    lblCntOverlRes.setText((Math.rint((resEl1+resEl2+resCW+resHW+resWO + resWarm)*100)/100) + "");
    lblECnt1Res.setText(resEl1+"");
    lblECnt2Res.setText(resEl2+"");
    lblCntCldWtrRes.setText(resCW+"");
    lblCntHtWtrRes.setText(resHW+"");
    lblwtOt.setText(resWO + "");

}
    @FXML
    public double count(double a, double b, double c){
    return Math.rint((b-a)*c*100)/100;}

    @FXML
    private void clear(){
        lblCntCldWtrRes.setText("");
        lblCntHtWtrRes.setText("");
        lblECnt1Res.setText("");
        lblECnt2Res.setText("");
        lblCntOverlRes.setText("");
        lblwtOt.setText("");

        tfECnt1Now.setText("");
        tfECnt2Now.setText("");
        tfECnt1Before.setText("");
        tfECnt2Before.setText("");
        tfCntCldWtrBefore.setText("");
        tfCntHtWtrBefore.setText("");
        tfCntCldWtrNow.setText("");
        tfCntHtWtrNow.setText("");
       

    }
    public void cancel(){
    System.exit(0);
    }
}
