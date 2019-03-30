package designPatternDivision.GUI;

import designPatternDivision.Player;
import designPatternDivision.Scene.BattleScene;
import designPatternDivision.Scene.SceneControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CombatGUI
{

    private static CombatGUI combatGUI;
    private JFrame frame;
    private JTextArea combatStatusTextField;
    private JScrollPane scrollPane;
    private JProgressBar expBar;
    private JProgressBar healthBar;
    private JButton btnSwitchWeapon;
    private JButton btnUseMedkit;
    private JButton btnSkill1;
    private JButton btnSkill2;
    private JButton btnReload;
    private JButton btnFire;
    private JComboBox<String> targetBox;
    private JTextField txtExp;
    private JTextField txtAvaliableExpPoint;
    private JTextField txtPlayerStatus;
    private JTextField txtHealthPoint;
    private JTextField txtWeapon;
    private JTextField txtSlot1;
    private JTextField txtWeapon1Detail;
    private JTextField txtSlot2;
    private JTextField txtWeapon2Detail;
    private JTextField txtRoundLeft1;
    private JTextField txtRoundLeft2;
    private JTextField txtExpPoint;
    private JTextField txtMedkitLeft;
    private JTextField txtMedkitNumber;
    private JTextField txtTarget;

    private int stage;
    private int difficulty;
    private SceneControl sceneControl;
    private BattleScene battleScene;

    private int targetSelected = -1;

    private Player player = Player.getPlayerInstance();

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
        combatGUI = this;
        stage = 3;
        difficulty = 0;
        initialize();
        updateSkillStatus();
        updateWeaponInfo();
        setActiveWeapon();
        updateRoundInfo();
        setSkills();
        updateExpBar();
        updateHealthBar();
        updateTxtExpPoint();
        updateMedkitNumber();
        sceneControl = new SceneControl( stage , difficulty );
        battleScene = sceneControl.getBattleScene();
//        updateTargetBox();
    }

    public CombatGUI( int stage , int difficulty )
    {
        combatGUI = this;
        this.stage = stage;
        this.difficulty = difficulty;
        initialize();
        updateSkillStatus();
        updateWeaponInfo();
        setActiveWeapon();
        updateRoundInfo();
        setSkills();
        updateExpBar();
        updateHealthBar();
        updateTxtExpPoint();
        updateMedkitNumber();
        sceneControl = new SceneControl( stage , difficulty );
        battleScene = sceneControl.getBattleScene();
//        updateTargetBox();
    }

    /**
     * Initialize the contents of the frame.
     */

    public static CombatGUI getCombatGUIInstance()
    {
        return combatGUI;
    }

    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds( 100 , 100 , 797 , 670 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );
        frame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

        combatStatusTextField = new JTextArea();
        combatStatusTextField.setEditable( false );
        combatStatusTextField.setBounds( 10 , 10 , 446 , 611 );
        combatStatusTextField.setLineWrap( true );
        scrollPane = new JScrollPane( combatStatusTextField );
        scrollPane.setBounds( 10 , 10 , 446 , 611 );
        frame.getContentPane().add( scrollPane );

        expBar = new JProgressBar();
        expBar.setBounds( 466 , 81 , 305 , 14 );
        frame.getContentPane().add( expBar );
        expBar.setMinimum( 0 );
        expBar.setMaximum( player.getExperienceBar().getEXPERIENCE_CAP() );
        expBar.setStringPainted( true );

        txtExp = new JTextField();
        txtExp.setEditable( false );
        txtExp.setText( "Exp" );
        txtExp.setBounds( 466 , 50 , 66 , 21 );
        frame.getContentPane().add( txtExp );
        txtExp.setColumns( 10 );

        txtAvaliableExpPoint = new JTextField();
        txtAvaliableExpPoint.setEditable( false );
        txtAvaliableExpPoint.setText( "Avaliable Exp Point" );
        txtAvaliableExpPoint.setBounds( 572 , 50 , 124 , 21 );
        frame.getContentPane().add( txtAvaliableExpPoint );
        txtAvaliableExpPoint.setColumns( 10 );

        txtPlayerStatus = new JTextField();
        txtPlayerStatus.setEditable( false );
        txtPlayerStatus.setText( "Player Status" );
        txtPlayerStatus.setBounds( 466 , 105 , 88 , 21 );
        frame.getContentPane().add( txtPlayerStatus );
        txtPlayerStatus.setColumns( 10 );

        healthBar = new JProgressBar();
        healthBar.setBounds( 466 , 167 , 305 , 14 );
        frame.getContentPane().add( healthBar );
        healthBar.setMinimum( 0 );
        healthBar.setMaximum( player.getHealthPoint().getFullHealthPoint() );
        healthBar.setStringPainted( true );

        txtHealthPoint = new JTextField();
        txtHealthPoint.setEditable( false );
        txtHealthPoint.setText( "Health Point" );
        txtHealthPoint.setBounds( 466 , 136 , 88 , 21 );
        frame.getContentPane().add( txtHealthPoint );
        txtHealthPoint.setColumns( 10 );

        txtWeapon = new JTextField();
        txtWeapon.setEditable( false );
        txtWeapon.setText( "Weapon" );
        txtWeapon.setBounds( 466 , 191 , 88 , 21 );
        frame.getContentPane().add( txtWeapon );
        txtWeapon.setColumns( 10 );

        txtSlot1 = new JTextField();
        txtSlot1.setEditable( false );
        txtSlot1.setText( "Slot1" );
        txtSlot1.setBounds( 466 , 222 , 88 , 21 );
        frame.getContentPane().add( txtSlot1 );
        txtSlot1.setColumns( 10 );

        txtWeapon1Detail = new JTextField();
        txtWeapon1Detail.setEditable( false );
        txtWeapon1Detail.setText( "weapon name , damage , rate of fire" );
        txtWeapon1Detail.setBounds( 466 , 253 , 305 , 29 );
        frame.getContentPane().add( txtWeapon1Detail );
        txtWeapon1Detail.setColumns( 10 );

        txtSlot2 = new JTextField();
        txtSlot2.setEditable( false );
        txtSlot2.setText( "Slot2" );
        txtSlot2.setColumns( 10 );
        txtSlot2.setBounds( 466 , 322 , 88 , 21 );
        frame.getContentPane().add( txtSlot2 );

        txtWeapon2Detail = new JTextField();
        txtWeapon2Detail.setEditable( false );
        txtWeapon2Detail.setText( "weapon name , damage , rate of fire" );
        txtWeapon2Detail.setColumns( 10 );
        txtWeapon2Detail.setBounds( 466 , 353 , 305 , 29 );
        frame.getContentPane().add( txtWeapon2Detail );

        btnSwitchWeapon = new JButton( "Switch weapon" );
        btnSwitchWeapon.setBounds( 635 , 292 , 136 , 51 );
        frame.getContentPane().add( btnSwitchWeapon );
        btnSwitchWeapon.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                player.switchWeapon();
                setActiveWeapon();
                if ( player.getWeapon().getShotLeft() > 0 )
                {
                    btnFire.setEnabled( true );
                }
                else
                {
                    btnFire.setEnabled( false );
                }
                if ( player.getWeapon().getShotLeft() < player.getWeapon().getMagazineSize() )
                {
                    btnReload.setEnabled( true );
                }
                else
                {
                    btnReload.setEnabled( false );
                }
            }
        } );

        txtRoundLeft1 = new JTextField();
        txtRoundLeft1.setEditable( false );
        txtRoundLeft1.setText( "left / round" );
        txtRoundLeft1.setColumns( 10 );
        txtRoundLeft1.setBounds( 466 , 291 , 88 , 21 );
        frame.getContentPane().add( txtRoundLeft1 );

        txtRoundLeft2 = new JTextField();
        txtRoundLeft2.setEditable( false );
        txtRoundLeft2.setText( "left / round" );
        txtRoundLeft2.setColumns( 10 );
        txtRoundLeft2.setBounds( 466 , 392 , 88 , 21 );
        frame.getContentPane().add( txtRoundLeft2 );

        btnUseMedkit = new JButton( "Use medkit" );
        btnUseMedkit.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                sceneControl.getBattleScene().setPlayerNextMove( 2 , 0 );
                updateMedkitNumber();
                if ( player.getPlayerHealthPoint().getMedkitNumber() == 0 )
                {
                    btnUseMedkit.setEnabled( false );
                }
            }
        } );
        btnUseMedkit.setBounds( 635 , 191 , 136 , 51 );
        frame.getContentPane().add( btnUseMedkit );

        txtExpPoint = new JTextField();
        txtExpPoint.setEditable( false );
        txtExpPoint.setBounds( 706 , 50 , 66 , 21 );
        frame.getContentPane().add( txtExpPoint );
        txtExpPoint.setColumns( 10 );

        txtMedkitLeft = new JTextField();
        txtMedkitLeft.setEditable( false );
        txtMedkitLeft.setText( "Medkit left" );
        txtMedkitLeft.setBounds( 605 , 136 , 91 , 21 );
        frame.getContentPane().add( txtMedkitLeft );
        txtMedkitLeft.setColumns( 10 );

        txtMedkitNumber = new JTextField();
        txtMedkitNumber.setEditable( false );
        txtMedkitNumber.setBounds( 705 , 136 , 66 , 21 );
        frame.getContentPane().add( txtMedkitNumber );
        txtMedkitNumber.setColumns( 10 );

        btnSkill1 = new JButton( "Skill 1" );
        btnSkill1.setBounds( 466 , 463 , 136 , 51 );
        frame.getContentPane().add( btnSkill1 );
        btnSkill1.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                sceneControl.getBattleScene().setPlayerNextMove( 3 , 0 );
            }
        } );

        btnSkill2 = new JButton( "Skill 2" );
        btnSkill2.setBounds( 635 , 463 , 136 , 51 );
        frame.getContentPane().add( btnSkill2 );
        btnSkill2.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                sceneControl.getBattleScene().setPlayerNextMove( 4 , 0 );
            }
        } );

        btnReload = new JButton( "Reload" );
        btnReload.setEnabled( false );
        btnReload.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                sceneControl.getBattleScene().setPlayerNextMove( 1 , 0 );
                updateRoundInfo();
                btnReload.setEnabled( false );
            }
        } );
        btnReload.setBounds( 635 , 391 , 136 , 51 );
        frame.getContentPane().add( btnReload );

        targetBox = new JComboBox<String>();
        targetBox.setBounds( 466 , 567 , 136 , 37 );
        frame.getContentPane().add( targetBox );
        setTargetBoxListener();

        btnFire = new JButton( "Fire" );
        btnFire.setBounds( 635 , 560 , 136 , 50 );
        frame.getContentPane().add( btnFire );
        btnFire.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
//                System.out.println( "Fire pressed" );
                sceneControl.getBattleScene().setPlayerNextMove( 0 , targetSelected );
                updateRoundInfo();
            }
        } );

        txtTarget = new JTextField();
        txtTarget.setEditable( false );
        txtTarget.setText( "Target" );
        txtTarget.setBounds( 466 , 524 , 136 , 29 );
        frame.getContentPane().add( txtTarget );
        txtTarget.setColumns( 10 );
    }

    private void setActiveWeapon()
    {
        int slot = player.getCurrentSlot();
        if ( slot == 1 )
        {
            txtSlot1.setEnabled( true );
            txtWeapon1Detail.setEnabled( true );
            txtRoundLeft1.setEnabled( true );
            txtSlot2.setEnabled( false );
            txtWeapon2Detail.setEnabled( false );
            txtRoundLeft2.setEnabled( false );
        }
        else
        {
            txtSlot2.setEnabled( true );
            txtWeapon2Detail.setEnabled( true );
            txtRoundLeft2.setEnabled( true );
            txtSlot1.setEnabled( false );
            txtWeapon1Detail.setEnabled( false );
            txtRoundLeft1.setEnabled( false );
        }
    }

    private void updateWeaponInfo()
    {
        String text;
        if ( player.getWeaponSlot1() != null )
        {
            text = player.getWeaponSlot1().getWeaponName() + " , DMG: " + player.getWeaponSlot1().getSingleShotDamage() + " , Rate of Fire : " + player.getWeaponSlot1().getRateOfFire();
            txtWeapon1Detail.setText( text );
        }
        if ( player.getWeaponSlot2() != null )
        {
            text = player.getWeaponSlot2().getWeaponName() + " , DMG: " + player.getWeaponSlot2().getSingleShotDamage() + " , Rate of Fire : " + player.getWeaponSlot2().getRateOfFire();
            txtWeapon2Detail.setText( text );
        }

    }

    private void updateRoundInfo()
    {
        if ( player.getWeaponSlot1() != null )
        {
            txtRoundLeft1.setText( String.valueOf( player.getWeaponSlot1().getShotLeft() + " / " + String.valueOf( player.getWeaponSlot1().getMagazineSize() ) ) );
            if ( player.getWeaponSlot1().getShotLeft() < player.getWeaponSlot1().getMagazineSize() )
            {
                btnReload.setEnabled( true );
            }
        }
        if ( player.getWeaponSlot2() != null )
        {
            txtRoundLeft2.setText( String.valueOf( player.getWeaponSlot2().getShotLeft() + " / " + String.valueOf( player.getWeaponSlot2().getMagazineSize() ) ) );
            if ( player.getWeaponSlot2().getShotLeft() < player.getWeaponSlot2().getMagazineSize() )
            {
                btnReload.setEnabled( true );
            }
        }
    }

    public void appendMsg( String input )
    {
        combatStatusTextField.append( input );
        combatStatusTextField.setCaretPosition( combatStatusTextField.getText().length() );
    }

    private void updateTargetBox()
    {
        if ( sceneControl == null || sceneControl.getBattleScene() == null )
        {
            return;
        }
        ArrayList<String> input = sceneControl.getBattleScene().getMobList();
        targetBox.removeAllItems();
        for ( int i = 0 ; i < input.size() ; i++ )
        {
            targetBox.addItem( input.get( i ) );
//            System.out.println( input.get( i ) );
        }
        frame.validate();
        frame.repaint();
        targetBox.setSelectedItem( null );
        btnFire.setEnabled( false );
        setTargetBoxListener();
    }

    private void setTargetBoxListener()
    {
        targetBox.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                targetSelected = targetBox.getSelectedIndex();
//                System.out.println( "Select " + targetSelected );
                if ( player.getWeapon().getShotLeft() > 0 )
                {
                    btnFire.setEnabled( true );
                }
            }
        } );
    }

    private void updateTxtExpPoint()
    {
        txtExpPoint.setText( String.valueOf( player.getExperienceBar().getPlayerLevel() ) );
    }

    private void updateSkillStatus()
    {
        if ( player.getSkillSlot1() != null )
        {
            btnSkill1.setText( player.getSkillSlot1().getStatus() );
            if ( player.getSkillSlot1().isReady() )
            {
                btnSkill1.setEnabled( true );
            }
            else
            {
                btnSkill1.setEnabled( false );
            }
        }
        if ( player.getSkillSlot2() != null )
        {
            btnSkill2.setText( player.getSkillSlot2().getStatus() );
            if ( player.getSkillSlot2().isReady() )
            {
                btnSkill2.setEnabled( true );
            }
            else
            {
                btnSkill2.setEnabled( false );
            }
        }
    }

    private void setSkills()
    {
        player.updateSkillStatus();
        btnSkill1.setText( "Pulse" );
        if ( player.getSkillSlot1() != null )
        {
            btnSkill1.setText( player.getSkillSlot1().toString() );
            btnSkill1.setToolTipText( player.getSkillSlot1().skillDescription() );
            btnSkill1.setEnabled( true );
        }
        else
        {
            btnSkill1.setEnabled( false );
        }
        btnSkill2.setText( "FirstAid" );
        if ( player.getSkillSlot2() != null )
        {
            btnSkill2.setText( player.getSkillSlot2().toString() );
            btnSkill2.setToolTipText( player.getSkillSlot2().skillDescription() );
            btnSkill2.setEnabled( true );
        }
        else
        {
            btnSkill2.setEnabled( false );
        }
    }

    private void updateExpBar()
    {
        expBar.setValue( player.getExperienceBar().getCurrentExperiencePoint() );
    }

    private void updateHealthBar()
    {
        healthBar.setValue( player.getPlayerHealthPoint().getHealthPoint() );
        if ( healthBar.getValue() == healthBar.getMaximum() )
        {
            btnUseMedkit.setEnabled( false );
        }
        else
        {
            if ( Integer.valueOf( txtMedkitNumber.getText() ) != 0 )
            {
                btnUseMedkit.setEnabled( true );
            }
        }
    }

    private void updateMedkitNumber()
    {
        txtMedkitNumber.setText( String.valueOf( player.getPlayerHealthPoint().getMedkitNumber() ) );
    }

    private void isPlayerDead()
    {
        if ( player.getHealthPoint().isDead() )
        {
            JOptionPane.showConfirmDialog( null , "You have lost conscious, backing to safe area" , null , JOptionPane.DEFAULT_OPTION );
            sceneControl = null ;
            SafeAreaGUI safeAreaGUI = new SafeAreaGUI();
            safeAreaGUI.main( null );
            frame.dispose();
        }
    }

    public void missionCleared()
    {
        JOptionPane.showConfirmDialog( null , "Mission cleared, backing to safe area" , null , JOptionPane.DEFAULT_OPTION );
        sceneControl = null;
        SafeAreaGUI safeAreaGUI = new SafeAreaGUI();
        safeAreaGUI.main( null );
        frame.dispose();
    }

    public void perMoveAction()
    {
        isPlayerDead();
        if ( sceneControl.getBattleScene() != null )
        {
            updateSkillStatus();
            updateExpBar();
            updateHealthBar();
            updateTargetBox();
            updateTxtExpPoint();
            updateMedkitNumber();
        }
    }
}
