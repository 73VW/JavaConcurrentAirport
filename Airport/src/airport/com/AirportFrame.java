
package airport.com;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AirportFrame extends JFrame
	{

	private static final long serialVersionUID = 1L;
	//liste d'avion à chaque endroits
	private List<Avion> avionOnAirArray;
	private List<Avion> avionLandingArray;
	private List<Avion> avionTermArray;
	private List<Avion> avionTakeOffArray;
	private List<Avion> avionOnAirLeaveArray;

	//images d'avion

	private int nbPisteArr;
	private int nbPisteDep;
	private int nbPlace;

	private JPanelAirport jPanelAirport;
	private JPanelPark jPanelPark;
	private JPanelOnAir jPanelOnAir;
	private JPanelBoutton jPanelBoutton;

	private Thread[] threadList;

	public AirportFrame(int _nbPisteArr, int _nbPisteDep, int _nbPlace, Thread[] _threadList)
		{
		nbPisteArr = _nbPisteArr;
		nbPisteDep = _nbPisteDep;
		nbPlace = _nbPlace;

		threadList = _threadList;

		avionOnAirArray = new ArrayList<Avion>();
		avionLandingArray = new ArrayList<Avion>();
		avionTermArray = new ArrayList<Avion>();
		avionTakeOffArray = new ArrayList<Avion>();
		avionOnAirLeaveArray = new ArrayList<Avion>();

		JPanel panel = new JPanel(new BorderLayout());

		jPanelAirport = new JPanelAirport(nbPisteArr, nbPisteDep);

		panel.add(jPanelAirport, BorderLayout.CENTER);

		jPanelPark = new JPanelPark(nbPlace);
		panel.add(jPanelPark, BorderLayout.SOUTH);

		jPanelOnAir = new JPanelOnAir();
		panel.add(jPanelOnAir, BorderLayout.NORTH);

		jPanelBoutton = new JPanelBoutton(threadList);
		panel.add(jPanelBoutton, BorderLayout.EAST);
		this.getContentPane().add(panel);

		this.addWindowListener(new WindowAdapter()
			{

			@Override
			public void windowClosed(WindowEvent e)
				{
				// TODO Auto-generated method stub
				for(int i = 0; i < threadList.length; i++)
					{
					threadList[i].interrupt();
					}
				}
			});
		}

	public void setNbAvionsAirArr(int nbAvions)
		{
		this.jPanelOnAir.setNbAvionsAirArr(nbAvions);
		}

	public void setNbAvionsLand(int nbAvions)
		{
		this.jPanelAirport.setNbAvionsLand(nbAvions);
		}

	public void setNbAvionsTarmac(int nbAvions)
		{
		this.jPanelPark.setNbAvionsTarmac(nbAvions);
		}

	public void setNbAvionsDep(int nbAvions)
		{
		this.jPanelAirport.setNbAvionsDep(nbAvions);
		}

	public void setNbAvionsAirDep(int nbAvions)
		{
		this.jPanelOnAir.setNbAvionsAirDep(nbAvions);
		}
	}
