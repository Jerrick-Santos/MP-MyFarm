package Game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MyFarmGUI extends JFrame{

    private Icon cancelIcon;
    private Icon grassIcon;
    private Icon checkIcon;
    private Icon seedIcon;
    private Icon rockIcon, skull, plowedIcon, plantIcon;
    // North Panel
    private JLabel farmerTypeStat, levelVal, objcoinsVal, expVal, daysPassed;
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
        setSize(1000,500);
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

        cancelIcon= new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        checkIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-done-32.png")));
        grassIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("grass.png")));
        rockIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("rock1.png")));
        seedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("seeded1.png")));
        skull = new ImageIcon(Objects.requireNonNull(getClass().getResource("skull.png")));
        plowedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("plowed.png")));
        plantIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("plant.png")));

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
                     panelNorth.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

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
        JLabel bracket3 = new JLabel("]      ");
               bracket3.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket4 = new JLabel("Days Passed[");
               bracket4.setFont(new Font("Arial", Font.BOLD, 14));
        daysPassed = new JLabel("0");
        daysPassed.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bracket5 = new JLabel("]");
               bracket5.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel spacee = new JLabel("                        ");
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
        panelNorth.add(bracket4);
        panelNorth.add(daysPassed);
        panelNorth.add(bracket5);
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

        JLabel cM = new JLabel("                          Crop Maturity (in days)");
               cM.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cM);
        cropMaturity = new JLabel("........................................" + cropM);
        cropMaturity.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cropMaturity);
        JLabel hD = new JLabel("                                            Harvest Day");
               hD.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(hD);
        harvestDay = new JLabel("........................................" + harvestD);
        harvestDay.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(harvestDay);
        JLabel mWR = new JLabel("                              Minimum Water Req");
               mWR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mWR);
        minimumWaterReq = new JLabel("........................................" + minWR);
        minimumWaterReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumWaterReq);
        JLabel tCW = new JLabel("                             Times Crop Watered");
               tCW.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCW);
        timesCropWatered = new JLabel("........................................" + timesCW);
        timesCropWatered.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(timesCropWatered);
        JLabel mFR = new JLabel("                         Minimum Fertilizer Req");
               mFR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mFR);
        minimumFertilizerReq = new JLabel("........................................" + minFR);
        minimumFertilizerReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumFertilizerReq);
        JLabel tCF = new JLabel("                           Times Crop Fertilized");
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
        Icon RockIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("grass.png")));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                String text = Integer.toString(i) + "," + Integer.toString(j);
                plantButtons[i][j] = new JButton(text);
                plantButtons[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                plantButtons[i][j].setBackground(Color.decode("#E6E5A3"));
                plantButtons[i][j].setForeground(Color.black);
                panelCenter.add(plantButtons[i][j]);
                plantButtons[i][j].setIcon(RockIcon);
                plantButtons[i][j].setForeground(plantButtons[i][j].getBackground());
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

    public void setDaysPassed(int days){
        String daysPassedString = Integer.toString(days);
        this.daysPassed.setText(daysPassedString);
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
        updateFT.addActionListener(listener);
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
    public void setRockIcon(boolean val){
        Icon cancel = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-cancel-32.png")));
        Icon check =  new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-done-32.png")));
        if (val){
            forRock = new JLabel(check);
        }
        else {
            forRock = new JLabel(cancel);
        }
    }

    public void setPlowIcon(boolean val){
        if (val){
            forRock.setIcon(this.checkIcon);
        }
        else {
            forRock.setIcon(this.cancelIcon);
        }

    }

    public void setSeedIcon(boolean val){
        if (val){
            forRock.setIcon(this.checkIcon);
        }
        else {
            forRock.setIcon(this.cancelIcon);
        }

    }

    public void setWitherIcon(boolean val){
        if (val){
            forRock.setIcon(this.checkIcon);
        }
        else {
            forRock.setIcon(this.cancelIcon);
        }

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
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.plantIcon);
    }

    public void plowedTile(int row, int col){
        plantButtons[row][col].setBackground(Color.cyan);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.plowedIcon);
    }

    public void revertOriginalTileColor(int row, int col){
        plantButtons[row][col].setBackground(Color.decode("#E6E5A3"));
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.grassIcon);
    }

    public void rockOccupied(int row, int col){
        Icon rockyIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("rock1.png")));
        plantButtons[row][col].setBackground(Color.orange);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.rockIcon);
    }
    public void tileIsOccupied(int row, int col){
        plantButtons[row][col].setBackground(Color.yellow);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.seedIcon);
    }

    public void plantWithered(int row, int col){
        plantButtons[row][col].setBackground(Color.red);
        plantButtons[row][col].setForeground(plantButtons[row][col].getBackground());
        plantButtons[row][col].setIcon(this.skull);
    }

    //SOUTH PANEL
    public void changeToolButtonColor(int select, int currentTool){
        if (select != currentTool){
            toolButtons[currentTool].setBackground(Color.decode("#E6E5A3"));
            toolButtons[select].setBackground(Color.PINK);
        }
        else {
            toolButtons[currentTool].setBackground(Color.PINK);
        }
    }

    //JOPTION PANES

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

    public void displayFarmerUpgradeEligibility(){
        JOptionPane.showMessageDialog(this, "You are now eligible to upgrade your farmer type!"
        , "Farmer Update", JOptionPane.PLAIN_MESSAGE);
    }

    public void displayLevelUp(int level){
        JOptionPane.showMessageDialog(this, "Level Up! You are now at Level " + level
                , "Farmer Update", JOptionPane.PLAIN_MESSAGE);
    }

    public int displayFarmerTypeUpgradeOptions(String farmerTypeName, double fee){
        String[] options = {"No", "Yes"};

        int retVal = JOptionPane.showOptionDialog(this,
                "Do you want to update to " + farmerTypeName + " for " + fee + " OJCs?",
                "Farmer Upgrade",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, 1);

        return retVal;
    }

    public int displayEndGameOption(){
        String[] options = {"No", "Yes"};

        int retVal = JOptionPane.showOptionDialog(this,
                "Game Over: Do you want to start over?",
                "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, 1);

        return retVal;
    }

    public void displayFarmerError(){
        JOptionPane.showMessageDialog(this, "Warning! You cant upgrade. Check conditions"
                , "Farmer Upgrade Error", JOptionPane.PLAIN_MESSAGE);
    }

    public void displayPlantError(){
        JOptionPane.showMessageDialog(this, "Warning: cannot be planted! Check OBJCs wallet if sufficient or if tile is occupied/withered (or if Fruit Tree is attempted check surrounding tiles."
                , "Plant Error", JOptionPane.PLAIN_MESSAGE);
    }

    public void displayHarvestError(){
        JOptionPane.showMessageDialog(this, "Warning: Cannot harvest Seed. Check if seed exists or had wither"
                , "Harvest Error", JOptionPane.PLAIN_MESSAGE);
    }

    public void displayToolError(){
        JOptionPane.showMessageDialog(this, "Cannot use tool: Check tile conditions and cost usage of tool"
                , "Invalid Tool Usage", JOptionPane.PLAIN_MESSAGE);
    }

    public void terminateGUI(){
        System.exit(0);
    }

}
