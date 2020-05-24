import java.util.*;

public class ComparableVsComparator implements java.lang.Comparable<ComparableVsComparator> {

	String Name;
	int id;

	ComparableVsComparator(String Name, int id) {
		this.Name = Name;
		this.id = id;
	}

	public int compareTo(ComparableVsComparator obj) {
		return id - obj.id;
	}

	public String toString() {
		return Name;
	}

	public static void main(String[] args) {

		Comparator<ComparableVsComparator> byName = new Comparator<ComparableVsComparator>() {
			public int compare(ComparableVsComparator b1, ComparableVsComparator b2) {
				return b1.Name.compareTo(b2.Name);
			}
		};

		Comparator<ComparableVsComparator> byId = (ComparableVsComparator id1, ComparableVsComparator id2) -> {
			return id1.id - id2.id;
		};

		ComparableVsComparator obj1 = new ComparableVsComparator("First", 2);
		ComparableVsComparator obj2 = new ComparableVsComparator("Second", 1);
		ComparableVsComparator obj3 = new ComparableVsComparator("Fifth", 7);

		List<ComparableVsComparator> ls = new ArrayList<>();
		ls.add(obj1);
		ls.add(obj2);
		ls.add(obj3);

		Collections.sort(ls);
		System.out.println(ls);

		Collections.sort(ls, byId);
		System.out.println(ls);

		Collections.sort(ls, byName);
		System.out.println(ls);
	}
}