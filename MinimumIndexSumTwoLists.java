class Solution {
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
               
        for (int i = 0; i < list1.length; i++)
        {
            map.put(list1[i], i);
        }
       
        for (int i = 0; i < list2.length; i++)
        {
            if (map.containsKey(list2[i]))
            {
                int sum = map.get(list2[i]) + i;
                
                if (sum < minSum)
                {
                    minSum = sum;
                    result.clear();
                    result.add(list2[i]);
                }
                else if (sum == minSum)
                {
                    result.add(list2[i]);
                }
            }
        }
               
        return result.toArray(new String[result.size()]);
    }
}