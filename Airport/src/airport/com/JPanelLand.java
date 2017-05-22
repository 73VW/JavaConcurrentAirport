
package airport.com;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

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
		nbPlanesLanding = 0;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbAvionsLand(int nbAvions)
		{
		nbPlanesLanding = nbAvions;
		nbLandingLabel.setText("nb avion en approche :"+nbPlanesLanding);
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
		Iterator<JLabel> it = arrayArr.iterator();
		for(int i = 0; i < nbPlanesLanding; i++)
			{
				JLabel label = it.next();
				label.setVisible(true);
			}
		for(int i = 0; i < nbPisteArr-nbPlanesLanding; i++)
			{
			JLabel label = it.next();
			label.setVisible(false);
			}
		}

	private void geometry()
		{
		// JComponent : Instanciation
		imgLand = new ImageIcon("img/landing.png");

		arrayArr = new ArrayList<JLabel>();

		nbLandingLabel = new JLabel("nb avion en approche :"+nbPlanesLanding, SwingConstants.CENTER);

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
	private int nbPlanesLanding;

	// Tools
	private JLabel nbLandingLabel;
	private ArrayList<JLabel> arrayArr;
	private ImageIcon imgRoad;
	private ImageIcon imgLand;

	}
