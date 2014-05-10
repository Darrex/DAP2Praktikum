public class wechsel{
	
	public static void main(String[] args) throws Exception {
		if(args.length < 2 || args.length > 2){
			throw new Exception("Bitte 2 Parameter eingeben");
		}
		if(!args[0].equals("Euro") && !args[0].equals("Alternative")){
			throw new Exception("Als ersten Parameter die Währung angeben");
		}
		int b = Integer.parseInt(args[1]);
		if (b < 0) {
			throw new Exception("Betrag ist negativ");
		}
		int[] w;
		if(args[0].equals("Euro") ){
			w = new int[]{200,100,50,20,10,5,2,1};
			//w = {200,100,50,20,10,5,2,1};
		}
		else{
			w = new int[]{200,100,50,20,10,5,4,2,1};
			//w = {200,100,50,20,10,5,4,2,1};
		}
		w = change(b,w);
		int counter = 0;
		while(counter < w.length){
			System.out.println(w[counter]+"");
			counter++;
		}

	}

	public static int[] change(int b, int[] w){
		int counter = 0;
		while(b != 0 && counter < w.length){
			if(b >= w[counter]){
				int counter2 = 0;
				while(b - w[counter] >= w[counter]){
					b = b - w[counter];
					counter2++;
				}
				b = b - w[counter];
				//System.out.println(b);
				counter2++;
				w[counter] = counter2;
				counter++;
			}
			else{
				w[counter] = 0;
				counter++;
			}
			//System.out.println(b);
		}
		while(counter < w.length){
			w[counter] = 0;
			counter++;
		}
		return w;
		
	}
}