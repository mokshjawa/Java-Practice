/*
Given two lists, return a lists of lists containing the difference between the lists.
Example: a[1, 1, 2, 3, 4], b[1, 3, 5, 6] => [1, 2, 4], [5, 6]

Storage: O(a + b)
Runtime: O(a + b)
*/

public List<List<T>> diff(List<T> a, List<T> b)
{
	if (a == null || b == null)
	{
		throw new IllegalArgumentException();
	}

	HashMap<T, Integer> aMap = createMap(a);
	HashMap<T, Integer> bMap = createMap(b);
	List<List<T>> tgt = new ArrayList<ArrayList<T>>();

	ArrayList<T> aNotB = diffBetweenLists(aMap, bMap);
	ArrayList<T> bNotA = diffBetweenLists(bMap, aMap);

	tgt.add(aNotB);
	tgt.add(bNotA);

	return tgt;
}

public HashMap<T, Integer> createMap(List<T> a)
{
	// O(a)
	HashMap<T, Integer> tgt = new HashMap<>();

	for (T i : a)
	{
		if (tgt.contains(i))
		{
			tgt.put(i, tgt.get(i) + 1);
		}
		else
		{
			tgt.put(i, 1);
		}
	}

	return tgt;
}

public ArrayList<T> diffBetweenLists(HashMap<T, Integer> aMap, HashMap<T, Integer> bMap)
{
	ArrayList<T> aNotB = new ArrayList<T>;

	// O(b)
	for (Map.Entry<T, Integer> entry : aMap.entrySet())
	{
		int freqA = entry.getValue();
		int valueA = entry.getKey();
		int freqB = 0;

		if (bMap.contains(valueA))
		{
			freqB = bMap.get(valueA);
		}

		for (int i = 1; i <= freqA - freqB; i++)
		{
			aNotB.add(valueA);
		}
	}

	return aNotB;
}
