
package com.airport.list;

import java.util.LinkedList;

public class ListAvion
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ListAvion(int size)
		{
		this.size = size;
		listAvion = new LinkedList<AvionList>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//returns number of plane in list
	public int size()
		{
		return this.listAvion.size();
		}

	// Add plane in tab
	public void add(AvionList avion)
		{
		synchronized (monitor)
			{
			// wait if tab is full
			while(!(listAvion.size() < size))
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
			listAvion.add(avion);
			}

		}

	// Removes plane from tab
	public void remove(AvionList avion)
		{
		synchronized (monitor)
			{
			listAvion.remove(avion);


			//Notify that a place is free
			monitor.notifyAll();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private LinkedList<AvionList> listAvion;
	private int size;

	private final Object monitor = new Object();
	}
