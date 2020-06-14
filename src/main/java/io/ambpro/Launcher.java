package io.ambpro;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import io.ambpro.partition.Partition;

/**
 * @author aminboudeffa
 * @param <T>
 *
 */
public class Launcher {

	final static Logger logger = Logger.getLogger(Launcher.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		List<Integer> inputList = Arrays.asList(1,2,3,4,5);
		int size = 2;
		
		logger.info("partition(" + inputList + "," + size + ") retourne:" + Partition.partitionList(inputList, size));
	}
	
}
