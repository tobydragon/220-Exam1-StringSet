package edu.ithaca.dragon.datastructures.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringSetTest {

    //TODO: replace all nulls in this file with calls to your StringSet constructor

    @Test
    public void addContainsSizeTest(){
        StringSet testSet = null;
        assertEquals(0, testSet.size());
        assertFalse(testSet.contains("anything"));

        testSet.add("Maria");
        assertTrue(testSet.contains("Maria"));
        testSet.add("George");
        assertTrue(testSet.contains("George"));
        assertTrue(testSet.contains("Maria"));
        assertEquals(2, testSet.size());
        assertFalse(testSet.contains("maria"));

        testSet.add("Maria");
        testSet.add("George");
        assertEquals(2, testSet.size());

        testSet.add("Lisa");
        assertTrue(testSet.contains("Lisa"));
        assertTrue(testSet.contains("Maria"));
        assertTrue(testSet.contains("George"));
        assertEquals(3, testSet.size());

        assertFalse(testSet.contains("Rufus"));
    }

    @Test
    public void addContainsSizeTestLarge(){
        StringSet testSet = null;
        for (int i=0; i<597; i++){
            testSet.add(Integer.toString(i));
        }
        assertEquals(597, testSet.size());
        for (int i=333; i<399; i++){
            testSet.add(Integer.toString(i));
        }
        assertEquals(597, testSet.size());
        for (int i=555; i<673; i++){
            testSet.add(Integer.toString(i));
        }
        assertEquals(673, testSet.size());
        for (int i=0; i<673; i++){
            assertTrue(testSet.contains(Integer.toString(i)));
        }
        for (int i=673; i<899; i++){
            assertFalse(testSet.contains(Integer.toString(i)));
        }
        
    }

    @Test
    public void toArrayTest1(){
        StringSet testSet = null;
        testSet.add("Maria");
        testSet.add("George");
        testSet.add("Lisa");
        
        String[] ansArray = testSet.toArray();
        assertEquals(3, ansArray.length);
        int totalFound = 0;
        for (String item : ansArray){
            if (item.equals("Maria")){
                totalFound++;
            }
            else if (item.equals("George")){
                totalFound++;
            }
            else if (item.equals("Lisa")){
                totalFound++;
            }
        }
        assertEquals(3, totalFound);

        ansArray[0] = null;
        ansArray[1] = null;
        ansArray[2] = null;

        assertTrue(testSet.contains("Lisa"));
        assertTrue(testSet.contains("Maria"));
        assertTrue(testSet.contains("George"));

        StringSet emptySet = null;
        assertEquals(0, emptySet.toArray().length);
    }

    @Test
    public void toArrayTestLarge(){
        StringSet testSet = null;
        for (int i=0; i<133; i++){
            testSet.add(Integer.toString(i));
        }
        String[] ansArray = testSet.toArray();
        assertEquals(133, ansArray.length);
        for (String item : ansArray){
            assertTrue(Integer.parseInt(item) >= 0 && Integer.parseInt(item) < 133);
        }
    }
    
    @Test
    public void unionTest1(){
        StringSet testSet1 = null;
        testSet1.add("1");
        testSet1.add("2");
        testSet1.add("3");
        
        StringSet testSet2 = null;
        testSet2.add("4");
        testSet2.add("5");
        testSet2.add("6");

        StringSet ansSet = testSet1.union(testSet2);
        assertEquals(6, ansSet.size());
        for (int i=1; i<7; i++){
            assertTrue(ansSet.contains(Integer.toString(i)));
        }
        assertEquals(3, testSet1.size());
        assertEquals(3, testSet2.size());

        StringSet ansSet2 = testSet2.union(testSet1);
        assertEquals(6, ansSet2.size());
        for (int i=1; i<7; i++){
            assertTrue(ansSet2.contains(Integer.toString(i)));
        }
        assertEquals(3, testSet1.size());
        assertEquals(3, testSet2.size());
    }
    
    @Test
    public void unionTest2(){
        StringSet testSet2 = null;
        testSet2.add("2");
        testSet2.add("3");
        testSet2.add("100");
        testSet2.add("4");
        testSet2.add("5");
        
        StringSet testSet1 = null;
        testSet1.add("6");
        testSet1.add("3");
        testSet1.add("2");
        testSet1.add("1");
        testSet1.add("200");
        testSet1.add("5");
        testSet1.add("5");

        StringSet ansSet1 = testSet1.union(testSet2);
        assertEquals(8, ansSet1.size());
        for (int i=1; i<6; i++){
            assertTrue(ansSet1.contains(Integer.toString(i)));
        }
        assertTrue(ansSet1.contains("100"));
        assertTrue(ansSet1.contains("200"));

        assertEquals(6, testSet1.size());
        assertEquals(5, testSet2.size());

        StringSet ansSet2 = testSet2.union(testSet1);
        assertEquals(8, ansSet2.size());
        for (int i=1; i<6; i++){
            assertTrue(ansSet2.contains(Integer.toString(i)));
        }
        assertTrue(ansSet2.contains("100"));
        assertTrue(ansSet2.contains("200"));

        StringSet emptySet1 = null;
        StringSet emptySet2 = null;
        assertEquals(0, emptySet1.union(emptySet2).size());
    }

    @Test
    public void intersectionTest1(){
        StringSet testSet1 = null;
        testSet1.add("1");
        testSet1.add("2");
        testSet1.add("3");
        testSet1.add("4");
        testSet1.add("5");
        testSet1.add("6");
        
        StringSet testSet2 = null;
        testSet2.add("4");
        testSet2.add("7");
        testSet2.add("9");
        testSet2.add("2");
        testSet2.add("8");
        testSet2.add("6");

        StringSet ansSet = testSet1.intersection(testSet2);
        assertEquals(3, ansSet.size());
        assertTrue(ansSet.contains("2"));
        assertTrue(ansSet.contains("4"));
        assertTrue(ansSet.contains("6"));

        StringSet ansSet2 = testSet2.intersection(testSet1);
        assertEquals(3, ansSet2.size());
        assertTrue(ansSet2.contains("2"));
        assertTrue(ansSet2.contains("4"));
        assertTrue(ansSet2.contains("6"));

        assertEquals(6, testSet1.size());
        assertEquals(6, testSet2.size());

        StringSet ansSet3 = testSet1.intersection(testSet1);
        assertEquals(6, ansSet3.size());
        assertTrue(ansSet3.contains("1"));
        assertTrue(ansSet3.contains("2"));
        assertTrue(ansSet3.contains("3"));
        assertTrue(ansSet3.contains("4"));
        assertTrue(ansSet3.contains("5"));
        assertTrue(ansSet3.contains("6"));
        
        StringSet testSet3 = null;
        testSet3.add("10");
        testSet3.add("11");
        testSet3.add("12");
        assertEquals(0, testSet1.intersection(testSet3).size());

        StringSet emptySet1 = null;
        StringSet emptySet2 = null;
        assertEquals(0, emptySet1.intersection(emptySet2).size());

    }
}
