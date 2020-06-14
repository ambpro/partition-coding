package io.ambpro;

import java.util.Arrays;

import io.ambpro.partition.Partition;

public class Launcher {

	public static void main(String[] args) {
		System.out.println(Partition.partitionList(Arrays.asList(1,2,3,4,5), 2));
	}
}
