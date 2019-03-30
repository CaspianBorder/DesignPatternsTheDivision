package designPatternDivision.GUI;

import designPatternDivision.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeAreaGUI
{

	private JFrame frame;

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
					SafeAreaGUI window = new SafeAreaGUI();
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
	public SafeAreaGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Player player = Player.getPlayerInstance();
		player.getPlayerHealthPoint().resupplyMedkit();
		player.getPlayerHealthPoint().resetHealthPoint();
		player.resetSkill();
		player.getWeaponSlot1().reloadMagazine();
		player.getWeaponSlot2().reloadMagazine();

		frame = new JFrame();
		frame.setBounds( 100 , 100 , 467 , 250 );
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.getContentPane().setLayout(null);
		
		JButton btnSkillUpgrade = new JButton("Skill Upgrade");
		btnSkillUpgrade.setBounds(10, 30, 119, 23);
		btnSkillUpgrade.setEnabled( false );
		btnSkillUpgrade.setToolTipText( "Skill upgrade sector, where you can use your exp point to upgrade your skill, Work in Progress" );
		frame.getContentPane().add(btnSkillUpgrade);
		
		JButton btnWeaponvendor = new JButton("WeaponVendor");
		btnWeaponvendor.setBounds(10, 87, 119, 23);
		btnWeaponvendor.setEnabled( false );
		btnWeaponvendor.setToolTipText( "Weapon vendor sector, where you can buy new weapon with your exp point, Work in Progress" );
		frame.getContentPane().add(btnWeaponvendor);
		
		JButton btnWeaponstorage = new JButton("WeaponStorage");
		btnWeaponstorage.setBounds(10, 149, 119, 23);
		btnWeaponstorage.setEnabled( false );
		btnWeaponstorage.setToolTipText( "Weapon Storage, where you can manage your weapon and set your combat weapon, Work in Progress" );
		frame.getContentPane().add(btnWeaponstorage);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(215, 58, 226, 23);
		String alphaMission = "Madison Field Hospital - Normal";
		comboBox.addItem( alphaMission );
		frame.getContentPane().add(comboBox);
		
		JButton btnStartmission = new JButton("StartMission");
		btnStartmission.setBounds(215, 123, 226, 23);
		frame.getContentPane().add(btnStartmission);
		btnStartmission.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				CombatGUI combatGUI = new CombatGUI();
				combatGUI.main( null );
				frame.dispose();
			}
		} );
	}
}
