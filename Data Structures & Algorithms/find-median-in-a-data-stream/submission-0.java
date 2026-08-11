class MedianFinder {

    PriorityQueue<Integer> large; // contains large elem
    PriorityQueue<Integer> small; // contains small elem


    public MedianFinder() {
        large = new PriorityQueue<>((a, b) -> (a - b));
        small = new PriorityQueue<>((a, b) -> (b - a)); 
    }
    
    public void addNum(int num) {
        small.add(num);

        if (small.size() - large.size() > 1 || !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        if (large.size() - small.size() > 1) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() == large.size()) {
            return (double) (large.peek() + small.peek()) / 2;
        } else if (small.size() > large.size()) {
            return (double) small.peek();
        } else{
            return (double) large.peek();
        }
    }
}
