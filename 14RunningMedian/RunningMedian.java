public class RunningMedian{

    private int med;
    private MyHeap minHeap;
	private MyHeap maxHeap;
    private boolean hasMedian;

    public RunningMedian(){
		maxHeap = new MyHeap(true);
		minHeap = new MyHeap(false);
		hasMedian = false; 
    }

    public void add(int x){
		if (!hasMedian){
			med = x;
			hasMedian = true;
		}
		else if(minHeap.getSize() == maxHeap.getSize()){
			if(x < med){
				maxHeap.add(x);
				}
			else{
				minHeap.add(x);
			}
		}
		else if(maxHeap.getSize() > minHeap.getSize()){
			if (x < med){
				maxHeap.add(x);
				minHeap.add(med);
				med = maxHeap.remove();
			}
			else{
				minHeap.add(x);
			}
		}
		else{
			if(x > med){
				minHeap.add(x);
				maxHeap.add(med);
				med = minHeap.remove();
			}
			else{
				maxHeap.add(x);
			}
		}
    }
	 
    public double getMedian(){
		if (minHeap.getSize() == maxHeap.getSize()){
			return med;
		}
		if (minHeap.getSize() > maxHeap.getSize()){
			return (minHeap.peek() + med) / 2.0;
		}
		else{
			return (maxHeap.peek() + med) / 2.0;
		}
    }

}













