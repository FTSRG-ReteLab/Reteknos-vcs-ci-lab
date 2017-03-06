package hu.bme.mit.train.system.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;


public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	Tachograph tachograph;
	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		tachograph = new Tachograph();

		sensor.overrideSpeedLimit(50);
	}
	
	@Test
	public void test1() {
		sensor.overrideSpeedLimit(10);

		Assert.assertEquals(0, controller.getReferenceSpeed());
		
		user.overrideJoystickPosition(5);

		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void test2() {
		sensor.overrideSpeedLimit(0);
		
		user.overrideJoystickPosition(4);
		controller.followSpeed();

		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}
	
	@Test
	public void Test3() {
		tachograph.addData(10, 10);
		tachograph.addData(20, 20);
	
		
		Assert.assertEquals(false,tachograph.isEmpty());
	}

	
}
