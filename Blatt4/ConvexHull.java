import java.util.LinkedList;
import java.util.List;
public class ConvexHull {
	
	public List<Point> simpleConvex(Point[] P){
		boolean valid;
		Point[] E = new Point[P.length];		//Erzeugung der menge e,welche die kanten enthalten soll
		int count = 0;							
		LinkedList<Point> hull = new LinkedList<Point>();  //erzeugenung der Liste,welche zurückgegeben werden soll
		for (int i = 0; i<P.length;i++){
			for(int j = 0; j<P.length; j++){
				if(P[i] != P[j]){					//P[j] muss ungleich P[i] sein, da sonst keine Gerade entstehen würde
					valid = true;
					for(int k = 0; k<P.length;k++){
						if(P[k] != P[j] && P[k] != P[i]){	//P[k] stammt aus der Menge P ohne P[i] und P[j]
							if(hilfs(P[i],P[j],P[k])){
								valid = false;
							}
						}
					}
					if(valid == true){
						E[count] = P[i];		//befüllen der Menge
						//E[count+1] = P[j];
						//count++;
						count++;
					}
				}
			}
		}
		hull.addFirst(E[0]);				//Befüllen der Liste
		hull.addLast(E[1]);
		count = 2;
		while (E[count] != null && count < E.length){
			hull.add(E[count]);
			count++;
		}
		return hull;
	}
	
	public boolean hilfs(Point a, Point b, Point c){		//hilfsfunktion zur bestimmung ob ein Punkt rechst oder links einer gerichteten geraden liegt
		boolean g;
		double erg = (b.get(0) - a.get(0))*(c.get(1) - a.get(1)) - (c.get(0) - a.get(0))*(b.get(1) - a.get(1));
		if(erg > 0){
			return true;
		}
		return false;
	}
	
}	
