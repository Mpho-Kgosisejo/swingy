package packages.gui.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.validation.ValidatorHandler;

import packages.models.ElfModel;
import packages.models.HeroModel;
import packages.models.HunterModel;
import packages.models.KnightModel;
import packages.models.VillagerModel;
import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.CharacterType;
import packages.enums.WeaponType;
import packages.utils.JFrameHelper;

public class CreateHeroView extends JFrame{
    private JLabel lblHeroImage;
    private JButton btnSelectHeroImage;
    private Image heroImage;
    private JButton btnCreateHero;
    private JButton btnCanel;
    private JTextField txtFdName;
    private JTextField txtFdType;
    private JTextField txtFdLevel;
    private JTextField txtFdXPoints;
    private JTextField txtFdWeapon;
    private JTextField txtFdArmor;
    private HeroModel newHero = null;

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
        this.txtFdName = new JTextField(10);
        JPanel panelTop2 = new JPanel();
        JLabel lblType = new JLabel("Type:");
        this.txtFdType = new JTextField(10);
        JPanel panelTop3 = new JPanel();
        JLabel lblLevel = new JLabel("Level:");
        this.txtFdLevel = new JTextField(10);
        JPanel panelTop4 = new JPanel();
        JLabel lblXPoints = new JLabel("X-Points:");
        this.txtFdXPoints = new JTextField(8);
        JPanel panelTop5 = new JPanel();
        JLabel lblWeapon = new JLabel("Weapon:");
        this.txtFdWeapon = new JTextField(9);
        JPanel panelTop6 = new JPanel();
        JLabel lblArmor = new JLabel("Armor:");
        this.txtFdArmor = new JTextField(9);
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
        txtFdLevel.setText("1");
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
        txtFdWeapon.setText("bow");
        panelTop5.add(lblWeapon);
        panelTop5.add(txtFdWeapon);
        panelMid.add(panelTop5);

        lblArmor.setEnabled(false);
        txtFdArmor.setEnabled(false);
        txtFdArmor.setText("jacket");
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

    public void createHeroListener(ActionListener listener){
        this.btnCreateHero.addActionListener(listener);
    }

    public void cancelListener(ActionListener listener){
        this.btnCanel.addActionListener(listener);
    }

    public void selectHeroImageListener(ActionListener listener){
        this.btnSelectHeroImage.addActionListener(listener);
    }

    public void setNewHero(List<HeroModel> heroList){
        try{
            if (this.txtFdName.getText().isEmpty() || this.txtFdType.getText().isEmpty()){
                JFrameHelper.ShowErrorDialog(this, "Hero Name and Type can not be empty!");
                return ;
            }
            for (HeroModel hero : heroList) {
                if (hero.getName().equalsIgnoreCase(this.txtFdName.getText())){
                    JFrameHelper.ShowErrorDialog(this, "Hero named: \""+ this.txtFdName.getText() +"\" already exists.");
                    return ;
                }
            }

            int level = Integer.parseInt(this.txtFdLevel.getText());
            int xPoint = Integer.parseInt(this.txtFdXPoints.getText());
            int attack = 0;
            int defense = 0;
            int HP = 0;
            WeaponType weapon = WeaponType.valueOf(this.txtFdWeapon.getText());
            ArmorType armor = ArmorType.valueOf(this.txtFdArmor.getText());
            String iconPath = "icon-path";

            if (this.txtFdType.getText().equalsIgnoreCase(CharacterType.elf.toString())){
                this.newHero = new ElfModel(this.txtFdName.getText(), CharacterType.elf, level, xPoint, attack, defense, HP, weapon, armor, HelmType.pot, iconPath);
            }
            else if (this.txtFdType.getText().equalsIgnoreCase(CharacterType.hunter.toString())){
                this.newHero = new HunterModel(this.txtFdName.getText(), CharacterType.hunter, level, xPoint, attack, defense, HP, weapon, armor, HelmType.pot, iconPath);
            }
            else if (this.txtFdType.getText().equalsIgnoreCase(CharacterType.knight.toString())){
                this.newHero = new KnightModel(this.txtFdName.getText(), CharacterType.knight, level, xPoint, attack, defense, HP, weapon, armor, HelmType.pot, iconPath);
            }
            else if (this.txtFdType.getText().equalsIgnoreCase(CharacterType.villager.toString())){
                this.newHero = new VillagerModel(this.txtFdName.getText(), CharacterType.villager, level, xPoint, attack, defense, HP, weapon, armor, HelmType.pot, iconPath);
            }
            else if (this.txtFdType.getText().equalsIgnoreCase(CharacterType.warrior.toString())){
                this.newHero = new HeroModel(this.txtFdName.getText(), CharacterType.warrior, level, xPoint, attack, defense, HP, weapon, armor, HelmType.pot, iconPath);
            }else{
                JFrameHelper.ShowErrorDialog(this, "Hero type: " + this.txtFdType.getText() + " is unknown.");
            }
        }catch(Exception exc){
            JFrameHelper.ShowErrorDialog(this, "Exception: " + exc.getMessage());
            System.out.println("Exception: " + exc.getMessage());
        }
    }

    public HeroModel getNewHero(){
        return (this.newHero);
    }
}