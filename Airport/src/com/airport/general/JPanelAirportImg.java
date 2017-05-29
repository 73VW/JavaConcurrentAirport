
package com.airport.general;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelAirportImg extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelAirportImg()
		{
		nbAvions = 0;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbAvionsTarmac(int nbAvions)
		{
		this.nbAvions = nbAvions;
		jLabelNbTerm.setText("nb avion au terminal :" + this.nbAvions);
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

	private void geometry()
		{
		// JComponent : Instanciation
		ImageIcon imgAir = new ImageIcon("img/airport.png");

		jLabelNbTerm = new JLabel("nb avion au terminal :" + nbAvions, SwingConstants.CENTER);

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(3, 1);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(new JLabel("", Tools.scaleImage(imgAir, 150, 150), SwingConstants.CENTER));
		add(jLabelNbTerm);
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
	// Input
	private int nbAvions;

	// Tools

	private JLabel jLabelNbTerm;

	}
