class PriorityQueue{

	public static void main(String[] args) {
		if(args.length < 2 || args.length > 2){
			System.out.println("Bitte nur n und k eingeben!");
			return;
		}
		int n, k;
		try{
			n = Integer.parseInt(args[0]);
			k = Integer.parseInt(args[1]);
		}
		catch(Exception e){
			System.out.println("Bitte nur Zahlen eingeben!");
			return;
		}
		Heap job = new Heap(n+k);
		java.util.Random numberGenerator = new java.util.Random();
		for (int i = 0; i<n ;i++ ) {
			int zufall = numberGenerator.nextInt(100+1)
			job.insert(zufall);
			System.out.println(zufall + " wurde eingefügt!");
		}
		for(int i = 0; i<j;i++){
			if(numberGenerator.nextInt(100+1) < 25){
				int zufall = numberGenerator.nextInt(100+1)
				job.insert(zufall);
				System.out.println(zufall + " wurde eingefügt!");
			}
			else {
				int max = job.extractMax();
				System.out.println(max + " wurde entfernt!");
			}
		}
	}
}