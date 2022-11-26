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
    private JLabel cropMaturity, harvestDay, minimumWaterReq, timesCropWatered, minimumFertilizerReq, timesCropFertilized;
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
        JLabel bracket3 = new JLabel("]");
               bracket3.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel spacee = new JLabel("                                                                      " +
                "                                                                      " +
                "                                       ");
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

        JLabel cM = new JLabel("                Crop Maturity (in days): ");
               cM.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cM);
        cropMaturity = new JLabel("0");
        cropMaturity.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(cropMaturity);
        JLabel hD = new JLabel("                     Harvest Day: ");
               hD.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(hD);
        harvestDay = new JLabel("2");
        harvestDay.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(harvestDay);
        JLabel mWR = new JLabel("  Minimum Water Requirement: ");
               mWR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mWR);
        minimumWaterReq = new JLabel("1");
        minimumWaterReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumWaterReq);
        JLabel tCW = new JLabel("       Times Crop Watered: ");
               tCW.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCW);
        timesCropWatered = new JLabel("0");
        timesCropWatered.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(timesCropWatered);
        JLabel mFR = new JLabel("Minimum Fertilizer Requirement: ");
               mFR.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(mFR);
        minimumFertilizerReq = new JLabel("0");
        minimumFertilizerReq.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(minimumFertilizerReq);
        JLabel tCF = new JLabel("     Times Crop Fertilized: ");
               tCF.setFont(new Font("Arial", Font.BOLD, 14));
        status.add(tCF);
        timesCropFertilized = new JLabel("0");
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
                String text = Integer.toString(i) + ", " + Integer.toString(j);
                plantButtons[i][j] = new JButton(text);
                plantButtons[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                plantButtons[i][j].setBackground(Color.decode("#E6E5A3"));
                plantButtons[i][j].setForeground(Color.black);
                plantButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() instanceof JButton) {
                            String text = ((JButton) e.getSource()).getText();
                            String[] arrStr = text.split(",",2);
                            int x = Integer.parseInt(arrStr[0]);
                            int y = Integer.parseInt(arrStr[1]);
                            JOptionPane.showMessageDialog(null, text);
                            textFrame.setText(text);
                        }
                    }
                });
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

        for (int l = 0; l < 5; l++) {
            String text = Integer.toString(l);
            toolButtons[l] = new JButton(text);
            toolButtons[l].setFont(new Font("Arial", Font.BOLD, 14));
            toolButtons[l].setBackground(Color.decode("#E6E5A3"));
            toolButtons[l].setForeground(Color.black);
            toolButtons[l].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() instanceof JButton) {
                        String text = ((JButton) e.getSource()).getText();
                        String[] arrStr = text.split(",",2);
                        int x = Integer.parseInt(arrStr[0]);
                        int y = Integer.parseInt(arrStr[1]);
                        JOptionPane.showMessageDialog(null, text);
                        toolFrame.setText(text);
                    }
                }
            });
            panelSouth.add(toolButtons[l]);
        }
        return panelSouth;
    }
}
