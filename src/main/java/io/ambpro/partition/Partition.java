package io.ambpro.partition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author aminboudeffa
 * @param <T>
 *
 */
public class Partition
{

    public static <T> List<List<T>> partitionList(List<T> inputList, int size) {    	
    	if (inputList == null || inputList.isEmpty()) {
    		throw new IllegalArgumentException("list cannot be null or empty");
    	}
    	if (size <= 0) {
			throw new IllegalArgumentException("size of items cannot be less than 1");
		}
    	if( size > inputList.size()) {
    		throw new IllegalArgumentException("size of items cannot be greater than the size of the list");
    	}
    	
    	final AtomicInteger counter = new AtomicInteger();
    	
        return new ArrayList<>(inputList.stream()
                .collect(Collectors.groupingBy(el -> counter.getAndIncrement()/size))
                .values());
    }

}