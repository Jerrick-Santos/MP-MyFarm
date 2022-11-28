package Game.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MyFarmGUI extends JFrame{
    // North Panel
    private JLabel farmerTypeStat, levelVal, objcoinsVal, expVal;
    private JButton updateFT;
    // East Panel
    private JLabel lblText;
    private JLabel cropMaturity, harvestDay, minimumWaterReq, timesCropWatered, minimumFertilizerReq,
                   timesCropFertilized;
    private int cropM = 0, harvestD = 0, minWR = 0, timesCW = 0, minFR = 0, timesCF = 0;
    private JButton btnUse, btnPlant, btnHarvest, btnNextDay;
    private JLabel plantLbl;
    private JLabel forRock, forPlow, forSeed, forWither;
    // Center Panel
    private JButton[][] plantButtons;
    // South Panel
    private JButton[] toolButtons;
    public MyFarmGUI() {
        super("MP-MyFarm");
        setLayout(new BorderLayout());
        setSize(800,500);
        setLocation(100,100);
        setAlwaysOnTop(true);

        mainContainer(NORTHPanel(),
                EASTPanel(panelEastNORTH(), panelEastCENTER(panelEastCenterSOUTH()),
                        panelEastSOUTH()),
                CENTERPanel(),
                SOUTHPanel());

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mainContainer(RoundedPanel NORTHPanel, JPanel EASTPanel, RoundedPanel CENTERPanel,
                              RoundedPanel SOUTHPanel) {
        Container mainContainer = this.getContentPane();
                  mainContainer.setLayout(new BorderLayout(8,6));
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,
                Color.decode("#A9AF7E")));
        mainContainer.setBackground(Color.decode("#A9AF7E"));

        mainContainer.add(NORTHPanel, BorderLayout.NORTH);
        mainContainer.add(EASTPanel, BorderLayout.CENTER);
        mainContainer.add(CENTERPanel, BorderLayout.EAST);
        mainContainer.add(SOUTHPanel, BorderLayout.SOUTH);
    }

    public RoundedPanel NORTHPanel() {
        RoundedPanel panelNorth = new RoundedPanel();
                     panelNorth.setLayout(new FlowLayout(5));
                     panelNorth.setBackground(Color.decode("#E6E5A3"));
                     panelNorth.setBorder(BorderFactory.createEmptyBorder(3,3,0,3));

        JLabel bracket1 = new JLabel(" [");
               bracket1.setFont(new Font("Arial", Font.BOLD, 14));
        farmerTypeStat = new JLabel("LEGENDARY");
        farmerTypeStat.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket2 = new JLabel("]     ");
               bracket2.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel levelLbl = new JLabel("Level[");
               levelLbl.setFont(new Font("Arial", Font.BOLD, 14));
        levelVal = new JLabel("1");
        levelVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel space = new JLabel("]      ");
               space.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel objcoinsLbl = new JLabel("ObjCoins[");
               objcoinsLbl.setFont(new Font("Arial", Font.BOLD, 14));
        objcoinsVal = new JLabel("100");
        objcoinsVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel space2 = new JLabel("]      ");
               space2.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel expLbl = new JLabel("Exp[");
               expLbl.setFont(new Font("Arial", Font.BOLD, 14));
        expVal = new JLabel("5");
        expVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket3 = new JLabel("]");
               bracket3.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel spacee = new JLabel("                                                       ");
        updateFT = new JButton("Prestige Up");
        updateFT.setBackground(Color.GREEN);
        updateFT.setForeground(Color.BLACK);
        updateFT.setFont(new Font("Arial", Font.BOLD, 14));
        updateFT.setUI(new StyledButtonUI());

        panelNorth.add(bracket1);
        panelNorth.add(farmerTypeStat);
        panelNorth.add(bracket2);
        panelNorth.add(levelLbl);
        panelNorth.add(levelVal);
        panelNorth.add(space);
        panelNorth.add(objcoinsLbl);
        panelNorth.add(objcoinsVal);
        panelNorth.add(space2);
        panelNorth.add(expLbl);
        panelNorth.add(expVal);
        panelNorth.add(bracket3);
        panelNorth.add(spacee);
        panelNorth.add(updateFT);

        return panelNorth;
    }

    public JPanel EASTPanel(RoundedPanel panelEastNORTH, JPanel panelEastCENTER, RoundedPanel panelEastSOUTH) {
        JPanel panelEast = new JPanel();
               panelEast.setLayout(new BorderLayout());
               panelEast.setBackground(Color.decode("#A9AF7E"));

        panelEast.add(panelEastNORTH, BorderLayout.NORTH);
        panelEast.add(panelEastCENTER, BorderLayout.CENTER);
        panelEast.add(panelEastSOUTH, BorderLayout.SOUTH);

        return panelEast;
    }

    public RoundedPanel panelEastNORTH() {
        RoundedPanel panelEastNORTH = new RoundedPanel();
                     panelEastNORTH.setLayout(new FlowLayout(FlowLayout.CENTER));
                     panelEastNORTH.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
                     panelEastNORTH.setBackground(Color.decode("#E6E5A3"));

        lblText = new JLabel("x, y");
        lblText.setFont(new Font("Arial", Font.BOLD, 14));
        lblText.setForeground(Color.black);

        panelEastNORTH.add(lblText);
        return panelEastNORTH;
    }

    public JPanel panelEastCENTER(JPanel panelEastCenterSOUTH) {
        JPanel panelEastCENTER = new JPanel();
               panelEastCENTER.setLayout(new BorderLayout());
               panelEastCENTER.setBackground(Color.decode("#A9AF7E"));

        RoundedPanel status = new RoundedPanel();
                     status.setLayout(new GridLayout(6, 2));
                     status.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
                     status.setBackground(Color.decode("#E6E5A3"));

        JLabel cM = new JLabel("    Crop Maturity (in days):     ");
               cM.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cM);
        cropMaturity = new JLabel("........................................" + cropM);
        cropMaturity.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cropMaturity);
        JLabel hD = new JLabel("                     Harvest Day: ");
               hD.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(hD);
        harvestDay = new JLabel("........................................" + harvestD);
        harvestDay.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(harvestDay);
        JLabel mWR = new JLabel("  Minimum Water Req: ");
               mWR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mWR);
        minimumWaterReq = new JLabel("........................................" + minWR);
        minimumWaterReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumWaterReq);
        JLabel tCW = new JLabel("       Times Crop Watered: ");
               tCW.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCW);
        timesCropWatered = new JLabel("........................................" + timesCW);
        timesCropWatered.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(timesCropWatered);
        JLabel mFR = new JLabel("  Minimum Fertilizer Req: ");
               mFR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mFR);
        minimumFertilizerReq = new JLabel("........................................" + minFR);
        minimumFertilizerReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumFertilizerReq);
        JLabel tCF = new JLabel("     Times Crop Fertilized: ");
               tCF.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCF);
        timesCropFertilized = new JLabel("........................................" + timesCF);
        timesCropFertilized.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(timesCropFertilized);

        panelEastCENTER.add(status, BorderLayout.CENTER);
        panelEastCENTER.add(panelEastCenterSOUTH, BorderLayout.SOUTH);

        return panelEastCENTER;
    }

    public RoundedPanel panelEastSOUTH() {
        RoundedPanel panelEastSOUTH = new RoundedPanel();
                     panelEastSOUTH.setLayout(new FlowLayout());
                     panelEastSOUTH.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                     panelEastSOUTH.setBackground(Color.decode("#E6E5A3"));

        btnUse = new JButton("Use Tool");
        btnUse.setFont(new Font("Arial", Font.BOLD, 14));
        btnUse.setForeground(Color.black);
        btnUse.setUI(new StyledButtonUI());
        panelEastSOUTH.add(btnUse);
        btnPlant = new JButton("Plant");
        btnPlant.setFont(new Font("Arial", Font.BOLD, 14));
        btnPlant.setForeground(Color.black);
        btnPlant.setUI(new StyledButtonUI());
        panelEastSOUTH.add(btnPlant);
        btnHarvest = new JButton("Harvest");
        btnHarvest.setFont(new Font("Arial", Font.BOLD, 14));
        btnHarvest.setForeground(Color.black);
        btnHarvest.setUI(new StyledButtonUI());
        panelEastSOUTH.add(btnHarvest);
        btnNextDay = new JButton("Next Day");
        btnNextDay.setFont(new Font("Arial", Font.BOLD, 14));
        btnNextDay.setForeground(Color.black);
        btnNextDay.setUI(new StyledButtonUI());
        panelEastSOUTH.add(btnNextDay);

        return panelEastSOUTH;
    }

    public JPanel panelEastCenterSOUTH() {
        JPanel panelEastCenterSOUTH = new JPanel();
               panelEastCenterSOUTH.setLayout(new BorderLayout());
               panelEastCenterSOUTH.setBackground(Color.decode("#A9AF7E"));

        RoundedPanel textTitle = new RoundedPanel();
                     textTitle.setBackground(Color.decode("#E6E5A3"));
                     textTitle.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
                     textTitle.setLayout(new FlowLayout(FlowLayout.CENTER));

        plantLbl = new JLabel("Turnip");
        plantLbl.setFont(new Font("Arial", Font.BOLD, 14));
        plantLbl.setForeground(Color.black);
        textTitle.add(plantLbl);
        panelEastCenterSOUTH.add(textTitle, BorderLayout.NORTH);

        RoundedPanel textDesc = new RoundedPanel();
                     textDesc.setBackground(Color.decode("#E6E5A3"));
                     textDesc.setBorder(BorderFactory.createEmptyBorder(8, 3, 8, 3));
                     textDesc.setLayout(new GridLayout(2, 4));

        JLabel rockLbl = new JLabel("   Rock");
               rockLbl.setFont(new Font("Arial", Font.BOLD, 14));
               rockLbl.setBackground(Color.gray);
               rockLbl.setForeground(Color.black);
        textDesc.add(rockLbl);
        JLabel plowed = new JLabel("Plowed");
               plowed.setFont(new Font("Arial", Font.BOLD, 14));
               plowed.setBackground(Color.gray);
               plowed.setForeground(Color.black);
        textDesc.add(plowed);
        JLabel seed = new JLabel("Seed");
               seed.setFont(new Font("Arial", Font.BOLD, 14));
               seed.setBackground(Color.gray);
               seed.setForeground(Color.black);
        textDesc.add(seed);
        JLabel withered = new JLabel("Withered");
               withered.setFont(new Font("Arial", Font.BOLD, 14));
               withered.setBackground(Color.gray);
               withered.setForeground(Color.black);
        textDesc.add(withered);

        Icon RockIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        forRock = new JLabel(RockIcon);
        textDesc.add(forRock);
        Icon PlowIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        forPlow = new JLabel(PlowIcon);
        textDesc.add(forPlow);
        Icon SeedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        forSeed = new JLabel(SeedIcon);
        textDesc.add(forSeed);
        Icon WitherIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        forWither = new JLabel(WitherIcon);
        textDesc.add(forWither);

        panelEastCenterSOUTH.add(textDesc, BorderLayout.SOUTH);

        return panelEastCenterSOUTH;
    }

    public RoundedPanel CENTERPanel() {
        RoundedPanel panelCenter = new RoundedPanel();
                     panelCenter.setLayout(new GridLayout(10,5));
                     panelCenter.setBackground(Color.decode("#E6E5A3"));
                     panelCenter.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        plantButtons = new JButton[10][5];
        JLabel textFrame = new JLabel("");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                String text = Integer.toString(i) + "," + Integer.toString(j);
                plantButtons[i][j] = new JButton(text);
                plantButtons[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                plantButtons[i][j].setBackground(Color.decode("#E6E5A3"));
                plantButtons[i][j].setForeground(Color.black);
                panelCenter.add(plantButtons[i][j]);
            }
        }
        return panelCenter;
    }

    public RoundedPanel SOUTHPanel() {
        RoundedPanel panelSouth = new RoundedPanel();
                     panelSouth.setLayout(new GridLayout(1,5));
                     panelSouth.setBackground(Color.decode("#E6E5A3"));
                     panelSouth.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        toolButtons = new JButton[5];
        JLabel toolFrame = new JLabel();
        String[] toolNames = {"Watercan", "Fertilizer", "Plow Tool", "Pickaxe", "Shovel"};
        for (int l = 0; l < 5; l++) {
            toolButtons[l] = new JButton(toolNames[l]);
            toolButtons[l].setFont(new Font("Arial", Font.BOLD, 14));
            toolButtons[l].setBackground(Color.decode("#E6E5A3"));
            toolButtons[l].setForeground(Color.black);

            panelSouth.add(toolButtons[l]);


        }
        return panelSouth;
    }

    //NORTH PANEL SETTERS
    public void setFarmerTypeName(String farmerTypeName){
        this.farmerTypeStat.setText(farmerTypeName);
    }

    public void setFarmerLevel(int level){
        String levelString = Integer.toString(level);
        this.levelVal.setText(levelString);
    }

    public void setFarmerBalance(double balance){
        String balanceString = Double.toString(balance);
        this.objcoinsVal.setText(balanceString);
    }

    public void setFarmerExpVal(double exp){
        String expString = Double.toString(exp);
        this.expVal.setText(expString);
    }

    //ACTION LISTENER
    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < 5; i++) {
            toolButtons[i].addActionListener(listener);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                plantButtons[i][j].addActionListener(listener);
            }
        }

        btnPlant.addActionListener(listener);
        btnHarvest.addActionListener(listener);
        btnNextDay.addActionListener(listener);
        btnUse.addActionListener(listener);
    }


    //PANEL EAST NORTH
    public void setPlantCoordinate(String coordinate){
        this.lblText.setText(coordinate);
    }

    //PANEL EAST CENTER

    public void setCropM(int cropM) {
        this.cropM = cropM;
    }

    public void setHarvestD(int harvestD) {
        this.harvestD = harvestD;
    }

    public void setMinWR(int minWR) {
        this.minWR = minWR;
    }

    public void setTimesCW(int timesCW) {
        this.timesCW = timesCW;
    }

    public void setMinFR(int minFR) {
        this.minFR = minFR;
    }

    public void setTimesCF(int timesCF) {
        this.timesCF = timesCF;
    }

    public void removeAllTileInfo(){
        cropMaturity.setText("");
        harvestDay.setText("");
        minimumWaterReq.setText("");
        timesCropWatered.setText("");
        minimumFertilizerReq.setText("");
        timesCropFertilized.setText("");
    }

    public void revertTileInfo(){
        cropMaturity.setText("........................................" + cropM);
        harvestDay.setText("........................................" + harvestD);
        minimumWaterReq.setText("........................................" + minWR);
        timesCropWatered.setText("........................................" + timesCW);
        minimumFertilizerReq.setText("........................................" + minFR);
        timesCropFertilized.setText("........................................" + timesCF);
    }

    //EAST SOUTH
    public void setPlantLabel(String plantLabel){
        this.plantLbl.setText(plantLabel);
    }

    //EAST CENTER SOUTH
    public void setRockIcon(Icon icon){
        forRock.setIcon(icon);
    }

    public void setPlowIcon(Icon icon){
        forPlow.setIcon(icon);
    }

    public void setSeedIcon(Icon icon){
        forSeed.setIcon(icon);
    }

    public void setWitherIcon(Icon icon){
        forWither.setIcon(icon);
    }

    //EAST SOUTH

    public void setPlantButtonColor(){
        btnPlant.setBackground(Color.decode("#EBE29F"));
    }

    public void setHarvestButtonColor(){
        btnHarvest.setBackground(Color.decode("#EBE29F"));
    }

    //CENTER PANEL
    public void readyForHarvest(int row, int col){
        plantButtons[row][col].setBackground(Color.green);
    }

    public void plowedTile(int row, int col){
        plantButtons[row][col].setBackground(Color.cyan);
    }

    public void revertOriginalTileColor(int row, int col){
        plantButtons[row][col].setBackground(Color.decode("#E6E5A3"));
    }

    public void rockOccupied(int row, int col){
        plantButtons[row][col].setBackground(Color.orange);
    }
    public void tileIsOccupied(int row, int col){
        plantButtons[row][col].setBackground(Color.yellow);
    }

    public void plantWithered(int row, int col){
        plantButtons[row][col].setBackground(Color.red);
    }

    //SOUTH PANEL
    public void changeToolButtonColor(int select, int currentTool){
        if (select != currentTool){
            toolButtons[currentTool].setBackground(Color.decode("#E6E5A3"));
            toolButtons[select].setBackground(Color.PINK);
        }
    }

    public int displaySeedOptions(){
        int retVal = -1;
        //i solved my problem adding the following 2 lines of code...
        Object[] options = {"Turnip", "Carrot", "Potato", "Rose", "Tulips", "Sunflower", "Mango", "Apple"};
        JFrame panel = new JFrame();
        panel.add(new JButton("Click"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Label"));
        //...and passing `frame` instead of `null` as first parameter
        Object selectionObject = JOptionPane.showInputDialog(this, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();

        for (int i = 0; i < options.length; i++) {
            if (selectionString.equals(options[i])){
                retVal = i;
            }
        }

        return retVal;
    }

}
