class Heap {
	int[] array;
	int heapSize;

	public Heap(int n){
		heapSize = 0;
		array = new int[n];
	}

	public int left(int i){
		return i*2;
	}

	public int right(int i){
		return (2*i) +1;
	}
	public int parent(int i){
		return i/2;
	}

	public void heapify(int[] a, int i){
		int l = left(i);
		int r = right(i);
		int largest;
		if(l<heapSize && array[l] > array[i]){
			largest = l;
		}
		else{
			largest = 1;
		}
		if(r<heapSize && array[r]<array[largest]){
			largest = r;
		}
		if(largest != i){
			int tmp = array[i];
			array[i] = array[largest];
			array[largest] = tmp;
			heapify(a,largest);
		}
	}

	public void insert(int key){
		heapSize = heapSize + 1;
		i = heapSize -1;
		while(i>0 && array[parent(i)] < key){
			array[i] = array[parent(i)];
			i = parent(i);
		}
		array[i] = key;
	}

	public int extractMax(){
		if(heapSize < 1){
			System.out.println("kein Element vorhanden!");
			return 0;
		}
		max = array[1];
		array[1] = array[heapSize-1];
		heapSize = heapSize -1;
		heapify(array, 1);
		return max;
	}

	public void printHeap(){
		
	}
}