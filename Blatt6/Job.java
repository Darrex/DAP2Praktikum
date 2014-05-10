public class Job implements Comparable<Job>{
	int dauer;
	int dead;

	public Job(int a, int b){
		dauer = a;
		dead = b;
	}
	public int getDauer(){
		return dauer;
	}
	public int getDeadline(){
		return dead;
	}
	public String toString(){
		String s = "Dauer:" + Integer.toString(dauer) + "Deadline:" + Integer.toString(dead);
		return s;
	}
	public int compareTo(Job other){
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