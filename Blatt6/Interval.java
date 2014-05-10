public class Interval implements Comparable<Interval>{
	int start;
	int ende;

	public Interval(int e, int e1){
		start = e;
		ende = e1;
	}

	public int getStart(){
		return start;
	}
	public int getEnd(){
		return ende;
	}
	public String toString(){
		String s = "Startzeit:" + Integer.toString(start) + "Endzeit:" + Integer.toString(ende) + "Diffenrenz:" + Integer.toString(ende-start);
		return s;
	}
	public int compareTo(Interval other){
		if(this.getEnd() > other.getEnd()){
			return 1;
		}
		else if(this.getEnd() == other.getEnd()){
			return 0;
		}
		else{
			return -11;
		}
	}
}