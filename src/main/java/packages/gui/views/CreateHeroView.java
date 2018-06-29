package packages.gui.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateHeroView extends JFrame{
    private JLabel lblHeroImage;
    private JButton btnSelectHeroImage;
    private Image heroImage;
    private JButton btnCreateHero;
    private JButton btnCanel;

    public CreateHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create Hero");
        this.setSize(400, 260);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.init();
    }

    private void init(){
        JPanel panelMain = new JPanel();
        JPanel panelTop = new JPanel();
        JPanel panelMid = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel panelTop1 = new JPanel();
        JLabel lblName = new JLabel("Name:");
        JTextField txtFdName = new JTextField(10);
        JPanel panelTop2 = new JPanel();
        JLabel lblType = new JLabel("Type:");
        JTextField txtFdType = new JTextField(10);
        JPanel panelTop3 = new JPanel();
        JLabel lblLevel = new JLabel("Level:");
        JTextField txtFdLevel = new JTextField(10);
        JPanel panelTop4 = new JPanel();
        JLabel lblXPoints = new JLabel("X-Points:");
        JTextField txtFdXPoints = new JTextField(8);
        JPanel panelTop5 = new JPanel();
        JLabel lblWeapon = new JLabel("Weapon:");
        JTextField txtFdWeapon = new JTextField(9);
        JPanel panelTop6 = new JPanel();
        JLabel lblArmor = new JLabel("Armor:");
        JTextField txtFdArmor = new JTextField(9);
        this.lblHeroImage = new JLabel();
        this.btnSelectHeroImage = new JButton("Select Hero Image");
        this.btnCreateHero = new JButton("Create Hero");
        this.btnCanel = new JButton("Cancel");

        panelMain.setLayout(null);
        panelMain.setBounds(0, 0, this.getWidth(), this.getHeight());
        panelTop.setBounds(0, 0, this.getWidth(), 80);
        panelMid.setLayout(new GridLayout(3, 2));
        panelMid.setBounds(0, 80, this.getWidth(), 115);
        this.lblHeroImage.setSize(10, 10);
        panelBottom.setBounds(0, 200, this.getWidth(), 38);

        if (this.setImage("/goinfre/mkgosise/Downloads/check-box-empty.png")){
            panelTop.add(this.lblHeroImage);
            panelTop.add(this.btnSelectHeroImage);
        }
        panelTop1.add(lblName);
        panelTop1.add(txtFdName);
        panelMid.add(panelTop1);

        panelTop2.add(lblType);
        panelTop2.add(txtFdType);
        panelMid.add(panelTop2);

        lblLevel.setEnabled(false);
        txtFdLevel.setEnabled(false);
        txtFdLevel.setText("0");
        panelTop3.add(lblLevel);
        panelTop3.add(txtFdLevel);
        panelMid.add(panelTop3);

        lblXPoints.setEnabled(false);
        txtFdXPoints.setEnabled(false);
        txtFdXPoints.setText("0");
        panelTop4.add(lblXPoints);
        panelTop4.add(txtFdXPoints);
        panelMid.add(panelTop4);

        lblWeapon.setEnabled(false);
        txtFdWeapon.setEnabled(false);
        txtFdWeapon.setText("none");
        panelTop5.add(lblWeapon);
        panelTop5.add(txtFdWeapon);
        panelMid.add(panelTop5);

        lblArmor.setEnabled(false);
        txtFdArmor.setEnabled(false);
        txtFdArmor.setText("none");
        panelTop6.add(lblArmor);
        panelTop6.add(txtFdArmor);
        panelMid.add(panelTop6);
        panelBottom.add(this.btnCreateHero);
        panelBottom.add(this.btnCanel);
        panelMain.add(panelTop);
        panelMain.add(panelMid);
        panelMain.add(panelBottom);

        this.add(panelMain);
    }

    private boolean setImage(String imagePath){
        try{
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(imagePath)));
            Image image = imageIcon.getImage();
            this.heroImage = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            this.lblHeroImage.setIcon(new ImageIcon(this.heroImage));
            return (true);
        }catch(Exception exc){
            System.err.println("Error Setting Image: " + exc.getMessage());
        }
        return (false);
    }
}