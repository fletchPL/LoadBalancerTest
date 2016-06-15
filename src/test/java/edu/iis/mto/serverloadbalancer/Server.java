package edu.iis.mto.serverloadbalancer;
import java.util.ArrayList;
import java.awt.List;


import org.hamcrest.Matcher;

public class Server {

	private static final double MAXIMUM_LOAD = 100.0d;
	public double currentLoadPercetage;
	public int capacity;

	
	private ArrayList<Vm> vms = new ArrayList<Vm>();
	
	
	
	public boolean contains(Vm theVm) {
	
		return vms.contains(theVm);
	}

	public Server(int capacity) {
		super();
		this.capacity = capacity;
	}

	public void addVm(Vm vm) {
	 currentLoadPercetage = (double)vm.size / (double)capacity * MAXIMUM_LOAD;
	 this.vms.add(vm);
	}

	public int countVms() {
		
		return vms.size();
	}

	

	

}
