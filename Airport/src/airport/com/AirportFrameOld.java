package airport.com;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class AirportFrameOld extends JFrame {

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


	public AirportFrameOld(int _nbPisteArr, int _nbPisteDep, int _nbPlace, int _nbAvion) {
		nbPisteArr = _nbPisteArr;
		nbPisteDep = _nbPisteDep;
		nbPlace = _nbPlace;

		avionOnAirArray = new ArrayList<Avion>();
		avionLandingArray = new ArrayList<Avion>();
		avionTermArray = new ArrayList<Avion>();
		avionTakeOffArray = new ArrayList<Avion>();
		avionOnAirLeaveArray = new ArrayList<Avion>();

		JPanel panel = new JPanel(new BorderLayout());

		JPanel jPanelAirport = new JPanelAirport(_nbPisteArr, _nbPisteDep);

		panel.add(jPanelAirport, BorderLayout.CENTER);


		JPanel jPanelPark = new JPanelPark(_nbPlace);
		panel.add(jPanelPark, BorderLayout.SOUTH);

		JPanel jPanelOnAir = new JPanelOnAir();
		panel.add(jPanelOnAir, BorderLayout.NORTH);


		JPanel jPanelBoutton = new JPanelBoutton();
		panel.add(jPanelBoutton,BorderLayout.EAST);
		this.getContentPane().add(panel);
	}
}
