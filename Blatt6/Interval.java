public class Interval implements Comparable<Interval>{
	private int start;						//Deklarieren der Klassenvariablen
	private int ende;

	public Interval(int e, int e1){			//Konstruktor
		start = e;
		ende = e1;
	}

	public int getStart(){					//Start des Intervals bekommen
		return start;
	}
	public int getEnd(){					//Ende des Intervals bekommen
		return ende;
	}
	public String toString(){				//String ausgabe des Intervals
		String s = "[" + start + "," + ende + "]";
		return s;
	}
	public int compareTo(Interval other){	//compareTo zum vergleichen
		if(this.getEnd() > other.getEnd()){
			return 1;
		}
		else if(this.getEnd() == other.getEnd()){
			return 0;
		}
		else{
			return -1;
		}
	}
}