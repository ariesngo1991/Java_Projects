import java.util.*;

public class MyCalendar {
    Set<List<Integer>> mCalendar;

    public MyCalendar() {
        mCalendar = new TreeSet<List<Integer>>(new myComparator());
    }

    public boolean book(int start, int end) {
        for (List<Integer> event : mCalendar) {
            if (start < event.get(1)) {
                if (end > event.get(0)) {
                    return false;
                }
            }
        }
        addtoCalendar(start, end);
        return true;

    }

    private void addtoCalendar(int start, int end) {
        List<Integer> period = new ArrayList<>();
        period.add(start);
        period.add(end);
        mCalendar.add(period);
    }

    class myComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> al1, List<Integer> al2) {
            int num1 = (int) al1.get(0);
            int num2 = (int) al2.get(0);
            return num1 - num2;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */