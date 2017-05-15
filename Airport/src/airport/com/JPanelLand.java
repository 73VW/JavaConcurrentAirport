
package airport.com;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelLand extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelLand(int _nbPisteArr, ImageIcon _imgRoad)
		{
		nbPisteArr = _nbPisteArr;
		imgRoad = _imgRoad;
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
		imgLand = new ImageIcon("img/landing.png");

		arrayArr = new ArrayList<JLabel>();

		nbLandingLabel = new JLabel("nb avion en approche :", SwingConstants.CENTER);

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(2 + (nbPisteArr - 1), 1);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add

		for(int i = 1; i <= nbPisteArr; i++)
			{
			JLabel imgLandingLabel = new JLabel("", Tools.scaleImage(imgLand, 50, 50), SwingConstants.CENTER);
			imgLandingLabel.setVisible(false);
			arrayArr.add(imgLandingLabel);
			add(imgLandingLabel);
			add(new JLabel("", Tools.scaleImage(imgRoad, 50, 50), SwingConstants.CENTER));
			}
		add(new JLabel());
		add(nbLandingLabel);

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

	// Tools
	private JLabel nbLandingLabel;
	private ArrayList<JLabel> arrayArr;
	private ImageIcon imgRoad;
	private ImageIcon imgLand;

	}
