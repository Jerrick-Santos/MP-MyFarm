package Game.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyFarmGUI extends JFrame{
    public MyFarmGUI() {
        super("MP-MyFarm");
        setLayout(new BorderLayout());

        setSize(850, 500);
        setLocation(100,100);

        init();

        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        //mainContainer.setBackground(Color.decode("#65647C"));
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.decode("#A9AF7E")));
        mainContainer.setBackground(Color.decode("#A9AF7E"));

        // SOUTH PANEL
        RoundedPanel panelSouth = new RoundedPanel();
        //panelSouth.setBorder(new LineBorder(Color.BLACK, 3));
        panelSouth.setLayout(new GridLayout(1, 5));
        panelSouth.setBackground(Color.decode("#E6E5A3"));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JButton [][]toolButtons = new JButton[1][5];


        JLabel toolFrame = new JLabel();

        for (int k = 0; k < 1; k++) {
            for (int l = 0; l < 5; l++) {
                String text = Integer.toString(k) + ", " + Integer.toString(l);
                toolButtons[k][l] = new JButton(text);
                toolButtons[k][l].setFont(new Font("Arial", Font.BOLD, 14));
                toolButtons[k][l].setBackground(Color.decode("#E6E5A3"));
                toolButtons[k][l].setForeground(Color.black);
                toolButtons[k][l].addActionListener(new ActionListener() {
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
                panelSouth.add(toolButtons[k][l]);
            }
        }

        mainContainer.add(panelSouth, BorderLayout.SOUTH);

        // NORTH PANEL
        RoundedPanel panelNorth = new RoundedPanel();
        //panelNorth.setBorder(new LineBorder(Color.BLACK, 3));
        panelNorth.setLayout(new FlowLayout(5));
        panelNorth.setBackground(Color.decode("#E6E5A3"));
        panelNorth.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JLabel levelLbl = new JLabel("Level: ");
        levelLbl.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel levelVal = new JLabel("1");
        levelVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel space = new JLabel("  |   ");
        space.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel objcoinsLbl = new JLabel("OBJCoins: ");
        objcoinsLbl.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel objcoinsVal = new JLabel("100");
        objcoinsVal.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel space2 = new JLabel("  |   ");
        space2.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel expLbl = new JLabel("Experience: ");
        expLbl.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel expVal = new JLabel("5");
        expVal.setFont(new Font("Arial", Font.BOLD, 14));

        panelNorth.add(levelLbl);
        panelNorth.add(levelVal);
        panelNorth.add(space);
        panelNorth.add(objcoinsLbl);
        panelNorth.add(objcoinsVal);
        panelNorth.add(space2);
        panelNorth.add(expLbl);
        panelNorth.add(expVal);

        mainContainer.add(panelNorth, BorderLayout.NORTH);

        // EAST PANEL
        JPanel panelEast = new JPanel();
        //panelEast.setBorder(new LineBorder(Color.BLACK, 3));
        panelEast.setLayout(new BorderLayout());
        panelEast.setBackground(Color.decode("#A9AF7E"));

            //North Panel
            RoundedPanel panelEastNORTH = new RoundedPanel();
            panelEastNORTH.setLayout(new FlowLayout(FlowLayout.CENTER));
            panelEastNORTH.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            panelEastNORTH.setBackground(Color.decode("#E6E5A3"));

            JLabel lblText = new JLabel("x, y");
            lblText.setFont(new Font("Arial", Font.BOLD, 14));
            lblText.setForeground(Color.black);
            panelEastNORTH.add(lblText);

            panelEast.add(panelEastNORTH, BorderLayout.NORTH);

            //Center Panel
            JPanel panelEastCENTER = new JPanel();
            panelEastCENTER.setLayout(new FlowLayout(FlowLayout.CENTER));
            panelEastCENTER.setBackground(Color.decode("#A9AF7E"));

                JPanel panelEastCenterSOUTH = new JPanel();
                panelEastCenterSOUTH.setLayout(new FlowLayout(FlowLayout.CENTER));
                panelEastCenterSOUTH.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
                panelEastCenterSOUTH.setBackground(Color.decode("#E6E5A3"));

                JLabel plantLbl = new JLabel("x, y");
                plantLbl.setFont(new Font("Arial", Font.BOLD, 14));
                plantLbl.setForeground(Color.black);
                panelEastNORTH.add(plantLbl);
            /*
            JTextArea textDesc = new JTextArea(
                    """
                            
                            Tile info: \n
                            Rock Presence: false
                            Plowed: false
                            Occupied: false
                            ================
                            
                            Planted Seed: None
                            
                            """
            );
            textDesc.setFont(new Font("Serif", Font.ITALIC, 16));
            textDesc.setLineWrap(true);
            textDesc.setWrapStyleWord(true);
            textDesc.setEditable(false);
            textDesc.setBackground(Color.decode("#A9AF7E"));
            panelEastCENTER.add(textDesc);
            */

            panelEast.add(panelEastCENTER, BorderLayout.CENTER);

            //South Panel
            RoundedPanel panelEastSOUTH = new RoundedPanel();
            panelEastSOUTH.setLayout(new FlowLayout());
            panelEastSOUTH.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            panelEastSOUTH.setBackground(Color.decode("#A9AF7E"));

            JButton btnUse = new JButton("Use Tool");
            btnUse.setFont(new Font("Arial", Font.BOLD, 14));
            btnUse.setBackground(Color.decode("#E6E5A3"));
            btnUse.setForeground(Color.black);
            btnUse.setUI(new StyledButtonUI());
            panelEastSOUTH.add(btnUse);

            JButton btnPlant = new JButton("Plant");
            btnPlant.setFont(new Font("Arial", Font.BOLD, 14));
            btnPlant.setBackground(Color.decode("#E6E5A3"));
            btnPlant.setForeground(Color.black);
            btnPlant.setUI(new StyledButtonUI());
            panelEastSOUTH.add(btnPlant);

            JButton btnHarvest = new JButton("Harvest");
            btnHarvest.setFont(new Font("Arial", Font.BOLD, 14));
            btnHarvest.setBackground(Color.decode("#E6E5A3"));
            btnHarvest.setForeground(Color.black);
            btnHarvest.setUI(new StyledButtonUI());
            panelEastSOUTH.add(btnHarvest);

            panelEast.add(panelEastSOUTH, BorderLayout.SOUTH);

        mainContainer.add(panelEast, BorderLayout.EAST);

        // CENTER PANEL
        RoundedPanel panelCenter = new RoundedPanel();
        //panelCenter.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        panelCenter.setLayout(new GridLayout(10,5));
        panelCenter.setBackground(Color.decode("#E6E5A3"));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        JButton [][]plantButtons = new JButton[10][5];

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

        mainContainer.add(panelCenter, BorderLayout.CENTER);
    }
}
