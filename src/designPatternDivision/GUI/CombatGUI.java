package designPatternDivision.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import designPatternDivision.Player;
import designPatternDivision.Scene.SceneControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CombatGUI
{

    public JFrame frame;
    public JTextArea combatStatusTextField;
    public JProgressBar expBar;
    public JProgressBar healthBar;
    public JButton btnSwitchWeapon;
    public JButton btnUseMedkit;
    public JButton btnFlee;
    public JButton btnSkill;
    public JButton btnSkill_1;
    public JButton btnReload;
    public JButton btnFire;
    public JComboBox<String> comboBox;
    public JTextField txtExp;
    public JTextField txtAvaliableExpPoint;
    public JTextField txtPlayerStatus;
    public JTextField txtHealthPoint;
    public JTextField txtWeapon;
    public JTextField txtSlot;
    public JTextField txtWeaponName;
    public JTextField txtSlot_1;
    public JTextField textField_1;
    public JTextField txtRoundleft;
    public JTextField textField;
    public JTextField expPoint;
    public JTextField txtMedkitLeft;
    public JTextField textField_3;
    public JTextField txtTarget;

    private int stage;
    private int difficulty;
    private SceneControl sceneControl;

    Player player = Player.getPlayerInstance();

    /**
     * Launch the application.
     */
    public static void main( String[] args )
    {
        EventQueue.invokeLater( new Runnable()
        {
            public void run()
            {
                try
                {
                    CombatGUI window = new CombatGUI();
                    window.frame.setVisible( true );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
            }
        } );
    }

    /**
     * Create the application.
     */
    public CombatGUI()
    {
        stage = 3;
        difficulty = 0;
        initialize();
        sceneControl = new SceneControl( stage , difficulty );
    }

    public CombatGUI( int stage , int difficulty )
    {
        this.stage = stage;
        this.difficulty = difficulty;
        initialize();
        sceneControl = new SceneControl( stage , difficulty );
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds( 100 , 100 , 797 , 670 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );

        combatStatusTextField = new JTextArea();
        combatStatusTextField.setText( "CombatStatusTextField" );
        combatStatusTextField.setBounds( 10 , 10 , 446 , 611 );
        frame.getContentPane().add( combatStatusTextField );

        expBar = new JProgressBar();
        expBar.setBounds( 466 , 81 , 305 , 14 );
        frame.getContentPane().add( expBar );

        txtExp = new JTextField();
        txtExp.setEditable( false );
        txtExp.setText( "Exp" );
        txtExp.setBounds( 466 , 50 , 66 , 21 );
        frame.getContentPane().add( txtExp );
        txtExp.setColumns( 10 );

        txtAvaliableExpPoint = new JTextField();
        txtAvaliableExpPoint.setEditable(false);
        txtAvaliableExpPoint.setText( "Avaliable Exp Point" );
        txtAvaliableExpPoint.setBounds( 572 , 50 , 124 , 21 );
        frame.getContentPane().add( txtAvaliableExpPoint );
        txtAvaliableExpPoint.setColumns( 10 );

        txtPlayerStatus = new JTextField();
        txtPlayerStatus.setEditable(false);
        txtPlayerStatus.setText( "Player Status" );
        txtPlayerStatus.setBounds( 466 , 105 , 88 , 21 );
        frame.getContentPane().add( txtPlayerStatus );
        txtPlayerStatus.setColumns( 10 );

        healthBar = new JProgressBar();
        healthBar.setBounds( 466 , 167 , 305 , 14 );
        frame.getContentPane().add( healthBar );

        txtHealthPoint = new JTextField();
        txtHealthPoint.setEditable(false);
        txtHealthPoint.setText( "Health Point" );
        txtHealthPoint.setBounds( 466 , 136 , 88 , 21 );
        frame.getContentPane().add( txtHealthPoint );
        txtHealthPoint.setColumns( 10 );

        txtWeapon = new JTextField();
        txtWeapon.setEditable(false);
        txtWeapon.setText( "Weapon" );
        txtWeapon.setBounds( 466 , 191 , 88 , 21 );
        frame.getContentPane().add( txtWeapon );
        txtWeapon.setColumns( 10 );

        txtSlot = new JTextField();
        txtSlot.setEditable(false);
        txtSlot.setText( "Slot1" );
        txtSlot.setBounds( 466 , 222 , 88 , 21 );
        frame.getContentPane().add( txtSlot );
        txtSlot.setColumns( 10 );

        txtWeaponName = new JTextField();
        txtWeaponName.setText( "weapon name , damage , rate of fire" );
        txtWeaponName.setBounds( 466 , 253 , 305 , 29 );
        frame.getContentPane().add( txtWeaponName );
        txtWeaponName.setColumns( 10 );

        txtSlot_1 = new JTextField();
        txtSlot_1.setEditable(false);
        txtSlot_1.setText( "Slot2" );
        txtSlot_1.setColumns( 10 );
        txtSlot_1.setBounds( 466 , 322 , 88 , 21 );
        frame.getContentPane().add( txtSlot_1 );

        textField_1 = new JTextField();
        textField_1.setText( "weapon name , damage , rate of fire" );
        textField_1.setColumns( 10 );
        textField_1.setBounds( 466 , 353 , 305 , 29 );
        frame.getContentPane().add( textField_1 );

        btnSwitchWeapon = new JButton( "switch weapon" );
        btnSwitchWeapon.setBounds( 635 , 292 , 136 , 51 );
        frame.getContentPane().add( btnSwitchWeapon );
        btnSwitchWeapon.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                sceneControl.getBattleScene().setPlayerNextMove( 1 , 0 );
            }
        } );

        txtRoundleft = new JTextField();
        txtRoundleft.setText( "left / round" );
        txtRoundleft.setColumns( 10 );
        txtRoundleft.setBounds( 466 , 291 , 88 , 21 );
        frame.getContentPane().add( txtRoundleft );

        textField = new JTextField();
        textField.setText( "left / round" );
        textField.setColumns( 10 );
        textField.setBounds( 466 , 392 , 88 , 21 );
        frame.getContentPane().add( textField );

        btnUseMedkit = new JButton( "use medkit" );
        btnUseMedkit.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                sceneControl.getBattleScene().setPlayerNextMove( 2 , 0 );
                textField_3.setText( String.valueOf( player.getPlayerHealthPoint().getMedkitNumber() ) );
                if ( player.getPlayerHealthPoint().getMedkitNumber() == 0 )
                {
                    btnUseMedkit.setEnabled( false );
                }
            }
        } );
        btnUseMedkit.setBounds( 635 , 191 , 136 , 51 );
        frame.getContentPane().add( btnUseMedkit );

        expPoint = new JTextField();
        expPoint.setBounds( 706 , 50 , 66 , 21 );
        frame.getContentPane().add( expPoint );
        expPoint.setColumns( 10 );

        txtMedkitLeft = new JTextField();
        txtMedkitLeft.setEditable(false);
        txtMedkitLeft.setText( "Medkit left" );
        txtMedkitLeft.setBounds( 605 , 136 , 91 , 21 );
        frame.getContentPane().add( txtMedkitLeft );
        txtMedkitLeft.setColumns( 10 );

        textField_3 = new JTextField();
        textField_3.setBounds( 705 , 136 , 66 , 21 );
        frame.getContentPane().add( textField_3 );
        textField_3.setColumns( 10 );

        btnFlee = new JButton( "Flee" );
        btnFlee.setBounds( 678 , 10 , 93 , 22 );
        frame.getContentPane().add( btnFlee );

        btnSkill = new JButton( "Skill 1" );
        btnSkill.setBounds( 466 , 463 , 136 , 51 );
        frame.getContentPane().add( btnSkill );

        btnSkill_1 = new JButton( "Skill 2" );
        btnSkill_1.setBounds( 635 , 463 , 136 , 51 );
        frame.getContentPane().add( btnSkill_1 );

        btnReload = new JButton( "reload" );
        btnReload.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
            }
        } );
        btnReload.setBounds( 635 , 391 , 136 , 51 );
        frame.getContentPane().add( btnReload );

        comboBox = new JComboBox<String>();
        comboBox.setBounds( 466 , 567 , 136 , 37 );
        frame.getContentPane().add( comboBox );

        btnFire = new JButton( "Fire" );
        btnFire.setBounds( 635 , 560 , 136 , 50 );
        frame.getContentPane().add( btnFire );

        txtTarget = new JTextField();
        txtTarget.setEditable(false);
        txtTarget.setText( "Target" );
        txtTarget.setBounds( 466 , 524 , 136 , 29 );
        frame.getContentPane().add( txtTarget );
        txtTarget.setColumns( 10 );
    }
}
