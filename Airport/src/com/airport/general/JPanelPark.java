
package com.airport.general;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelPark extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelPark(int _nbPlaces)
		{
		nbPlaces = _nbPlaces;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbAvionsTarmac(int nbAvions)
		{
		nbPlanesTarmac = nbAvions;
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
		Iterator<JLabel> it = listTerm.iterator();
		for(int i = 0; i < nbPlanesTarmac; i++)
			{
				JLabel label = it.next();
				label.setVisible(true);
			}
		for(int i = 0; i < nbPlaces-nbPlanesTarmac; i++)
			{
			JLabel label = it.next();
			label.setVisible(false);
			}
		}

	private void geometry()
		{
		// JComponent : Instanciation
		listTerm = new ArrayList<JLabel>();
		for(int i = 1; i <= nbPlaces; i++)
			{
			ImageIcon imgPark = new ImageIcon("img/waiting.png");
			JLabel imgParkLabel = new JLabel("", Tools.scaleImage(imgPark, 50, 50), SwingConstants.CENTER);
			imgParkLabel.setVisible(false);
			listTerm.add(imgParkLabel);
			imgParkLabel.setBorder(BorderFactory.createLineBorder(Color.black));

			// JComponent : add
			add(imgParkLabel);

			}
		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

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

	//inputs
	private int nbPlaces;
	private int nbPlanesTarmac;

	// Tools
	private ArrayList<JLabel> listTerm;

	}
