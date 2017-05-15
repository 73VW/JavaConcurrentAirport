
package airport.com;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelAirport extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelAirport(int _nbPisteArr, int _nbPisteDep)
		{
		nbPisteArr = _nbPisteArr;
		nbPisteDep = _nbPisteDep;
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

		imgRoad = new ImageIcon("img/piste.png");

		JPanel jPanelLand = new JPanelLand(nbPisteArr, imgRoad);

		JPanel jPanelAirportImg = new JPanelAirportImg();

		JPanel takeOffPanel = new JPanelTakeOff(nbPisteDep, imgRoad);

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(1, 3);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelLand);
		add(jPanelAirportImg);
		add(takeOffPanel);

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
	//input
	private int nbPisteArr;
	private int nbPisteDep;

	// Tools
	private ImageIcon imgRoad;

	}
