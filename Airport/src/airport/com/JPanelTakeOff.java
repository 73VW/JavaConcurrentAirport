
package airport.com;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelTakeOff extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelTakeOff(int _nbPisteDep, ImageIcon _imgRoad)
		{
		nbPisteDep = _nbPisteDep;
		imgRoad = _imgRoad;
		nbPlanesDeparting = 0;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbAvionsDep(int nbAvions)
		{
		nbPlanesDeparting = nbAvions;
		nbTakeOffLabel.setText("nb avion au départ :"+nbPlanesDeparting);
		updateImages();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void updateImages()
		{
		Iterator<JLabel> it = arrayDep.iterator();
		for(int i = 0; i < nbPlanesDeparting; i++)
			{
				JLabel label = it.next();
				label.setVisible(true);
			}
		for(int i = 0; i < nbPisteDep-nbPlanesDeparting; i++)
			{
			JLabel label = it.next();
			label.setVisible(false);
			}
		}

	private void geometry()
		{
		// JComponent : Instanciation

		ImageIcon imgTakeOff = new ImageIcon("img/takeoff.png");
		nbTakeOffLabel = new JLabel("nb avion au départ :"+nbPlanesDeparting, SwingConstants.CENTER);
		arrayDep = new ArrayList<JLabel>();
		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(2 + (nbPisteDep - 1), 1);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		for(int i = 1; i <= nbPisteDep; i++)
			{
			JLabel imgTakeOffLabel = new JLabel("", Tools.scaleImage(imgTakeOff, 50, 50), SwingConstants.CENTER);
			imgTakeOffLabel.setVisible(false);
			arrayDep.add(imgTakeOffLabel);
			add(new JLabel("", Tools.scaleImage(imgRoad, 50, 50), SwingConstants.CENTER));
			add(imgTakeOffLabel);
			}

		// JComponent : add
		add(nbTakeOffLabel);
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
	private int nbPisteDep;
	private int nbPlanesDeparting;
	private ImageIcon imgRoad;

	// Tools
	private JLabel nbTakeOffLabel;
	private ArrayList<JLabel> arrayDep;
	}
