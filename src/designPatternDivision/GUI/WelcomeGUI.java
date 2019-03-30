package designPatternDivision.GUI;

import designPatternDivision.Player;
import designPatternDivision.Scene.SafeAreaScene;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class WelcomeGUI
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
					WelcomeGUI window = new WelcomeGUI();
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
	public WelcomeGUI ()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds( 100 , 100 , 450 , 300 );
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(10, 51, 159, 124);
		btnNewGame.setToolTipText( "Start a new game (basically an alpha test)" );
		frame.getContentPane().add(btnNewGame);
		btnNewGame.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				Player player = Player.getPlayerInstance();
				player.newGameInit();
				SafeAreaGUI safeAreaGUI = new SafeAreaGUI();
				safeAreaGUI.main( null );
				frame.dispose();
			}
		} );
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(265, 51, 159, 124);
		btnLoadGame.setEnabled( false );
		btnLoadGame.setToolTipText( "Load Game Function , Work in Progress" );
		frame.getContentPane().add(btnLoadGame);
	}
}
