
package airport.com;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelOnAir extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelOnAir()
		{
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
		ImageIcon imgOnAir = new ImageIcon("img/onair.png");
		nbOnAirLabel = new JLabel("nb avion en air (arrive) :", SwingConstants.CENTER);
		nbOnAirLeaveLabel = new JLabel("nb avion en air (depart) :", SwingConstants.CENTER);
		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(2, 2);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(new JLabel("", Tools.scaleImage(imgOnAir, 50, 50), SwingConstants.CENTER));
		add(new JLabel("", Tools.scaleImage(imgOnAir, 50, 50), SwingConstants.CENTER));
		add(nbOnAirLabel);
		add(nbOnAirLeaveLabel);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel nbOnAirLabel;
	private JLabel nbOnAirLeaveLabel;

	}
