
package airport.com;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBoutton extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBoutton(Thread[] threadList)
		{
		this.threadList=threadList;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		start = new JButton("Start");
		stop = new JButton("Stop");

		// Layout : Specification
			{
			FlowLayout flowLayout = new FlowLayout();
			setLayout(flowLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(start);
		add(stop);
		}

	private void control()
		{
		start.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				// TODO START
				for(int i = 0; i < threadList.length; i++)
					{
					threadList[i].start();
					}
				}
			});

		stop.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				// TODO STOP
				for(int i = 0; i < threadList.length; i++)
					{
					try
						{
						threadList[i].wait();
						}
					catch (InterruptedException e1)
						{
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					}
				}
			});
		}

	private void appearance()
		{
		//rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//input
	Thread[] threadList;

	// Tools
	private JButton start;
	private JButton stop;
	}
