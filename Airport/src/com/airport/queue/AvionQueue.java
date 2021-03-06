
package com.airport.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import com.airport.general.AirportFrame;

public class AvionQueue implements Runnable
	{

	AirportFrame airportFrame;
	String planeCode;
	BlockingQueue<AvionQueue> airArr;
	BlockingQueue<AvionQueue> tarmacLand;
	BlockingQueue<AvionQueue> tarmacTakeOff;
	BlockingQueue<AvionQueue> terminal;
	BlockingQueue<AvionQueue> airDep;
	int nbAvion;
	int nbPisteArr;
	int nbPisteDep;
	int nbPlace;
	int sleepUnit;

	int position;

	public AvionQueue(AirportFrame _airportFrame, String _planeCode, BlockingQueue<AvionQueue> _airArr, BlockingQueue<AvionQueue> _tarmacLand, BlockingQueue<AvionQueue> _tarmacTakeOff, BlockingQueue<AvionQueue> _terminal, BlockingQueue<AvionQueue> _airDep, int _nbAvion, int _nbPisteArr,
			int _nbPisteDep, int _nbPlace)
		{
		airportFrame = _airportFrame;
		planeCode = _planeCode;

		airArr = _airArr;
		tarmacLand = _tarmacLand;
		tarmacTakeOff = _tarmacTakeOff;
		terminal = _terminal;
		airDep = _airDep;

		nbAvion = _nbAvion;
		nbPisteArr = _nbPisteArr;
		nbPisteDep = _nbPisteDep;
		nbPlace = _nbPlace;

		sleepUnit = 1000;
		}

	@Override
	public void run()
		{
		while(true)
			{
			try
				{
				inAirArrive();
				landing();
				terminal();
				liftOn();
				inAirDep();
				}
			catch (InterruptedException e)
				{
				}
			}
		}

	private void inAirArrive() throws InterruptedException
		{
		System.out.println(this.getCode() + "in air");
		airArr.add(this);
		airDep.remove(this);
		this.airportFrame.setNbAvionsAirArr(airArr.size());
		this.airportFrame.setNbAvionsAirDep(airDep.size());
		int sleepTime = new Random().nextInt(10);
		Thread.sleep(sleepTime * sleepUnit);
		}

	private void landing() throws InterruptedException
		{
		System.out.println(this.getCode() + "landing");
		tarmacLand.add(this);
		airArr.remove(this);
		this.airportFrame.setNbAvionsLand(tarmacLand.size());
		this.airportFrame.setNbAvionsAirArr(airArr.size());
		int sleepTime = new Random().nextInt(10);
		Thread.sleep(sleepTime * sleepUnit);
		}

	private void terminal() throws InterruptedException
		{
		System.out.println(this.getCode() + "moving to terminal");
		terminal.add(this);
		tarmacLand.remove(this);
		this.airportFrame.setNbAvionsTarmac(terminal.size());
		this.airportFrame.setNbAvionsLand(tarmacLand.size());
		int sleepTime = new Random().nextInt(10);
		Thread.sleep(sleepTime * sleepUnit);
		}

	private void liftOn() throws InterruptedException
		{
		System.out.println(this.getCode() + "moving to tarmac");
		tarmacTakeOff.add(this);
		terminal.remove(this);
		this.airportFrame.setNbAvionsDep(tarmacTakeOff.size());
		this.airportFrame.setNbAvionsTarmac(terminal.size());
		int sleepTime = new Random().nextInt(10);
		Thread.sleep(sleepTime * sleepUnit);
		}

	private void inAirDep() throws InterruptedException
		{
		System.out.println(this.getCode() + "Departing");
		airDep.add(this);
		tarmacTakeOff.remove(this);
		this.airportFrame.setNbAvionsAirDep(airDep.size());
		this.airportFrame.setNbAvionsDep(tarmacTakeOff.size());
		int sleepTime = new Random().nextInt(10);
		Thread.sleep(sleepTime * sleepUnit);
		}

	public String getCode()
		{
		return planeCode;
		}

	}
