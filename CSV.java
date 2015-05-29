package com.company;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by priyankachavan on 3/10/15.
 */
public class CSV implements Comparator{
    HashSet<Population> aCollection;
    public CSV(){}
    public CSV(HashSet<Population> collection)
    {
        this.aCollection = collection;
    }
    public HashSet<Population> readCSV() throws FileNotFoundException
    {

        String line;
        String aCity,aState;
        int Pop2010,Pop2011,Pop2012;
        Scanner scanner = new Scanner(new File("/users/priyankachavan/Downloads/population.csv"));
        scanner.useDelimiter(",");
        scanner.nextLine();

        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            Scanner aLine = new Scanner(line);
            aLine.useDelimiter(",");
            aCity = aLine.next();
            aState = aLine.next();
            Pop2010 = Integer.parseInt(aLine.next());
            Pop2011 = Integer.parseInt(aLine.next());
            Pop2012 = Integer.parseInt(aLine.next());

            Population anObject = new Population(aCity,aState,Pop2010,Pop2011,Pop2012);
            aCollection.add(anObject);
        }
        scanner.close();
        return aCollection;
    }
    public LinkedHashMap<String, Float> sortData()
    {
        /*LinkedList<Integer> aSortedList = new LinkedList<Integer>();
        Map<String,Integer> aMap =
        HashMap<String,Integer> aCityAndPopulation = new HashMap<String, Integer>();
        while(!aCollection.isEmpty())
        {
            for(Population p : aCollection)
            aCityAndPopulation.put(p.aCity,p.percentChange12and10());
        }
        if()
        return aSortedList; */
        List mapKeys = new ArrayList();
        List mapValues = new ArrayList();
        List stateList = new ArrayList();
        HashMap<String,Float> aMap = new HashMap<String,Float>();
        LinkedHashMap<String,Float> sortedMap = new LinkedHashMap<String,Float>();
        LinkedHashMap<String,String> states = new LinkedHashMap<String, String>();
        for(Population p : aCollection) {
            mapKeys.add(p.aCity);
            stateList.add(p.aState);
            mapValues.add(p.percentChange12and10());
            aMap.put(p.aCity,p.percentChange12and10());
            states.put(p.aState,p.aCity);
        }
            Collections.sort(stateList);
            Collections.sort(mapValues);
            Collections.sort(mapKeys);
        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = aMap.get(key).toString();
                String comp2 = val.toString();

                if (comp1.equals(comp2)){
                    aMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String)key, (Float)val);
                    break;
                }

            }

        }
        return sortedMap;
    }
    public LinkedHashMap<String,String> sortByState ()
    {
        LinkedHashMap<String,String> aCityAndState = new LinkedHashMap<String, String>();
        for(String s: sortedMap)
        {
            if(aCityAndState.containsKey())
        }



    }

    @Override
    public int compare(Object oneCity, Object secondCity) {
        if(((Population)oneCity).percentChange12and10() < ((Population)secondCity).percentChange12and10())
            return 0;
        else
            return -1;
    }
}
