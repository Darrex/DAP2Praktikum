public class Job implements Comparable<Job>{
	int dauer;								//Deklarieren der Klassenvariablen
	int dead;

	public Job(int a, int b){				//Konstruktor
		dauer = a;
		dead = b;	
	}
	public int getDauer(){					//Rückgabe der Intervalldauer
		return dauer;
	}
	public int getDeadline(){				//Rückgabe der Deadline
		return dead;
	}
	public String toString(){				//String Ausgabe des Jobs
		String s = "[" + dauer + "," + dead + "]";
		return s;
	}
	public int compareTo(Job other){		//compareTo zum vergleichen
		if(this.getDeadline() > other.getDeadline()){
			return 1;
		}
		else if(this.getDeadline() == other.getDeadline()){
			return 0;
		}
		else{
			return -1;
		}
	}
}