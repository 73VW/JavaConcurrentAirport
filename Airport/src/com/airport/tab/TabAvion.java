
package com.airport.tab;

public class TabAvion
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public TabAvion(int size)
		{
		this.size = size;
		tabAvion = new AvionTableau[size];
		nbAvion = 0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//returns number of plane in list
	public int size()
		{
		return this.nbAvion;
		}

	// Add plane in tab
	public void add(AvionTableau avion)
		{
		synchronized (monitor)
			{
			// wait if tab is full
			while(!(nbAvion < size))
				{
				try
					{
					monitor.wait();
					}
				catch (InterruptedException e)
					{
					e.printStackTrace();
					}
				}

			// When a plane is removed, we put it in
			int i = 0;
			while(i < size)
				{
				if (tabAvion[i] == null)
					{
					tabAvion[i] = avion;
					nbAvion++;
					break;
					}
				i++;
				}
			}
		}

	// Removes plane from tab
	public void remove(AvionTableau avion)
		{
		synchronized (monitor)
			{
			int i = 0;

			//Go through tab to find the plane to remove
			while(i < size)
				{
				if (tabAvion[i] == avion)
					{
					tabAvion[i] = null;
					nbAvion--;
					break;
					}
				i++;
				}

			//Notify that a place is free
			monitor.notifyAll();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private AvionTableau[] tabAvion;
	private int size;
	private int nbAvion;

	private final Object monitor = new Object();
	}
