package com.darrylsite.test.partition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Darryl Kpizingui
 *
 */
public class PartitionUtil 
{
	/**
	 *	partition([1,2,3,4,5], 2) retourne: [ [1,2], [3,4], [5] ]
	 *	partition([1,2,3,4,5], 3) retourne: [ [1,2,3], [4,5] ]
	 *	partition([1,2,3,4,5], 1) retourne: [ [1], [2], [3], [4], [5] ]
	 * 
	 * @param liste La liste à partitionner
	 * @param taille Nombre d'éléments dans les sous liste
	 * @return une liste de sous liste, où chaque sous liste a au maximum "taille" éléments.
	 */
	public static <T> List<List<T>> partition(List<T> liste, int taille)
	{
		if(liste == null || liste.isEmpty() || taille <= 0)
		{
			return Collections.emptyList();
		}
		
		int subArraySize = liste.size() / taille;
		boolean hasExtraElement = (liste.size() % taille) != 0;
		 
		if(hasExtraElement)
		{
			subArraySize = subArraySize +1;
		}
		
		List<List<T>> listContainer = new ArrayList<List<T>>();
		
		for(int i=0; i<subArraySize; i++)
		{
			int startSubList = i*taille;
			int endSubList = startSubList + taille;
			if(endSubList > liste.size())
			{
				endSubList = liste.size();
			}
			
			listContainer.add(liste.subList(startSubList, endSubList));
		}
		
		return listContainer;
	}
}

