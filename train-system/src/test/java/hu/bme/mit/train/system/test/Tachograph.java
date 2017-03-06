package hu.bme.mit.train.system.test;

import java.util.Calendar;
import java.util.Date;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph {
	Table<String,Integer,Integer> data = HashBasedTable.create();
	
	public void addData(int position, int speed) {
		String currentData = "2017.03.06";
		
		data.put(currentData, position, speed);

	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	
}
