package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

@Test
public void balancingServerWithNoVms_serverStayEmpty()
{
	Server theServer = a(ServerBuilder.server().withCapacity(1));
	
	balancing(aServerListWith(theServer), anEmptyListOfVms());
	
	assertThat(theServer, CurrentLoadPercentageMatcher.hasLoadPercentageOf(0.0d));
}

@Test // test 2
public void balancingOneServerWithOneSlotCapacity_andOneVm_fillsServerWithTheVm(){
Server theServer = a(ServerBuilder.server().withCapacity(1));
	Vm theVm = a(vm().ofSize(1));
	balancing(aServerListWith(theServer), aVmsListWiht(theVm));
	
	
	assertThat(theServer, CurrentLoadPercentageMatcher.hasLoadPercentageOf(10.0d));
	assertThat("Server should contain the vm", theServer.contains(theVm));

}



private Vm[] aVmsListWiht(Vm... vms) {
	
	return vms;
}

private Vm a(VmBuilder builder) {
	// TODO Auto-generated method stub
	return builder.build();
}

private VmBuilder vm() {
	return new VmBuilder();
}

private void balancing(Server[] servers, Vm[] vms) {
	new ServerLoadBalancer().balance(servers,vms);
	
}

private Vm[] anEmptyListOfVms() {
	// TODO Auto-generated method stub
	return new Vm[0];
}

private Server a(ServerBuilder builder) {
	// TODO Auto-generated method stub
	return builder.build();
}

private Server[] aServerListWith(Server... servers) {
	// TODO Auto-generated method stub
	return servers;
}


}
