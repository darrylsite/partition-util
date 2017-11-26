package com.darrylsite.test.partition;

import static org.junit.Assert.*;

import com.darrylsite.test.partition.PartitionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Darryl Kpizingui
 *
 */
public class PartitionUtilTest {

	@Test
	public void testPartition()
	{
		//Test null values
		assertTrue(PartitionUtil.partition(null, 1).isEmpty());
		assertTrue(PartitionUtil.partition(Collections.emptyList(), 1).isEmpty());
		assertTrue(PartitionUtil.partition(generateList(1, 2, 3), 0).isEmpty());
		
		//Non nul values
		List<Integer> list = generateList(1, 2, 3, 4, 5);
		
		//[ [1,2], [3,4], [5] ]
		List<List<Integer>> partition1 = PartitionUtil.partition(list, 2);
		List<List<Integer>> expextedPartition1 = new ArrayList<List<Integer>>() ;
		expextedPartition1.add(generateList(1, 2));
		expextedPartition1.add(generateList(3, 4));
		expextedPartition1.add(generateList(5));
		
		//[ [1,2,3], [4,5] ]
		List<List<Integer>> partition2 = PartitionUtil.partition(list, 3);
		List<List<Integer>> expextedPartition2 = new ArrayList<List<Integer>>() ;
		expextedPartition2.add(generateList(1, 2, 3));
		expextedPartition2.add(generateList(4, 5));
		
		//[ [1], [2], [3], [4], [5] ]
		List<List<Integer>> partition3 = PartitionUtil.partition(list, 1);
		List<List<Integer>> expextedPartition3 = new ArrayList<List<Integer>>() ;
		expextedPartition3.add(generateList(1));
		expextedPartition3.add(generateList(2));
		expextedPartition3.add(generateList(3));
		expextedPartition3.add(generateList(4));
		expextedPartition3.add(generateList(5));
		
		//[ [1, 2, 3, 4, 5]]
		List<List<Integer>> partition4 = PartitionUtil.partition(list, 5);
		List<List<Integer>> expextedPartition4 = new ArrayList<List<Integer>>() ;
		expextedPartition4.add(generateList(1, 2, 3, 4, 5));
		
		//[ [1, 2, 3, 4, 5]]
		List<List<Integer>> partition5 = PartitionUtil.partition(list, 8);
		List<List<Integer>> expextedPartition5 = new ArrayList<List<Integer>>() ;
		expextedPartition5.add(generateList(1, 2, 3, 4, 5));
		
		
		/******  Assertion ****/
		
		//[ [1,2], [3,4], [5] ]
		assertEquals(expextedPartition1.size(), partition1.size());
		assertEquals(expextedPartition1.get(0), partition1.get(0));
		assertEquals(expextedPartition1.get(1), partition1.get(1));
		assertEquals(expextedPartition1.get(2), partition1.get(2));
		
		//[ [1,2,3], [4,5] ]
		assertEquals(expextedPartition2.size(), partition2.size());
		assertEquals(expextedPartition2.get(0), partition2.get(0));
		assertEquals(expextedPartition2.get(1), partition2.get(1));
		
		//[ [1], [2], [3], [4], [5] ]
		assertEquals(expextedPartition3.size(), partition3.size());
		assertEquals(expextedPartition3.get(0), partition3.get(0));
		assertEquals(expextedPartition3.get(1), partition3.get(1));
		assertEquals(expextedPartition3.get(2), partition3.get(2));
		assertEquals(expextedPartition3.get(3), partition3.get(3));
		assertEquals(expextedPartition3.get(4), partition3.get(4));
		
		//[ [1, 2, 3, 4, 5]]
		assertEquals(expextedPartition4.size(), partition4.size());
		
		//[ [1, 2, 3, 4, 5]]
		assertEquals(expextedPartition5.size(), partition5.size());
	}
	
	@Test
	public void testGenerateList()
	{
		assertEquals(3, generateList(1, 2, 3).size());
		assertTrue(2 == (Integer)generateList(1, 2, 3).get(1));
	}

	private <T> List<T> generateList(T... args)
	{
		return Arrays.asList(args);
	}

}
