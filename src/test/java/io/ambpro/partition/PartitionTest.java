package io.ambpro.partition;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Partition.
 */
public class PartitionTest 
{
	private IllegalArgumentException EmptyOrNullListException = new IllegalArgumentException("list cannot be null or empty");
	private IllegalArgumentException IllegalSizeException = new IllegalArgumentException("size of items cannot be less than 1");
	private IllegalArgumentException SizeSuperiorThenListSizeException = new IllegalArgumentException("size of items cannot be greater than the size of the list");
	private IOException OkioException = new IOException("test ok");
	private IOException NotOkioException = new IOException("test not ok");
	
    @Test
    public void testPartitionListThrowExceptionwhenListEmpty() throws IOException
    {
    	  try {
    		  Partition.partitionList(Arrays.asList(), 0);
          } catch (IllegalArgumentException e) {
              Assert.assertThat(e.getMessage(), equalTo(EmptyOrNullListException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionListThrowExceptionwhenIllegalSize() throws IOException
    {
    	  try {
    		  Partition.partitionList(Arrays.asList(1,2,3), 0);
          } catch (IllegalArgumentException e) {
              Assert.assertThat(e.getMessage(), equalTo(IllegalSizeException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionListThrowExceptionwhenSizeSuperiorThenListSize() throws IOException
    {
    	  try {
    		  Partition.partitionList(Arrays.asList(1,2,3), 4);
          } catch (IllegalArgumentException e) {
              Assert.assertThat(e.getMessage(), equalTo(SizeSuperiorThenListSizeException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionIntegerListOK() throws IOException
    {
    	  try {
    		  List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(5,9));
    		  List<List<Integer>> actualResult = Partition.partitionList(Arrays.asList(1, 2, 3, 5, 9), 3);
    		  Assert.assertEquals(expectedResult, actualResult);
              throw new IOException("test ok");
          } catch (IOException e) {
              Assert.assertThat(e.getMessage(), equalTo(OkioException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionIntegerListSizeOK() throws IOException
    {
    	  try {
              Assert.assertEquals(2, Partition.partitionList(Arrays.asList(1, 2, 3, 5, 9), 3).size());
              throw new IOException("test ok");
          } catch (IOException e) {
              Assert.assertThat(e.getMessage(), equalTo(OkioException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionIntegerListSizeNotOK() throws IOException
    {
    	  try {
              Assert.assertNotSame(3, Partition.partitionList(Arrays.asList(1, 2, 3, 5, 9, 15), 3).size());
              throw new IOException("test not ok");
          } catch (IOException e) {
              Assert.assertThat(e.getMessage(), equalTo(NotOkioException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionStringListOK() throws IOException
    {
    	  try {
    		  List<List<String>> expectedResult = Arrays.asList(Arrays.asList("nice", "to", "meet"), Arrays.asList("you", "!"));
    		  List<List<String>> actualResult = Partition.partitionList(Arrays.asList("nice", "to", "meet", "you", "!"), 3);
    		  Assert.assertEquals(expectedResult, actualResult);
              throw new IOException("test ok");
          } catch (IOException e) {
              Assert.assertThat(e.getMessage(), equalTo(OkioException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionStringListSizeOK() throws IOException
    {
    	  try {
              Assert.assertEquals(5, Partition.partitionList(Arrays.asList("nice", "to", "meet", "you", "!"), 1).size());
              throw new IOException("test ok");
          } catch (IOException e) {
              Assert.assertThat(e.getMessage(), equalTo(OkioException.getMessage()));
          }
    }
    
    @Test
    public void testPartitionStringListSizeNotOK() throws IOException
    {
    	  try {
              Assert.assertNotSame(5, Partition.partitionList(Arrays.asList("nice", "to", "meet", "you", "!"), 3).size());
              throw new IOException("test not ok");
          } catch (IOException e) {
              Assert.assertThat(e.getMessage(), equalTo(NotOkioException.getMessage()));
          }
    }
}