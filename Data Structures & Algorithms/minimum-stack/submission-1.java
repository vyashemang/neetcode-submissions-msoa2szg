class MinStack {

    Stack<Integer> s = new Stack<>(); 
    Stack<Integer> minS = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        s.push(val);
        if (minS.isEmpty() || minS.peek() >= val) {
            minS.push(val);
        }
    }
    
    public void pop() {
        int elem = s.pop();
        if (elem == minS.peek()) {
            minS.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}
