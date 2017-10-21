import java.util.LinkedList;
import java.util.List;

public class Project {
	// Hilfsklasse
	class Rule {
		Rule(String newname) {
			prozessname = newname;
		}

		List<Rule> Bedingungen = new LinkedList<Rule>();
		String prozessname;
		boolean checked = false;
	}

	List<Rule> regeln = new LinkedList<Rule>();

	// Konstruktor
	public Project(String[][] newregeln) {
		super();
		// Regeln parsen
		for (int i = 0; i < newregeln.length; i++) {
			Rule newprozess;
			if (existprozess(newregeln[i][1]) == false) {
				newprozess = new Rule(newregeln[i][1]);
				regeln.add(newprozess);
			} else {
				newprozess = getrulebyname(newregeln[i][1]);
			}
			Rule newrequirements;
			if (existprozess(newregeln[i][0]) == false) {
				newrequirements = new Rule(newregeln[i][0]);
				regeln.add(newrequirements);
			} else {
				newrequirements = getrulebyname(newregeln[i][0]);
			}
			newprozess.Bedingungen.add(newrequirements);
		}
	}

	// Existiert der Prozess
	private boolean existprozess(String prozessname) {
		for (Rule tmp : regeln) {
			if (tmp.prozessname.equals(prozessname)) {
				return true;
			}
		}
		return false;
	}

	// Wirft den Prozess zurück
	private Rule getrulebyname(String prozessname) {
		for (Rule tmp : regeln) {
			if (tmp.prozessname.equals(prozessname)) {
				return tmp;
			}
		}
		return null;
	}

	public boolean isWellSorted(String[] sequence) { 
		 //Reset checked Status
		rulesreset(); 
		for(int i = 0; i< sequence.length;i++)
		{ 
			Rule testrule = getrulebyname(sequence[i]);
			//Sind alle Vorbedingunen erledigt 
			for(Rule tmprequirements : testrule.Bedingungen)
			{
				if(tmprequirements.checked == false) 
				{ 
					return false; 
				} 
			}
			testrule.checked = true; 
			} 
		return true; 
	} // Reset Status

	private void rulesreset() {
		for (Rule tmpregel : regeln) {
			tmpregel.checked = false;
		}
	}
}